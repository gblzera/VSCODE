import java.util.Scanner;

public class Aula1{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int num, cont = 0, pares = 0;

        while (pares < 3){
            System.out.println("Digite um número :");
            num = scanner.nextInt();

            if (num % 2 == 0){
                pares++;
            }

            cont++;
            }
            System.out.println("O laço precisou ser repedito " + cont + " vezes.");
       }
}