import java.util.Arrays;
import java.util.Scanner;

public class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input no. of requests
        System.out.print("Enter number of requests: ");
        int n = sc.nextInt();

        int[] requests = new int[n];

        // Input requests Value
        for (int i=1 ; i<=n ; i++) {
            System.out.printf("Enter value of P%d : ", i);
            requests[i-1] = sc.nextInt();
        }
        System.out.println(Arrays.toString(requests));
        
        System.out.print("Enter Head value: ");
        int head = sc.nextInt();

        int seekTime = 0;

        for (int i=0 ; i<n ; i++) {
            if (head > requests[i]) {
                seekTime = seekTime - (requests[i] - head);
            }
            else {
                seekTime = seekTime + (requests[i] - head);
            }
            head = requests[i];
        }

        System.out.println("Seek Time : " + seekTime);

        sc.close();
    }
}
