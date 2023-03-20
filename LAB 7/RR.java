import java.util.Scanner;

public class RR {
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
            System.out.println();
        }

        // Take the time quantum as input
        System.out.print("Enter time quantum: ");
        int timeQuantum = input.nextInt();
        System.out.println();

        int currentTime = 0;
        int completedProcesses = 0;

        // Loop until all processes have been completed
        while(completedProcesses < n) {
            boolean processCompleted = false;

            // Loop through all processes
            for(int i = 0; i < n; i ++) {
                // If the process has arrived and has not yet been completed
                if(at[i] <= currentTime && completed[i] == false) {
                    // If the remaining time of the process is less than or equal to the time quantum
                    if(rt[i] <= timeQuantum) {
                        // Increment the current time by the remaining time of the process
                        currentTime += rt[i];
                        // Set the completion time of the process to the current time
                        ct[i] = currentTime;
                        // Set the remaining time of the process to 0
                        rt[i] = 0;
                        // Set the process as completed
                        completed[i] = true;
                        // Increment the number of completed processes
                        completedProcesses ++;
                        // Calculate the waiting time of the process
                        wt[i] = ct[i] - at[i] - bt[i];
                        // Calculate the turn around time of the process
                        tat[i] = ct[i] - at[i];
                    }
                    // If the remaining time of the process is greater than the time quantum
                    else {
                        // Increment the current time by the time quantum
                        currentTime += timeQuantum;
                        // Decrement the remaining time of the process by the time quantum
                        rt[i] -= timeQuantum;
                    }

                    processCompleted = true;
                }
            }

            // If no process was completed in this iteration, increment the current time by 1
            if(processCompleted == false) {
                currentTime ++;
            }
        }

        // Calculate the average waiting time and turn around time of all processes
        double avgWT = 0;
        double avgTAT = 0;
        for(int i = 0; i < n; i ++) {
            avgWT += wt[i];
            avgTAT += tat[i];
        }
        avgWT /= n;
        avgTAT /= n;

        // Print the completion time, waiting time, and turn around time of each process
        System.out.println("P\tAT\tBT\tCT\tTAT\tWT");
        for(int i = 0; i < n; i ++) {
            System.out.println((i + 1) + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
        }

        // Print the average waiting time and turn around time of all processes
        System.out.println("Average Waiting Time: " + avgWT);
        System.out.println("Average Turn Around Time is " + avgTAT);

        input.close();
    }
}