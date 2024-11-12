import java.util.HashMap;
import java.util.Map;

public class AlunoRepositoryImpl implements AlunoRepository {
    private Map<String, Aluno> database = new HashMap<>();

    @Override
    public void salvar(Aluno aluno) {
        database.put(aluno.getMatricula(), aluno);
        System.out.println("Aluno salvo com sucesso!" + aluno.getNome());
    }

    @Override
    public Aluno get(String matricula) {
        return database.get(matricula);
    }
}
