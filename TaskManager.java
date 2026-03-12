// CO2 & CO3: Interactive Task Manager using LinkedList, Stack and Queue
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TaskManager {

    private LinkedList<String> tasks = new LinkedList<>(); // CO2
    private Stack<String> undoStack = new Stack<>(); // CO3
    private Queue<String> taskQueue = new LinkedList<>(); // Queue for task processing

    // Add task
    public void addTask(String task) {
        tasks.add(task);
        undoStack.push(task);
        taskQueue.add(task);
        System.out.println("Task added: " + task);
    }

    // Remove task
    public void removeTask(String task) {
        if (tasks.remove(task)) {
            taskQueue.remove(task);
            System.out.println("Task removed: " + task);
        } else {
            System.out.println("Task not found: " + task);
        }
    }

    // Undo last task
    public void undoLastTask() {
        if (!undoStack.isEmpty()) {
            String lastTask = undoStack.pop();
            tasks.remove(lastTask);
            taskQueue.remove(lastTask);
            System.out.println("Undo successful, removed: " + lastTask);
        } else {
            System.out.println("No tasks to undo.");
        }
    }

    // Process next task using Queue (FIFO)
    public void processNextTask() {
        if (!taskQueue.isEmpty()) {
            String task = taskQueue.poll();
            tasks.remove(task);
            System.out.println("Processing task: " + task);
        } else {
            System.out.println("No tasks in queue.");
        }
    }

    // Display tasks
    public void displayTasks() {
        System.out.println("Current Tasks: " + tasks);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager tm = new TaskManager();
        int choice;

        do {
            System.out.println("\n=== Smart Student Academic Assistant: Task Manager ===");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Undo Last Task");
            System.out.println("4. Process Next Task (Queue)");
            System.out.println("5. Display Tasks");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = sc.nextLine();
                    tm.addTask(task);
                    break;

                case 2:
                    System.out.print("Enter task to remove: ");
                    String removeTask = sc.nextLine();
                    tm.removeTask(removeTask);
                    break;

                case 3:
                    tm.undoLastTask();
                    break;

                case 4:
                    tm.processNextTask();
                    break;

                case 5:
                    tm.displayTasks();
                    break;

                case 6:
                    System.out.println("Exiting Task Manager...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
