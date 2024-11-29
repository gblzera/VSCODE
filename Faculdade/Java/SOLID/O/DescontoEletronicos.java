public class DescontoEletronicos extends Desconto {
    @Override
    public double calcular(double preco) {
        return preco * 0.90; // 10% de desconto
    }
}
