#include <stdio.h>

int main(){
    int num1 = 1, num2 = 1, proxNum = 0, n = 15;

    printf("Os primeiros %d termos da sequencia de Fibonacci eh: ", n);

    for (int i = 1; i <= n; i++){
        printf("%d ", num1);

        proxNum = num1 + num2;
        num1 = num2;
        num2 = proxNum;
    }

    printf("\n");

    return 0;
}