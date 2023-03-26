def round_robin(processes, quantum):
    processes = sorted(processes, key=lambda process: process[0])
    n = len(processes)
    remaining_burst_time = [process[1] for process in processes]
    arrival_time = [process[0] for process in processes]
    waiting_time = [0] * n
    turnaround_time = [0] * n
    completion_time = [0] * n
    time = 0
    queue = []
    queue.append(arrival_time.index(min(arrival_time)))
    time += min(arrival_time)
    
    while True:
        if not queue:
            break
        i = queue.pop(0)
        if remaining_burst_time[i] <= quantum:
            time += remaining_burst_time[i]
            completion_time[i] = time
            turnaround_time[i] = completion_time[i] - arrival_time[i]
            waiting_time[i] = turnaround_time[i] - processes[i][1]
            remaining_burst_time[i] = 0
        else:
            time += quantum
            remaining_burst_time[i] -= quantum
            temp = []
            for j in range(n):
                if arrival_time[j] <= time and j != i and j not in queue and remaining_burst_time[j] != 0:
                    queue.append(j)
            queue.append(i)
    
    average_waiting_time = sum(waiting_time) / n
    average_turnaround_time = sum(turnaround_time) / n
    
    print("\nProcess\t\tArrival time\tBurst time\tCompletion time\tWaiting time\tTurnaround time")
    for i in range(n):
        print(f"P{i+1}\t\t{arrival_time[i]}\t\t{processes[i][1]}\t\t{completion_time[i]}\t\t{turnaround_time[i]}\t\t{waiting_time[i]}")
    
    print(f"Average waiting time: {average_waiting_time:.2f}")
    print(f"Average turnaround time: {average_turnaround_time:.2f}")

def main():
    n = int(input("Enter the number of processes: "))
    processes = []
    for i in range(n):
        at = int(input(f"Enter arrival time for process {i+1}: "))
        bt = int(input(f"Enter burst time for process {i+1}: "))
        processes.append((at, bt))
    
    quantum = int(input("Enter time quantum: "))
    round_robin(processes, quantum)

if __name__ == '__main__':
    main()
