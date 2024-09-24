from flask import Flask, request, jsonify
from flask_sqlalchemy import SQLAlchemy
from datetime import datetime

app = Flask(__name__)

#configurar o BD SQLite
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///todo.db'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
db = SQLAlchemy(app)

class Tarefa(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    title = db.Column(db.String(255), nullable=False)
    description = db.Column(db.Text, nullable=False)
    is_completed = db.Column(db.Boolean, default=False)
    created_at = db.Column(db.DateTime, default=datetime.utcnow)

    def to_dict(self):
        return{
            'id': self.id,
            'title': self.title,
            'description': self.description,
            'is_completed': self.is_completed,
            'created_at': self.created_at
        }
    
#criar as tabelas

with app.app_context():
     db.create_all()

#rotas do API
@app.route('/tarefas', methods=['POST'])
def get_tarefa():
    tarefas = Tarefa.query.all()
    return jsonify([tarefa.to_dict() for tarefa in tarefas])

@app.route('/tarefas', methods=['POST'])
def criar_tarefa():
    data = request.get_json()
    nova_tarefa = Tarefa(
        title=data.get('title'),
        description=data.get('description')
    )
    db.session.add(nova_tarefa)
    db.session.commit()
    return jsonify(nova_tarefa.to_dict()), 201

@app.route('/tarefas/<int:tarefa_id>', methods=['PUT'])
def atualizar_tarefa(tarefa_id):
    tarefa = Tarefa.query.get_or_404(tarefa_id)
    data = request.get_json()
    tarefa.title = data.get('title', tarefa.title)
    tarefa.description = data.get('description', tarefa.description)
    tarefa.is_completed = data.get('is_completed', tarefa.is_completed)
    db.session.commit()
    return jsonify(tarefa.to_dict())

@app.route('/tarefas/<int:tarefa_id>', methods=['DELETE'])
def deletar_tarefa(tarefa_id):
    tarefa = Tarefa.query.get_or_404(tarefa_id)
    db.session.delete(tarefa)
    db.session.commit()
    return '', 204

@app.route('/')
def home():
    return "<h1>Bem-vindo à To Do List API!</h1>"

if __name__ == '__main__':
    app.run(debug=True)