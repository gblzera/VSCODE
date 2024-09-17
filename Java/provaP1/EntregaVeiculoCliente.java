package Java.provaP1;

import java.time.LocalDate;

public class EntregaVeiculoCliente {
    private Veiculo veiculo;
    private OrdemServico ordemServico;
    private LocalDate dataEntrega;

    public EntregaVeiculoCliente(Veiculo veiculo, OrdemServico ordemServico, LocalDate dataEntrega) {
        this.veiculo = veiculo;
        this.ordemServico = ordemServico;
        this.dataEntrega = dataEntrega;
    }

    public void geraEntrega() {
        System.out.println("Gerando entrega do veículo...");
        System.out.println("Data de Entrega: " + dataEntrega);
        System.out.println(veiculo.getInformacoesCompletas());
        ordemServico.printInformacoesOS();
    }
}
