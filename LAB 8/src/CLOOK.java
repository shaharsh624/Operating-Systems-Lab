import java.util.Scanner;

public class CLOOK {
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
        int seekTime = 0;
        int Distance = 0;
        int upperBound = Integer.MIN_VALUE;
        int lowerBound = Integer.MAX_VALUE;
        int initialHead = head;

        for(int i = 0; i < n; i ++) {
            if(requests[i] > upperBound) {
                upperBound = requests[i];
            }
            if(requests[i] < lowerBound) {
                lowerBound = requests[i];
            }
        }

        while(head < upperBound) {
            for(int i = 0; i < n; i ++) {
                if(requests[i] == head) {
                    seekTime = seekTime + Distance;
                    Distance = 0;
                }
            }
            Distance ++;
            head ++;
        }

        head = lowerBound;
        seekTime = seekTime + upperBound - lowerBound;

        while(head < initialHead) {
            for(int i = 0; i < n; i ++) {
                if(requests[i] == head) {
                    seekTime = seekTime + Distance;
                    Distance = 0;
                }
            }
            Distance ++;
            head ++;
        }
        System.out.println("\nTotal Seek Time for serving all requests: " + seekTime);
        sc.close();
    }
}
