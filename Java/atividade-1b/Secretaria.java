public class Secretaria {
    private String nome;
    private int id;

    public Secretaria(String nome, int id) {
        this.nome = nome;
        this.id = id;
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
        System.out.println("Consulta agendada para " + data + " com o animal " + animal.getNome());
    }
}
