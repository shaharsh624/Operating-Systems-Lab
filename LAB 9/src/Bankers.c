#include<stdio.h>
#include<stdbool.h>

int P = 5;
int R = 3;

//finding needs of each process
void calculateNeed(int need[P][R], int max[P][R], int allot[P][R]) {   
    for (int i = 0 ; i < P ; i++) {
        for (int j = 0 ; j < R ; j++) {
            need[i][j] = max[i][j] - allot[i][j];
        }
    
    }
}

// Function to find the system is in safe state or not
bool isSafe(int processes[], int avail[], int max[P][R], int allot[P][R]) {
    int need[P][R];
    calculateNeed(need, max, allot);
   
    bool finish[5] = {0,0,0,0,0};
    bool found;
    int safeSeq[P];
    
    int work[R];
    for (int i = 0; i < R ; i++){
        work[i] = avail[i];
    }
    
    int count = 0;
    while (count < P) {
        found = false;
        for (int i = 0; i < P; i++) {
            if (finish[i] == 0) {
                int j;
                for (j = 0; j < R; j++) {
                    if (need[i][j] > work[j]) {
                        break;
                    }
                }
                
                if (j == R) {
                    
                    for (int k = 0 ; k < R ; k++) {
                        work[k] += allot[i][k];
                    }
                    
                    safeSeq[count++] = i;
                    finish[i] = 1;
                    found = true;
                }
            }
        }
    }
    
    if (found == false) {
        printf("System is not in safe state");
        return false;
    }
    
    printf("System is in safe state.\n");
    printf("Safe sequence is: ");
    for (int i = 0; i < P ; i++) {
      printf("%d ", safeSeq[i]);   
    }
    return true;
}

void main() {
    int processes[] = {0, 1, 2, 3, 4};
    
    // Available marix
    int avail[] = {3, 3, 2};
    
    // max matrix
    int max[5][3] = {
    {7, 5, 3},
    {3, 2, 2},
    {9, 0, 2},
    {2, 2, 2},
    {4, 3, 3}};
    
    // allotted matrix
    int allot[5][3] = {
    {0, 1, 0},
    {2, 0, 0},
    {3, 0, 2},
    {2, 1, 1},
    {0, 0, 2}};
    
    isSafe(processes, avail, max, allot);
}