
import java.util.*;

public class Round_Robbin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input number of processes
        System.out.print("Enter the number of processes: ");
        int n = input.nextInt();

        // Creating an "Array of Arraylist" to store data of each process
        ArrayList<int[]> processes = new ArrayList<int[]>();

        // Array List Reference : {Arrival, Burst, Remaining Burst, Exit, Turnaround, Wait}
        // Array List Index     :    0        1            2         3        4        5         

        // Input Arrival Time & Burst Time
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter arrival time for process %d: ", i+1);
            int at = input.nextInt();
            System.out.printf("Enter burst time for process %d: ", i+1);
            int bt = input.nextInt();
            processes.add(new int[] {at, bt, bt, 0, 0, 0});
        }

        // Input Time Quantum
        System.out.print("Enter time quantum: ");
        int quantum = input.nextInt();

        // Declarations
        int time = 0;
        double averageWaitingTime = 0;
        double averageTurnaroundTime = 0;

        // Sorting list according to Arrival time
        processes.sort(Comparator.comparingInt(process -> process[0]));

        // Creating a Ready Queue
        Queue <Integer> readyQueue = new LinkedList<>();
        readyQueue.add(0);

        while (!readyQueue.isEmpty()) {

            // Ready the first ready process
            int i = readyQueue.poll();

            // If Remaining burst time of process is less than or equal to Time Quantum
            if (processes.get(i)[2] <= quantum) {
                time += processes.get(i)[2];
                processes.get(i)[2] = 0;
                processes.get(i)[3] = time;
                processes.get(i)[4] = processes.get(i)[3] - processes.get(i)[0];
                processes.get(i)[5] = processes.get(i)[4] - processes.get(i)[1];
            }
            
            // If Remaining burst time of process is greater than Time Quantum
            else {
                time += quantum;
                processes.get(i)[2] -= quantum;
                // Create a new ArrayList of integers to store the indices of the processes that are ready to be executed
                ArrayList<Integer> temp = new ArrayList<>();

                // Loop through all processes and check if they are ready to be executed based on their arrival time and remaining burst time
                for (int j = 0; j < n; j++) {
                    if (processes.get(j)[0] <= time && j != i && !readyQueue.contains(j) && processes.get(j)[2] != 0) {
                        // If a process is ready to be executed, add its index to the temporary ArrayList
                        temp.add(j);
                    }
                }
                // Add all the processes that are ready to be executed to the queue
                readyQueue.addAll(temp);

                // Add the current process to the queue
                readyQueue.offer(i);
            }
        }

        // Calculating Average Waiting Time & Average Turnaround Time
        System.out.println("\nP \tAT\tBT\tET\tWT\tTT");
        for (int i = 0; i < n; i++) {
            System.out.printf("P%d\t%d\t%d\t%d\t%d\t%d\n", i+1, processes.get(i)[0], processes.get(i)[1], processes.get(i)[3], processes.get(i)[4], processes.get(i)[5]);
            averageWaitingTime += processes.get(i)[5];
            averageTurnaroundTime += processes.get(i)[4];
        }

        averageWaitingTime /= n;
        averageTurnaroundTime /= n;

        // Printing Final Results
        System.out.printf("\nAverage Waiting Time: %.2f\n", averageWaitingTime);
        System.out.printf("Average Turnaround Time: %.2f\n", averageTurnaroundTime);

        input.close();

    }
}


// Using Different Arrays
/*

import java.util.*;

public class Round_Robbin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = input.nextInt();

        ArrayList<int[]> processes = new ArrayList<int[]>();

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter arrival time for process %d: ", i+1);
            int at = input.nextInt();
            System.out.printf("Enter burst time for process %d: ", i+1);
            int bt = input.nextInt();
            processes.add(new int[] {at, bt});
        }

        System.out.print("Enter time quantum: ");
        int quantum = input.nextInt();

        int[] remainingBurstTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] ExitTime = new int[n];
        int time = 0;

        for (int i=0 ; i<n ; i++) {
            remainingBurstTime[i] = processes.get(i)[1];
        }

        // Sorting list according to Arrival time
        processes.sort(Comparator.comparingInt(process -> process[0]));

        // Arrival time[i] = processes.get(i)[0]
        // Burst time[i] = processes.get(i)[1]

        // for (int i = 0; i < processes.size(); i++) {
        //     System.out.print("\n" + processes.get(i)[0] + ", " + processes.get(i)[1] );
        // }

        Queue <Integer> readyQueue = new LinkedList<>();
        readyQueue.offer(processes.indexOf(Collections.min(processes, Comparator.comparingInt(process -> process[0]))));
        time += Collections.min(processes, Comparator.comparingInt(process -> process[0]))[0];

        while (!readyQueue.isEmpty()) {
            int i = readyQueue.poll();

            if (remainingBurstTime[i] <= quantum) {
                time += remainingBurstTime[i];
                ExitTime[i] = time;
                turnaroundTime[i] = ExitTime[i] - processes.get(i)[0];
                waitingTime[i] = turnaroundTime[i] - processes.get(i)[1];
                remainingBurstTime[i] = 0;
            }
            else {
                time += quantum;
                remainingBurstTime[i] -= quantum;
                // Create a new ArrayList of integers to store the indices of the processes that are ready to be executed
                ArrayList<Integer> temp = new ArrayList<>();

                // Loop through all processes and check if they are ready to be executed based on their arrival time and remaining burst time
                for (int j = 0; j < n; j++) {
                    if (processes.get(j)[0] <= time && j != i && !readyQueue.contains(j) && remainingBurstTime[j] != 0) {
                        // If a process is ready to be executed, add its index to the temporary ArrayList
                        temp.add(j);
                    }
                }
                // Add all the processes that are ready to be executed to the queue
                readyQueue.addAll(temp);

                // Add the current process to the queue
                readyQueue.offer(i);
            }
        }
        
        double averageWaitingTime = 0;
        double averageTurnaroundTime = 0;

        System.out.println("\nProcess\t\tArrival time\tBurst time\tExit time\tWaiting time\tTurnaround time");
        for (int i = 0; i < n; i++) {
            System.out.printf("P%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n", i+1, processes.get(i)[0], processes.get(i)[1], ExitTime[i], turnaroundTime[i], waitingTime[i]);
            averageWaitingTime += waitingTime[i];
            averageTurnaroundTime += turnaroundTime[i];
        }

        averageWaitingTime /= n;
        averageTurnaroundTime /= n;

        System.out.printf("Average waiting time: %.2f\n", averageWaitingTime);
        System.out.printf("Average turnaround time: %.2f\n", averageTurnaroundTime);



    }
}

*/
