public class ImpressoraSimples implements Dispositivo, Impressora {

    @Override
    public void ligar() {
        System.out.println("Impressora ligada.");
    }

    @Override
    public void desligar() {
        System.out.println("Impressora desligada.");
    }

    @Override
    public void imprimir(String texto) {
        System.out.println("Imprimindo: " + texto);
    }
}
