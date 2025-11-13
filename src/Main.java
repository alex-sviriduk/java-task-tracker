package src;

import java.util.Scanner;

/**
 * Simple console UI for the Task Tracker.
 */
public class Main {
    private static final TaskManager manager = new TaskManager();
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Task Tracker!");
        loop:
        while (true) {
            System.out.println("\nCommands: add, list, done, remove, clear, help, quit");
            System.out.print("> ");
            String cmd = in.nextLine().trim();

            switch (cmd) {
                case "add":
                    System.out.print("Title: ");
                    String title = in.nextLine().trim();
                    if (!title.isEmpty()) {
                        System.out.println("Added: " + manager.addTask(title));
                    } else {
                        System.out.println("Title cannot be empty.");
                    }
                    break;
                case "list":
                    manager.listTasks().forEach(System.out::println);
                    break;
                case "done":
                    System.out.print("Task id: ");
                    int idDone = readInt();
                    if (!manager.completeTask(idDone)) {
                        System.out.println("No task with id " + idDone);
                    } else {
                        System.out.println("Marked done.");
                    }
                    break;
                case "remove":
                    System.out.print("Task id: ");
                    int idRem = readInt();
                    if (manager.removeTask(idRem)) {
                        System.out.println("Removed.");
                    } else {
                        System.out.println("No task with id " + idRem);
                    }
                    break;
                case "clear":
                    manager.clearAll();
                    System.out.println("All tasks removed.");
                    break;
                case "help":
                    System.out.println("Try add/list/done/remove/clear/quit");
                    break;
                case "quit":
                    break loop;
                default:
                    System.out.println("Unknown command. Type help.");
            }
        }
        System.out.println("Bye!");
    }

    private static int readInt() {
        try {
            String line = in.nextLine().trim();
            return Integer.parseInt(line);
        } catch (Exception e) {
            return -1;
        }
    }
}
