public class Secretaria {
    private final String nome;
    private final int id;

    public Secretaria(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public int getId(){
        return id;
    }

    public void atualizarCadastroCliente(Cliente cliente, String novoEndereco, String novoTelefone) {
        cliente.setEndereco(novoEndereco);
        cliente.setTelefone(novoTelefone);
        System.out.println("Cadastro do cliente atualizado com sucesso.");
    }

    public void agendarConsulta(Cliente cliente, Animal animal, String data) {
        Consulta novaConsulta = new Consulta();
        novaConsulta.setData(data);
        animal.adicionarConsulta(novaConsulta);
        System.out.printf("Consulta agendada para %s com o animal %s pela secretária %s (ID: %d)\n",
        data, animal.getNome(), this.nome, this.id);
    }
}
