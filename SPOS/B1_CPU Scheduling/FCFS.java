import java.util.Scanner;

public class FCFS {
    public static void main(String[] args) {
        // Declare variables
        int numProcesses, burstTime[], turnAroundTime[], waitingTime[];
        float avgWaitingTime = 0, avgTurnAroundTime = 0;

        // Create arrays for burst time, waiting time, and turn around time
        burstTime = new int[50];
        turnAroundTime = new int[50];
        waitingTime = new int[50];

        // First process always has a waiting time of 0
        waitingTime[0] = 0;

        // Initialize scanner to take user input
        Scanner scanner = new Scanner(System.in);

        // Get number of processes from the user
        System.out.print("Enter the number of processes: ");
        numProcesses = scanner.nextInt();

        // Get burst time for each process
        System.out.println("Enter Burst Time for each process:");
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("P" + (i + 1) + ": ");
            burstTime[i] = scanner.nextInt();
        }

        // Calculate waiting time for each process
        for (int i = 1; i < numProcesses; i++) {
            waitingTime[i] = waitingTime[i - 1] + burstTime[i - 1];
            avgWaitingTime += waitingTime[i];
        }

        // Calculate the average waiting time
        avgWaitingTime /= numProcesses;

        // Calculate turn around time for each process
        for (int i = 0; i < numProcesses; i++) {
            turnAroundTime[i] = waitingTime[i] + burstTime[i];
            avgTurnAroundTime += turnAroundTime[i];
        }

        // Calculate the average turn around time
        avgTurnAroundTime /= numProcesses;

        // Display the results
        System.out.println("\nProcess\tBurst Time\tWaiting Time\tTurn Around Time");
        for (int i = 0; i < numProcesses; i++) {
            System.out.println(
                    "P" + (i + 1) + "\t" + burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + turnAroundTime[i]);
        }

        // Display average times
        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turn Around Time: " + avgTurnAroundTime);
    }
}
