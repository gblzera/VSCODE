public class Animal {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private Consulta[] historico;
    private int qtdConsultas;
    private int totalConsultas;

    public Animal(String nome, String especie, String raca, int idade, int maxConsultas) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.historico = new Consulta[maxConsultas];
        this.qtdConsultas = 0;
    }

    public void adicionarConsulta(Consulta consulta) {
        if (qtdConsultas < historico.length) {
            historico[qtdConsultas++] = consulta;
        } else {
            System.out.println("Limite de consultas atingido.");
        }
    }
    public void atualizarHistorico(Consulta consulta) {
        if (totalConsultas < historico.length) {
            historico[totalConsultas++] = consulta;
            System.out.println("Histórico de tratamento atualizado.");
        } else {
            System.out.println("Histórico cheio, não é possível adicionar mais consultas.");
        }
    }

    public void exibirHistorico() {
        System.out.println("Histórico de Tratamento para " + nome + ":");
        for (int i = 0; i < totalConsultas; i++) {
            if (historico[i] != null) {
                System.out.println("Data: " + historico[i].getData() + 
                                   ", Sintomas: " + historico[i].getSintomas() + 
                                   ", Diagnóstico: " + historico[i].getDiagnostico());
            }
        }
    }

    public Consulta[] getHistorico() {
        return historico;
    }

    public String getNome() {
        return nome;
    }
}
