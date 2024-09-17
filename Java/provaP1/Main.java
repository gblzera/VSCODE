package Java.provaP1;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Toyota", "Corolla", "ABC1234", 2020, "50000", "João Silva", "12345678901");
        OrdemServico ordemServico = new OrdemServico(1, "Carlos", "Pedro", true, false, "Barulho na roda dianteira");

        LocalDate dataEntrega = LocalDate.now();

        EntregaVeiculoCliente entrega = new EntregaVeiculoCliente(veiculo, ordemServico, dataEntrega);
        entrega.geraEntrega();
    }
}
