import java.util.Scanner;

public class Aula3 {
    public static void main(String [] args){
        int num1 = 0;
        int num2 = 1;
        int proxNum = 0;
        int n = 15;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Os primeiros 15 termos da sequência de Fibonacci são :");
        System.out.println(num1 + num2);
        for (int i = 1; i < n; i++){
            proxNum = num1 + num2;
            num1 = num2;
            num2 = proxNum;
            System.out.println(proxNum);
        }
    }
}
