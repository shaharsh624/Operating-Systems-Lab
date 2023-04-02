import java.util.Scanner;

public class SSTF {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input no. of requests
        System.out.print("Enter number of requests: ");
        int n = input.nextInt();
        int[] requests = new int[n];

        // Input requests Value
        for(int i = 0; i < n; i ++) {
            System.out.print("Enter Request " + (i + 1) + ": ");
            requests[i] = input.nextInt();
        }

        System.out.print("Enter Head location: ");
        int head = input.nextInt();

        int seekTime = 0;
        boolean[] completed = new boolean[n];

        // Main Programm
        for (int i=0 ; i<n ; i++) {
            int[] difference = findSeekTime(requests, head, completed);
            int index = findIndex(difference);
            seekTime += difference[index];
            completed[index] = true;
            head = requests[index];
        }

        System.out.println("Total Seek Time for serving all requests : " + seekTime);
        input.close();
    }

    public static int findDifference(int a, int b) {
        if (a > b) { return a-b; }
        else { return b-a; }
    }

    public static int[] findSeekTime(int[] requests, int head, boolean[] completed) {
        int[] difference = new int[requests.length];

        for (int i=0 ; i<requests.length ; i++) {
            if (!completed[i]) {
                difference[i] = findDifference(head, requests[i]);
            } else {
                difference[i] = Integer.MAX_VALUE;
            }
        }
        return difference;
    }

    public static int findMin (int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i=0 ; i<array.length ; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int findIndex (int[] array) {
        int i = 0;
        int index = -1;
        int min = findMin(array);
        while(i < array.length) {
            if(array[i] == min) {
                index = i;
                break;
            }
            i++;
        }
        return index;
    }
}