package Java.provaP1;

import java.time.LocalDate;

public class EntregaVeiculoCliente {
    private Veiculo veiculo;
    private OrdemServico ordemServico;
    private LocalDate dataEntrega;
    private double valorCoserto;

    public EntregaVeiculoCliente(Veiculo veiculo, OrdemServico ordemServico, LocalDate dataEntrega, double valorConcerto) {
        this.veiculo = veiculo;
        this.ordemServico = ordemServico;
        this.dataEntrega = dataEntrega;
        this.valorCoserto = valorConcerto;
    }

    public void geraEntrega() {
        System.out.println("Gerando entrega do veículo...");
        System.out.println("Data de Entrega: " + dataEntrega);
        System.out.println("Valor do Concerto: R$ " + valorCoserto);
        System.out.println(veiculo.getInformacoesCompletas());
        ordemServico.printInformacoesOS();
    }
}
