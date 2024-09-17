package Java.provaP1;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Toyota", "Corolla", "P4L2RT0", 2022, "14230", "João Paulo", "123.123.123-12");
        OrdemServico ordemServico = new OrdemServico(1, "Betinho", "Bruno Maranhão", true, false, "Barulho na roda dianteira");

        LocalDate dataEntrega = LocalDate.now();
        double valorConcerto = 1500.75;

        EntregaVeiculoCliente entrega = new EntregaVeiculoCliente(veiculo, ordemServico, dataEntrega, valorConcerto);
        entrega.geraEntrega();
    }
}
