#include <iostream>
#include <windows.h> // for Sleep
using namespace std;

// function to show matrix
void printMatrix(int matrix[4][4], int n){
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }
}

//funcion to rotate matrix
void rotateMatrix(int matrix[4][4], int n){
    for (int i = 0; i < n; i++){
        for (int j = i; j < n - i - 1; j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[n - j - 1][i];
            matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
            matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
            matrix[j][n - i - 1] = temp;
        }
    }
}

int main(){
    const int n = 4;
    int matrix[n][n] = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };
    
    int rotations = 0;
    
    while (true) {
        // clean screen
        system("cls");  // for Windows
        cout << "Rotacao " << rotations << ":" << endl;
        printMatrix(matrix, n);
        rotateMatrix(matrix, n);
        
        // wait to rotate
        Sleep(500); // wait 500ms
        
        rotations++;
    }
    
    return 0;
}
