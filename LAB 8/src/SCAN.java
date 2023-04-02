import java.util.Scanner;

public class SCAN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of requests: ");
        int n = sc.nextInt();
        int[] requests = new int[n];

        for(int i = 0; i < n; i ++) {
            System.out.print("Enter Request " + (i + 1) + ": ");
            requests[i] = sc.nextInt();
        }

        System.out.print("Enter Head Location: ");
        int head = sc.nextInt();

        System.out.print("Enter Disk Size: ");
        int diskSize = sc.nextInt();

        System.out.print("\nEnter Direction\n1. Towards Lesser Requests\n2. Towards Greater Requests\n-> ");
        int direction = sc.nextInt();

        int seekTime = 0;
        boolean[] completed = new boolean[n];
        int Distance = 0;

        if (direction == 1) {
            while(head >= 0) {
                for(int i = 0; i < n; i ++) {
                    if(requests[i] == head && completed[i] == false) {
                        seekTime = seekTime + Distance;
                        Distance = 0;
                    }
                }
                Distance ++;
                head --;
            }
            while(head < diskSize) {
                for(int i = 0; i < n; i ++) {
                    if(requests[i] == head) {
                        seekTime = seekTime + Distance;
                        completed[i] = true;
                        Distance = 0;
                    }
                }
                Distance ++;
                head ++;
            }
        }

        else if (direction == 2) {
            while(head < diskSize) {
                for(int i = 0; i < n; i ++) {
                    if(requests[i] == head) {
                        seekTime = seekTime + Distance;
                        completed[i] = true;
                        Distance = 0;
                    }
                }
                Distance ++;
                head ++;
            }
            while(head >= 0) {
                for(int i = 0; i < n; i ++) {
                    if(requests[i] == head && completed[i] == false) {
                        seekTime = seekTime + Distance;
                        Distance = 0;
                    }
                }
                Distance ++;
                head --;
            }
        }
        System.out.println("\nTotal Seek Time for serving all requests: " + seekTime);
        sc.close();
    }
}
