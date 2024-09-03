#include <stdio.h>

int main() {
    int num, cont = 0, pares = 0;

    while (pares < 3) {
        printf("Digite um numero: ");
        scanf("%d", &num);

        if (num % 2 == 0) {
            pares++;
        }

        cont++;
    }

    printf("O laço precisou ser repetido %d vezes.\n", cont);

    return 0;
}