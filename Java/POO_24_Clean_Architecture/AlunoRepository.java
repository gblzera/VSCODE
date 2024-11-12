public interface AlunoRepository {
    void salvar(Aluno aluno);
    Aluno get(String matricula);  // Corrigido para get, conforme a interface
}
