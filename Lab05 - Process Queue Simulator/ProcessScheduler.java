/*
 * Written by Maximus Fernandez
 * Process Queue Simulator
 * Due 03/01/2024 by 11:55pm
 */

public class ProcessScheduler {
    private LLQueue<Process> processes; // Linked list queue of processes
    private Process currentProcess; // Currently running process

    // Constructor to initialize the process queue
    public ProcessScheduler() {
        processes = new LLQueue<>();
        currentProcess = null;
    }

    // Method to get the currently running process
    public Process getCurrentProcess() {
        return currentProcess;
    }

    // Method to add a process to the scheduler
    public void addProcess(Process process) {
        if (currentProcess == null) {
            // If no process is currently running, set the current process
            currentProcess = process;
        } else {
            // Otherwise, add the process to the process queue
            processes.Enqueue(process);
        }
    }

    // Method to run the next process in the queue
    public void runNextProcess() {
        currentProcess = processes.Dequeue();
    }

    // Method to cancel the current process and replace it with the next process in the queue
    public void cancelCurrentProcess() {
        // Dequeue from the process queue and set as the current process
        currentProcess = processes.Dequeue();
    }

    // Method to print all elements in the process queue
    public void printProcessQueue() {
        processes.Print(); // Simply call the print method of LLQueue
    }
}
