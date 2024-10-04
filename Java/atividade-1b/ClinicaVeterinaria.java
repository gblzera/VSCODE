public class ClinicaVeterinaria {
    public static void main(String[] args) {

        System.out.println("Gabriel Henrique Kuhn Paz - 2212082043");
        System.out.println("POO - 2/2024");

        Cliente cliente = new Cliente("Gabriel", "CLN 114", "99148-7407", 2);
        Animal animal = new Animal("Chloe", "Gata", "SRD", 5, 10);
        Animal animal2 = new Animal("Brie", "Cachorro", "Border Collie", 2, 8);
        cliente.adicionarAnimal(animal);
        cliente.adicionarAnimal(animal2);

        Secretaria secretaria = new Secretaria("Judiscleide", 1);
        Secretaria secretaria2 = new Secretaria("Endrika", 2);

        secretaria.atualizarCadastroCliente(cliente, "Rua B", "88888-8888");

        secretaria.agendarConsulta(cliente, animal, "30/09/2024");
        secretaria2.agendarConsulta(cliente, animal2, "01/10/2024");

        Veterinario veterinario = new Veterinario("Dra. Letícia", 69, "Clínica Geral", 20);
        Veterinario veterinario2 = new Veterinario("Dr. Carlos", 101, "Ortopedista");

        veterinario.realizarConsulta(animal, "30/09/2024", "Tosse e febre", "Infecção respiratória");
        veterinario.marcarExame(animal, "Raio-X de tórax");

        veterinario2.realizarConsulta(animal2, "01/10/2024", "Dor no Quadril", "Osso do cocs quebrado");
        veterinario2.marcarExame(animal2, "Raio-X");

        animal.exibirHistorico();
        animal2.exibirHistorico();
    }
}
