public class Computador implements Dispositivo, Impressora, Scanner {

    @Override
    public void ligar() {
        System.out.println("Computador ligado.");
    }

    @Override
    public void desligar() {
        System.out.println("Computador desligado.");
    }

    @Override
    public void imprimir(String texto) {
        System.out.println("Imprimindo texto: " + texto);
    }

    @Override
    public void escanear() {
        System.out.println("Escaneando documento.");
    }
}
