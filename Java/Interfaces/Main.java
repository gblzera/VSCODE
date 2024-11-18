public class Main {
    public static void main(String[] args) {
        // Criação de um Triângulo
        Triangulo triangulo = new Triangulo(10, 5); // Base = 10, Altura = 5
        triangulo.setLado1(6);
        triangulo.setLado2(8);
        triangulo.setLado3(10);

        // Exibindo informações do Triângulo
        System.out.println("Figura: " + triangulo.getNomeFigura());
        System.out.println("Base: " + triangulo.getBase());
        System.out.println("Altura: " + triangulo.getAltura());
        System.out.println("Área: " + triangulo.getArea());
        System.out.println("Perímetro: " + triangulo.getPerimetro());

        System.out.println("------------------------------");

        // Criação de um Quadrado
        Quadrado quadrado = new Quadrado();
        quadrado.setLado(4); // Lado = 4

        // Exibindo informações do Quadrado
        System.out.println("Figura: " + quadrado.getNomeFigura());
        System.out.println("Lado: " + quadrado.getLado());
        System.out.println("Área: " + quadrado.getArea());
        System.out.println("Perímetro: " + quadrado.getPerimetro());
    }
}
