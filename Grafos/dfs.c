#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_NODES 1001

typedef struct Node{
    int *vizinhos;
    int tamanho;
    int capac;
} Node;

void init_node(Node *node){
    node->tamanho = 0;
    node->capac = 2;
    node->vizinhos = (int *)malloc(node->capac * sizeof(int));
}

void add_vizinho(Node *node, int vizinho){
    if (node->tamanho == node->capac){
        node->capac *= 2;
        node->vizinhos = (int *)realloc(node->vizinhos, node->capac * sizeof(int));
    }
    node->vizinhos[node->tamanho++] = vizinho;
}

void free_node(Node *node){
    free(node->vizinhos);
}

bool dfs(Node tree[], int inicio, int alvo, bool visitados[]){
    if (inicio == alvo) {
        return true;
     }

     visitados[inicio] = true;

     for (int i = 0; i < tree[inicio].tamanho; i++){
        int vizinho = tree[inicio].vizinhos[i];
        if (!visitados[vizinho]){
            if (dfs(tree, vizinho, alvo, visitados)){
                return true;
            }
        }
     }

     return false;
}

int main(){
    int A, B;
    scanf("%d %d", &A, &B);

    Node tree[MAX_NODES];
    for (int i = 0; i < MAX_NODES; i++){
        init_node(&tree[i]);
    }

    for (int i = 0; i < A - 1; i++){
        int u, v;
        scanf("%d %d", &u, &v);
        add_vizinho(&tree[u], v);
    }

    for (int i = 0; i < B; i++){
        int a,b;
        scanf("%d %d", &a, &b);
        bool visitados[MAX_NODES] = {false};

        if (dfs(tree, a, b, visitados)){
            printf("SIM\n");
        }else{
            printf("NAO\n");
        }
    }

    for (int i = 1; i <= A; i++){
        free_node(&tree[i]);
    }

    return 0;
}