import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nome;
    private List<Double> notas;

    public Materia(String nome) {
        this.nome = nome;
        this.notas = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public List<Double> getNotas() { return notas; }

    public void addNota(double nota) {
        this.notas.add(nota);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return notas.size() > 0 ? soma / notas.size() : 0;
    }
}
