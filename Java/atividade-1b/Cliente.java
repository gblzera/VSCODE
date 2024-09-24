public class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private Animal[] animais;
    private int qtdAnimais;

    public Cliente(String nome, String endereco, String telefone, int maxAnimais) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.animais = new Animal[maxAnimais];
        this.qtdAnimais = 0;
    }

    public void adicionarAnimal(Animal animal) {
        if (qtdAnimais < animais.length) {
            animais[qtdAnimais++] = animal;
        } else {
            System.out.println("Limite de animais atingido.");
        }
    }

    public Animal[] getAnimais() {
        return animais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
