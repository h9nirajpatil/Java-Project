import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String name;
    String description;
    String dueDate;

    Task(String name, String description, String dueDate) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask(taskList, scanner);
                    break;
                case 2:
                    removeTask(taskList, scanner);
                    break;
                case 3:
                    listTasks(taskList);
                    break;
                case 4:
                    System.out.println("Exiting Task Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTask(ArrayList<Task> taskList, Scanner scanner) {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        System.out.print("Enter due date: ");
        String dueDate = scanner.nextLine();

        Task task = new Task(name, description, dueDate);
        taskList.add(task);

        System.out.println("Task added successfully!");
    }

    private static void removeTask(ArrayList<Task> taskList, Scanner scanner) {
        if (taskList.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }

        System.out.println("Tasks:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i).name);
        }

        System.out.print("Enter the number of the task to remove: ");
        int taskNumber = scanner.nextInt();

        if (taskNumber >= 1 && taskNumber <= taskList.size()) {
            Task removedTask = taskList.remove(taskNumber - 1);
            System.out.println("Task removed: " + removedTask.name);
        } else {
            System.out.println("Invalid task number. No task removed.");
        }
    }

    private static void listTasks(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("No tasks to list.");
            return;
        }

        System.out.println("Tasks:");
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            System.out.println("Task " + (i + 1) + ":");
            System.out.println("Name: " + task.name);
            System.out.println("Description: " + task.description);
            System.out.println("Due Date: " + task.dueDate);
        }
    }
}
