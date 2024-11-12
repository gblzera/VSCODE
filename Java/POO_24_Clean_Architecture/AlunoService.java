public class AlunoService {
    private AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public void addAluno(Aluno aluno) {
        repository.salvar(aluno);
    }

    public Aluno getAluno(String matricula) {
        return repository.get(matricula);
    }

    public double calcularMedia(String matricula) {
        Aluno aluno = getAluno(matricula);
        if (aluno == null) return 0;

        double soma = 0;
        int totalMaterias = aluno.getMaterias().size();  // Corrigido aqui para getMaterias
        for (Materia materia : aluno.getMaterias()) {
            soma += materia.calcularMedia();
        }
        return totalMaterias > 0 ? soma / totalMaterias : 0;
    }
}
