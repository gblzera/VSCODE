import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome do gato(a): ");
        String name = scanner.nextLine();

        System.out.print("Informe a idade do gato(a): ");
        int age = scanner.nextInt();

        Cat cat = new Cat(name, age);

        System.out.println("Nome: " + cat.getName());
        System.out.println("Idade: " + cat.getAge());

        System.out.print("Informe uma nova idade (deve ser positiva):");
        int newAge = scanner.nextInt();
        cat.setAge(newAge);

        cat.makeSound();

        Common.printDivider();
    }
}