import java.util.Scanner;

class SJF1 {
    public static void main(String[] args) {
        // Declare variables
        int burstTime[], process[], waitingTime[], turnAroundTime[], i, j, numProcesses, total = 0, pos, temp;
        float avgWaitTime, avgTurnAroundTime;

        // Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Get the number of processes
        System.out.print("Enter number of processes: ");
        numProcesses = scanner.nextInt();

        // Initialize arrays
        process = new int[numProcesses];
        burstTime = new int[numProcesses];
        waitingTime = new int[numProcesses];
        turnAroundTime = new int[numProcesses];

        // Get burst time for each process
        System.out.println("\nEnter Burst Time for each process:");
        for (i = 0; i < numProcesses; i++) {
            System.out.print("Process[" + (i + 1) + "]: ");
            burstTime[i] = scanner.nextInt();
            process[i] = i + 1; // Store process number
        }

        // Sort processes based on burst time using selection sort
        for (i = 0; i < numProcesses; i++) {
            pos = i;
            for (j = i + 1; j < numProcesses; j++) {
                if (burstTime[j] < burstTime[pos]) {
                    pos = j; // Find the position of the shortest burst time
                }
            }
            // Swap burst time and process number
            temp = burstTime[i];
            burstTime[i] = burstTime[pos];
            burstTime[pos] = temp;

            temp = process[i];
            process[i] = process[pos];
            process[pos] = temp;
        }

        // First process has a waiting time of 0
        waitingTime[0] = 0;

        // Calculate waiting time for each process
        for (i = 1; i < numProcesses; i++) {
            waitingTime[i] = 0;
            for (j = 0; j < i; j++) {
                waitingTime[i] += burstTime[j];
            }
            total += waitingTime[i]; // Sum up waiting times
        }

        // Calculate average waiting time
        avgWaitTime = (float) total / numProcesses;
        total = 0;

        // Display process information
        System.out.println("\nProcess\t Burst Time \tWaiting Time\tTurnaround Time");
        for (i = 0; i < numProcesses; i++) {
            turnAroundTime[i] = burstTime[i] + waitingTime[i]; // Calculate turnaround time
            total += turnAroundTime[i]; // Sum up turnaround times

            // Display the details for each process
            System.out.println(
                    "P" + process[i] + "\t\t" + burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + turnAroundTime[i]);
        }

        // Calculate average turnaround time
        avgTurnAroundTime = (float) total / numProcesses;

        // Display average waiting and turnaround times
        System.out.println("\nAverage Waiting Time: " + avgWaitTime);
        System.out.println("Average Turnaround Time: " + avgTurnAroundTime);
    }
}
