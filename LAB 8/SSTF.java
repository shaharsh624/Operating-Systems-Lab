import java.util.Scanner;

public class SSTF {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of requests: ");
        int n = input.nextInt();
        int[] requests = new int[n];

        for(int i = 0; i < n; i ++) {
            System.out.print("Enter Request " + (i + 1) + ": ");
            requests[i] = input.nextInt();
            System.out.println();
        }

        System.out.print("Enter Head location: ");
        int head = input.nextInt();
        int seekTime = 0;
        int completedProcess = 0;
        int shortestRequest = -1;
        boolean[] completed = new boolean[n];

        while(completedProcess < n) {
            int shortestDistance = Integer.MAX_VALUE;
            for(int i = 0; i < n; i ++) {
                if(completed[i] == false) {
                    if((head - requests[i])  > 0) {
                        if((head - requests[i]) < shortestDistance) {
                            shortestDistance = head - requests[i];
                            shortestRequest = i;
                        }
                    }
                    else {
                        if((requests[i] - head) < shortestDistance) {
                            shortestDistance = requests[i] - head;
                            shortestRequest = i;
                        }
                    }
                }
            }
            completed[shortestRequest] = true;
            seekTime = seekTime + shortestDistance;
            completedProcess ++;
            head = requests[shortestRequest];
        }

        System.out.println("Total Seek Time for serving all requests is " + seekTime);
        input.close();
    }
}
