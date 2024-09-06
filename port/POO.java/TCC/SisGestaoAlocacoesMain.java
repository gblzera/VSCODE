package TCC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SisGestaoAlocacoesMain {
    
    private static List<Aluno> alunosRegistrados = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Gestão de Alocações de TCC!");
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Login");
            System.out.println("2. Registrar");
            System.out.println("3. Sair");
            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                realizarLogin(scanner);
            } else if (opcao.equals("2")) {
                realizarRegistro(scanner);
            } else if (opcao.equals("3")) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }

        scanner.close();
    }

    private static void realizarLogin(Scanner scanner) {
        System.out.print("Digite sua matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Aluno alunoLogado = null;
        for (Aluno aluno : alunosRegistrados) {
            if (aluno.getMatricula().equals(matricula) && aluno.getSenha().equals(senha)) {
                alunoLogado = aluno;
                break;
            }
        }

        if (alunoLogado != null) {
            System.out.println("Login realizado com sucesso. Bem-vindo, " + alunoLogado.getNome() + "!");
        } else {
            System.out.println("Matrícula ou senha incorretos.");
        }
    }

    private static void realizarRegistro(Scanner scanner) {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Digite seu curso: ");
        String curso = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Aluno novoAluno = new Aluno(nome, matricula, email, curso, senha);
        alunosRegistrados.add(novoAluno);

        System.out.println("Registro realizado com sucesso!");
    }
}

class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class Aluno extends Pessoa {
    private String matricula;
    private String email;
    private String curso;
    private String senha;

    public Aluno(String nome, String matricula, String email, String curso, String senha) {
        super(nome);
        this.matricula = matricula;
        this.email = email;
        this.curso = curso;
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
