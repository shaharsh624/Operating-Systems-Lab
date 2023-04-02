import java.util.Scanner;

public class CSCAN {
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

        int initialHead = head;
        int seekTime = 0;
        int Distance = 0;

        while(head < diskSize) {
            for(int i = 0; i < n; i ++) {
                if(requests[i] == head) {
                    seekTime = seekTime + Distance;
                    Distance = 0;
                }
            }
            Distance ++;
            head ++;
        }

        seekTime = seekTime + diskSize;
        head = 0;

        while(head <= initialHead) {
            for(int i = 0; i < n; i ++) {
                if(requests[i] == head) {
                    seekTime = seekTime + Distance;
                    Distance = 0;
                }
            }
            Distance ++;
            head ++;
        }
        System.out.println("\nTotal Seek Time for serving all requests is " + seekTime);
        sc.close();
    }
}
