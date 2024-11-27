import java.time.LocalDate;

public class Audiencia {
    private LocalDate data;
    private String descricao;

    public Audiencia(LocalDate data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Descrição: " + descricao;
    }
}
