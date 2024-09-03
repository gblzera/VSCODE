#include <stdio.h>

int main(){
    int vetor[8];
    int x, y;
    int soma;

    printf("Digite os 8 valores do vetor: \n");
    for (int i = 0; i < 8; i++){
        scanf("%d", &vetor[i]);
    }

    printf("Digite o valor de x (0-7): ");
    scanf("%d", &x);
    printf("Digite o valor de y (0-7): ");
    scanf("%d", &y);

    soma = vetor[x] + vetor[y];

    printf("A soma dos valores encontrados nas posicoes %d e %d eh: %d", x,y,soma);
}