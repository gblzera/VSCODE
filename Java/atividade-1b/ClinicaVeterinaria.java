public class ClinicaVeterinaria {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Gabriel", "CLN 114", "99148-7407", 2);
        Animal animal = new Animal("Chloe", "Gata", "SRD", 5, 10);
        cliente.adicionarAnimal(animal);

        Secretaria secretaria = new Secretaria("Ana", 1);

        secretaria.atualizarCadastroCliente(cliente, "Rua B", "88888-8888");

        secretaria.agendarConsulta(cliente, animal, "25/09/2024");

        Veterinario veterinario = new Veterinario("Dr. Lucas", 101, "Clínica Geral", 20);

        veterinario.realizarConsulta(animal, "25/09/2024", "Tosse e febre", "Infecção respiratória");

        veterinario.marcarExame(animal, "Raio-X");

        animal.exibirHistorico();
    }
}
