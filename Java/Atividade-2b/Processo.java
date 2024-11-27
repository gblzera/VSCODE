import java.util.ArrayList;

public class Processo {
    private String numeroProcesso;
    private Cliente cliente;
    private Cliente parteContraria;
    private Advogado advogadoCliente;
    private Advogado advogadoParteContraria;
    private ArrayList<Audiencia> audiencias = new ArrayList<>();
    private ArrayList<Custo> custos = new ArrayList<>();

    public Processo(String numeroProcesso, Cliente cliente, Cliente parteContraria, Advogado advogadoCliente, Advogado advogadoParteContraria) {
        this.numeroProcesso = numeroProcesso;
        this.cliente = cliente;
        this.parteContraria = parteContraria;
        this.advogadoCliente = advogadoCliente;
        this.advogadoParteContraria = advogadoParteContraria;
    }

    public void adicionarAudiencia(Audiencia audiencia) {
        audiencias.add(audiencia);
    }

    public void adicionarCusto(Custo custo) {
        custos.add(custo);
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    @Override
    public String toString() {
        return "Processo:\n" +
               "  Número do Processo: " + numeroProcesso + "\n" +
               "  Autor: " + cliente + "\n" +
               "  Réu: " + parteContraria + "\n" +
               "  Advogado do Autor: " + advogadoCliente + "\n" +
               "  Advogado da Réu: " + advogadoParteContraria + "\n" +
               "  Audiências: " + audiencias + "\n" +
               "  Custos: " + custos + "\n";
    }
}
