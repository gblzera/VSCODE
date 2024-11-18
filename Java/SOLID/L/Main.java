//package Java.SOLID.L;

public class Main {
    public static void main(String[] args) {
        Forma retangulo = new Retangulo(5,10);
        Forma quadrado = new Quadrado(5);

        System.out.println("Área do retângulo: " + retangulo.area());
        System.out.println("Área do quadrado: " + quadrado.area());
    }
}
