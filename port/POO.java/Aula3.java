import java.util.Scanner;

public class Aula3 {
    public static void main(String [] args){
        int num1 = 0;
        int num2 = 1;
        int proxNum;
        int n = 15;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Os primeiros 15 termos da sequência de Fibonacci são :");
        System.out.println(num1);
        System.out.println(num2);
        for (int i = 2; i < n; i++){
            proxNum = num1 + num2;
            num1 = num2;
            num2 = proxNum;
            System.out.println(proxNum);
        }
    }
}
