public class Veterinario {
    private String nome;
    private int id;
    private String especialidade;
    private Consulta[] consultas;
    private int qtdConsultas;

    public Veterinario(String nome, int id, String especialidade, int maxConsultas) {
        this.nome = nome;
        this.id = id;
        this.especialidade = especialidade;
        this.consultas = new Consulta[maxConsultas];
        this.qtdConsultas = 0;
    }

    public void realizarConsulta(Animal animal, String data, String sintomas, String diagnostico) {
        if (qtdConsultas < consultas.length) {
            Consulta novaConsulta = new Consulta();
            novaConsulta.setData(data);
            novaConsulta.setSintomas(sintomas);
            novaConsulta.setDiagnostico(diagnostico);
    
            animal.atualizarHistorico(novaConsulta);
            consultas[qtdConsultas++] = novaConsulta;
            System.out.println("Consulta realizada com sucesso pelo veterinário " + nome);
        } else {
            System.out.println("Limite de consultas atingido.");
        }
    }
    

    public void marcarExame(Animal animal, String tipoExame) {
        Consulta[] historico = animal.getHistorico();
    
        if (historico != null && historico.length > 0) {
            Consulta consultaAtual = null;
    
            for (int i = historico.length - 1; i >= 0; i--) {
                if (historico[i] != null) {
                    consultaAtual = historico[i];
                    break;
                }
            }
    
            if (consultaAtual != null) {
                consultaAtual.marcarExame(tipoExame);
                System.out.println("Exame marcado com sucesso para o animal " + animal.getNome());
            } else {
                System.out.println("Nenhuma consulta encontrada para marcar exame.");
            }
        } else {
            System.out.println("Nenhuma consulta encontrada para marcar exame.");
        }
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
