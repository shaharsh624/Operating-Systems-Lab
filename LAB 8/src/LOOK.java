import java.util.Scanner;

public class LOOK {
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
        boolean[] completed = new boolean[n];
        int Distance = 0;
        int upperBound = Integer.MIN_VALUE;
        int lowerBound = Integer.MAX_VALUE;

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
                    completed[i] = true;
                    Distance = 0;
                }
            }
            Distance ++;
            head ++;
        }

        while(head >= lowerBound) {
            for(int i = 0; i < n; i ++) {
                if(requests[i] == head && completed[i] == false) {
                    seekTime = seekTime + Distance;
                    Distance = 0;
                }
            }
            Distance ++;
            head --;
        }
        System.out.println("Total Seek Time for serving all requests is " + seekTime);
        sc.close();
    }
}
