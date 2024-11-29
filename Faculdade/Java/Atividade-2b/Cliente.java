public class Cliente {
    private String nome;
    private String tipo; // Física ou Jurídica
    private String cpfOuCnpj;

    public Cliente(String nome, String tipo, String cpfOuCnpj) {
        this.nome = nome;
        this.tipo = tipo;
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    @Override
    public String toString() {
        return nome + " (" + tipo + ", " + cpfOuCnpj + ")";
    }
}
