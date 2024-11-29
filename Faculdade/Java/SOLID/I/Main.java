public class Main {
    public static void main(String[] args) {
        // Instanciando as classes
        Dispositivo computador = new Computador();
        computador.ligar();
        ((Computador) computador).imprimir("Relatório");
        ((Computador) computador).escanear();
        computador.desligar();

        System.out.println();

        Dispositivo impressora = new ImpressoraSimples();
        impressora.ligar();
        ((ImpressoraSimples) impressora).imprimir("Documento");
        impressora.desligar();
    }
}
