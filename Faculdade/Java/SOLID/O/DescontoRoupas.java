public class DescontoRoupas extends Desconto {
    @Override
    public double calcular(double preco) {
        return preco * 0.85; // 15% de desconto
    }
}
