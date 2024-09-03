#include <stdio.h>

int main(){
    int vel_mot;
    int vel_max = 80;
    int multa_km = 5;
    int leao_da_receita = 0;

    printf("Informe a velocidade do motorista (em km/h): ");
    scanf("%d", &vel_mot);

    if (vel_mot > vel_max){
        int olha_o_leao = vel_mot - vel_max;
        leao_da_receita = olha_o_leao * multa_km; 
    }

    printf("Velocidade do motorista %d km/h\n", vel_mot);
    if (leao_da_receita > 0){
        printf("Vai ter multa coitado\n");
        printf("Detran vai arrecadar de vc : R$ %d,00\n", leao_da_receita);
    }else{
        printf("Deu sorte paizao, nao foi dessa vez\n");
    }

    return 0;
}