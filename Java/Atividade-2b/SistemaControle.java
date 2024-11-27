import java.util.ArrayList;
import java.time.LocalDate;

public class SistemaControle {
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Advogado> advogados = new ArrayList<>();
    ArrayList<Processo> processos = new ArrayList<>();

    public void cadastrarCliente(String nome, String tipo, String cpfOuCnpj) {
        Cliente cliente = new Cliente(nome, tipo, cpfOuCnpj);
        clientes.add(cliente);
    }

    public void cadastrarAdvogado(String nome, String oab) {
        Advogado advogado = new Advogado(nome, oab);
        advogados.add(advogado);
    }

    public void cadastrarProcesso(String numeroProcesso, Cliente cliente, Cliente parteContraria, Advogado advogadoCliente, Advogado advogadoParteContraria) {
        Processo processo = new Processo(numeroProcesso, cliente, parteContraria, advogadoCliente, advogadoParteContraria);
        processos.add(processo);
    }

    public void cadastrarAudiencia(String numeroProcesso, String data, String descricao) {
        LocalDate dataFormatada = LocalDate.parse(data); // Converte a String para LocalDate
        for (Processo processo : processos) {
            if (processo.getNumeroProcesso().equals(numeroProcesso)) {
                Audiencia audiencia = new Audiencia(dataFormatada, descricao);
                processo.adicionarAudiencia(audiencia);
                return;
            }
        }
    }

    public void cadastrarCusto(String numeroProcesso, String descricao, double valor) {
        for (Processo processo : processos) {
            if (processo.getNumeroProcesso().equals(numeroProcesso)) {
                Custo custo = new Custo(descricao, valor);
                processo.adicionarCusto(custo);
                return;
            }
        }
    }

    public void listarProcessos() {
        for (Processo processo : processos) {
            System.out.println(processo);
        }
    }

    public static void main(String[] args) {

        System.out.println("Gabriel Henrique Kuhn Paz - 2212082043");
        SistemaControle sistema = new SistemaControle();

        // Cadastro de Clientes
        sistema.cadastrarCliente("Batman", "Física", "332.654.499-00");
        sistema.cadastrarCliente("Super-man", "Física", "777.345.200-20");

        // Cadastro de Advogados
        sistema.cadastrarAdvogado("Lex Luthor", "OAB-22911");
        sistema.cadastrarAdvogado("Coringa", "OAB-02034");

        // Cadastro de Processo
        sistema.cadastrarProcesso(
            "0000863-53.2022.5.10.0010",
            sistema.clientes.get(0),
            sistema.clientes.get(1),
            sistema.advogados.get(0),
            sistema.advogados.get(1)
        );

        // Cadastro de Audiência
        sistema.cadastrarAudiencia("0000863-53.2022.5.10.0010", "2024-12-20", "Audiência de conciliação");

        // Cadastro de Custo
        sistema.cadastrarCusto("0000863-53.2022.5.10.0010", "Taxa de serviço", 7500000.00);

        // Listar Processos
        sistema.listarProcessos();

        
    }
}
