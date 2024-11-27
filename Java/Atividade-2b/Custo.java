public class Custo {
    private String descricao;
    private double valor;

    public Custo(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return descricao + " - R$" + valor;
    }
}
