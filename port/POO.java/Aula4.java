import java.util.Scanner;

public class Aula4 {
    public static void main(String[] args){
        int vel_mot;
        int vel_max = 80;
        int multa_km = 5;
        int bolso_do_detran = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Me fala ai paizão, tava a quantos km/h ?");
        vel_mot = scanner.nextInt();

        if (vel_mot > vel_max){
            int detran = vel_mot - vel_max;
            bolso_do_detran = detran * multa_km;
        }

        System.out.printf("Ayrton Senna estava a %d km/h\n", vel_mot);
        if(bolso_do_detran > 0){
            System.out.println("Vai ter multa seninha\n");
            System.out.printf("O bolso do detran ganhou de você : R$ %d,00\n", bolso_do_detran);
        }else{
            System.out.println("Vai não ter multa seninha\n");
        }
    }
}