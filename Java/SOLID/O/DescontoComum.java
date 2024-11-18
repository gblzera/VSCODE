public class DescontoComum extends Desconto {
    @Override
    public double calcular(double preco) {
        return preco; // Sem desconto
    }
}
