public class Advogado {
    private String nome;
    private String oab;

    public Advogado(String nome, String oab) {
        this.nome = nome;
        this.oab = oab;
    }

    @Override
    public String toString() {
        return nome + " (OAB: " + oab + ")";
    }
}
