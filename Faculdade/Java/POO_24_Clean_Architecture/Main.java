public class Main {
    public static void main(String[] args) {
        // Inicializando o repositório e o serviço
        AlunoRepository alunoRepo = new AlunoRepositoryImpl();  // Repositório
        AlunoService alunoService = new AlunoService(alunoRepo);  // Serviço

        // Criando aluno e matérias
        Aluno aluno1 = new Aluno("Gabriel", "2022A01");  // Criando aluno
        Materia calculo = new Materia("Cálculo");
        calculo.addNota(7.5);
        calculo.addNota(8.0);

        Materia metodosMatematicos = new Materia("Métodos Matemáticos");
        metodosMatematicos.addNota(8.5);
        metodosMatematicos.addNota(9.0);

        aluno1.addMateria(metodosMatematicos);  // Adicionando matérias
        aluno1.addMateria(calculo);

        // Salvando o aluno no repositório
        alunoService.addAluno(aluno1);

        // Calculando a média do aluno
        double mediaGeral = alunoService.calcularMedia("2022A01");  // Usando a matrícula correta
        System.out.println("Média Geral de " + aluno1.getNome() + ": " + mediaGeral);
    }
}
