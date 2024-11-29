//package Java.SOLID.S;
public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Gabriel");
        funcionario.setSalario(2100.00);

        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Salário: R$" + funcionario.getSalario());
        System.out.println("Bonificação: R$" + funcionario.calcularBonificacao());
        System.out.println("Salário com bonificação: R$" + funcionario.calcularSalarioComBonificacao());
    }
}
