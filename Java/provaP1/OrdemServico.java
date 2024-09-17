package Java.provaP1;

public class OrdemServico {
    private int numeroOS;
    private String nomeResponsavelTecnico;
    private String nomeMecanico;
    private boolean isAutorizadaLavagem;
    private boolean isOSFinalizada;
    private String relatosDefeitoCliente;

    public OrdemServico(int numeroOS, String nomeResponsavelTecnico, String nomeMecanico, boolean isAutorizadaLavagem, boolean isOSFinalizada, String relatosDefeitoCliente) {
        this.numeroOS = numeroOS;
        this.nomeResponsavelTecnico = nomeResponsavelTecnico;
        this.nomeMecanico = nomeMecanico;
        this.isAutorizadaLavagem = isAutorizadaLavagem;
        this.isOSFinalizada = isOSFinalizada;
        this.relatosDefeitoCliente = relatosDefeitoCliente;
    }

    public void cadastraOS(Veiculo veiculo) {
        System.out.println("Ordem de serviço cadastrada para o veículo com placa: " + veiculo.getPlaca());
    }

    public void printInformacoesOS() {
        System.out.println("Número da OS: " + numeroOS);
        System.out.println("Nome do responsável técnico: " + nomeResponsavelTecnico);
        System.out.println("Nome do mecânico: " + nomeMecanico);
        System.out.println("Autorizada Lavagem: " + (isAutorizadaLavagem ? "Sim" : "Não"));
        System.out.println("OS Finalizada: " + (isOSFinalizada ? "Sim" : "Não"));
        System.out.println("Relatos do Defeito: " + relatosDefeitoCliente);
    }
}