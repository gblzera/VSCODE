import java.util.Scanner;

public class Aula2 {
    public static void main(String[] args){
        int [] vetor = new int[8];
        int x, y;
        int soma;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite 8 valores inteiros:");
        for (int i = 0; i < 8; i++){
            vetor[i] = scanner.nextInt();
        }

        System.out.println("Digite o valor de x (0-7): ");
        x = scanner.nextInt();
        System.out.println("Digite o valor de y (0-7): ");
        y = scanner.nextInt();

        soma = vetor[x] + vetor[y];

        System.out.printf("A soma dos valores encontrados nas posições %d e %d é: %d%n", x, y, soma);   
     }
}
