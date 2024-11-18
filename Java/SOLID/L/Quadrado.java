//package Java.SOLID.L;

public class Quadrado extends Retangulo{
    public Quadrado(double lado){
        super(lado, lado); // Um quadrado é um retângulo onde a largura e a altura são iguais  
    }
    // Não é necessário sobrescrever o método 'area', pois o cálculo de área é o mesmo de um retângulo.
}
