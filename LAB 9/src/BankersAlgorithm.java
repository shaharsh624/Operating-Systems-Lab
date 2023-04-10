import java.util.Scanner;

public class BankersAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int P = scanner.nextInt();
        int R = scanner.nextInt();

        int processes[] = new int[P];
        for (int i = 0; i < P; i++) {
            processes[i] = i;
        }

        int avail[] = new int[R];
        for (int i = 0; i < R; i++) {
            avail[i] = scanner.nextInt();
        }

        int max[][] = new int[P][R];
        for (int i = 0; i < P; i++) {
            for (int j = 0; j < R; j++) {
                max[i][j] = scanner.nextInt();
            }
        }

        int allot[][] = new int[P][R];
        for (int i = 0; i < P; i++) {
            for (int j = 0; j < R; j++) {
                allot[i][j] = scanner.nextInt();
            }
        }

        if (isSafe(processes, avail, max, allot)) {
            System.out.println("System is in safe state.");
        } else {
            System.out.println("System is not in safe state.");
        }

        scanner.close();
    }

    public static void calculateNeed(int need[][], int max[][], int allot[][]) {
        int P = need.length;
        int R = need[0].length;
        for (int i = 0; i < P; i++) {
            for (int j = 0; j < R; j++) {
                need[i][j] = max[i][j] - allot[i][j];
            }
        }
    }

    public static boolean isSafe(int processes[], int avail[], int max[][], int allot[][]) {
        int P = processes.length;
        int R = avail.length;
        int need[][] = new int[P][R];
        calculateNeed(need, max, allot);
        boolean finish[] = new boolean[P];
        boolean found;
        int safeSeq[] = new int[P];
        int work[] = new int[R];
        for (int i = 0; i < R; i++) {
            work[i] = avail[i];
        }
        int count = 0;
        while (count < P) {
            found = false;
            for (int i = 0; i < P; i++) {
                if (!finish[i]) {
                    int j;
                    for (j = 0; j < R; j++) {
                        if (need[i][j] > work[j]) {
                            break;
                        }
                    }
                    if (j == R) {
                        for (int k = 0; k < R; k++) {
                            work[k] += allot[i][k];
                        }
                        safeSeq[count++] = i;
                        finish[i] = true;
                        found = true;
                    }
                }
            }
            if (!found) {
                return false;
            }
        }
        for (int i = 0; i < P; i++) {
            System.out.print(safeSeq[i] + " ");
        }
        System.out.println();
        return true;
    }
}
