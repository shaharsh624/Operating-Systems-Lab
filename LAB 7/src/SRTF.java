import java.util.Scanner;

public class SRTF {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take the number of processes as input
        System.out.print("Enter number of processes: ");
        int n = input.nextInt();
        System.out.println();
        
        // Initialize arrays to store arrival time, burst time, remaining time, completion time, waiting time, turn around time, and completion status of each process
        int[] at = new int[n];
        int[] bt = new int[n];
        int[] rt = new int[n];
        int[] ct = new int[n];
        int[] tat = new int[n];
        int[] wt = new int[n];
        boolean[] completed = new boolean[n];

        // Take the arrival time and burst time of each process as input and initialize the remaining time of each process to its burst time
        for(int i = 0; i < n; i ++) {
            System.out.print("Enter Arrival Time of P" + (i + 1) + ": ");
            at[i] = input.nextInt();
            System.out.print("Enter Burst Time of P" + (i + 1) + ": ");
            bt[i] = input.nextInt();
            rt[i] = bt[i];
        }

        int currentTime = 0;
        int completedProcesses = 0;

        // Loop until all processes have been completed
        while(completedProcesses < n) {
            int shortestJob = -1;
            int shortestRemainingTime = Integer.MAX_VALUE;

            // Find the process with the shortest remaining time that has arrived and has not yet been completed
            for(int i = 0; i < n; i ++) {
                if(at[i] <= currentTime && completed[i] == false && rt[i] < shortestRemainingTime) {
                    shortestJob = i;
                    shortestRemainingTime = rt[i];
                }
            }

            // If there are no such processes, increment the current time by 1
            if(shortestJob == -1) {
                currentTime ++;
            }

            // If there is such a process
            else {
                if(shortestRemainingTime == 1) {
                    ct[shortestJob] = currentTime + 1;
                    completed[shortestJob] = true;
                    completedProcesses ++;
                }
                rt[shortestJob] = rt[shortestJob] - 1;
                currentTime ++;
            }
        }

        // Calculate the waiting time and turn around time of each process
        for(int i = 0; i < n; i ++) {
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
        }

        // Calculate the average waiting time and average turn around time
        double avgwt = 0.0;
        double avgtat = 0.0;
        for(int i = 0; i < n; i ++) {
            avgwt = avgwt + wt[i];
            avgtat = avgtat + tat[i];
        }

        avgwt = avgwt / n;
        avgtat = avgtat / n;

        // Print the average waiting time and average turn around time
        System.out.println("\nAverage Waiting Time is " + avgwt);
        System.out.println("Average Turn Around Time is " + avgtat);

        input.close();
    }
}