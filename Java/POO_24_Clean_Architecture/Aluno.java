import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private String matricula;
    private List<Materia> materias;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.materias = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public List<Materia> getMaterias() { return materias; }

    public void addMateria(Materia materia) {
        this.materias.add(materia);
    }
}
