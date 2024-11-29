//package Java.SOLID.S;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Funcionario {
    
    private Integer id;
    private String nome;
    private Double salario;
    private Connection connection;

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    // Método para calcular bonificação (exemplo: 10% do salário)
    public Double calcularBonificacao() {
        return this.salario * 0.10; // 10% de bonificação
    }
    
    public Double calcularSalarioComBonificacao() {
        return this.salario + calcularBonificacao();
    }

    // Método para calcular salário após impostos
    public Double calculaSalario() {
        return this.salario - (this.salario * 0.225);
    }

    // Método para salvar no banco de dados
    public void salva() throws SQLException {
        this.connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/empresa?useSSL=false", 
            "root", 
            ""
        ); 
        Statement stmt = this.connection.createStatement();
        String sql = "INSERT INTO funcionario (id, nome, salario) VALUES (" 
            + this.id + ", '" 
            + this.nome + "', " 
            + this.salario + ")";
        
        int rs = stmt.executeUpdate(sql);
        
        if (rs == 1) {
            System.out.println("Funcionário inserido com sucesso.");
        } else {
            System.out.println("Nenhum funcionário foi inserido.");
        }
    }
}
