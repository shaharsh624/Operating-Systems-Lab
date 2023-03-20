import java.util.Scanner;

public class FCFS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take the number of processes as input
        System.out.print("Enter number of processes: ");
        int n = input.nextInt();
        System.out.println();

        // Initialize arrays to store arrival time, burst time, waiting time, turn around time, and completion status of each process
        int[] at = new int[n];
        int[] bt = new int[n];
        int[] tat = new int[n];
        int[] wt = new int[n];
        boolean[] completed = new boolean[n];

        // Take the arrival time and burst time of each process as input
        for(int i = 0; i < n; i ++) {
            System.out.print("Enter Arrival Time of P" + (i + 1) + ": ");
            at[i] = input.nextInt();
            System.out.print("Enter Burt Time of P" + (i + 1) + ": ");
            bt[i] = input.nextInt();
            System.out.println();
        }

        int currentTime = 0;
        int completedProcesses = 0;

        // Loop until all processes have been completed
        while(completedProcesses < n) {
            int Job = -1;
            int shortestArrivalTime = Integer.MAX_VALUE;

            // Find the process with the shortest arrival time that has arrived and has not yet been completed
            for(int i = 0; i < n; i ++) {
                if(at[i] <= currentTime && completed[i] == false && at[i] < shortestArrivalTime) {
                    Job = i;
                    shortestArrivalTime = at[i];
                }
            }

            // If there are no such processes, increment the current time by 1
            if(Job == -1) {
                currentTime ++;
            }
            // If there is such a process, calculate the waiting time and turn around time of the process, update the current time, mark the process as completed, and increment the number of completed processes
            else {
                wt[Job] = currentTime - at[Job];
                tat[Job] = bt[Job] + wt[Job];
                currentTime = currentTime + bt[Job];
                completed[Job] = true;
                completedProcesses ++;
            }
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
        System.out.println("Average Waiting Time is " + avgwt);
        System.out.println("Average Turn Around Time is " + avgtat);

        input.close();
    }
}