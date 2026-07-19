import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        manager.loadTasksFromFile("tasks.txt");

        System.out.println("""
                ┌──────────────────────────────────────────────┐
                │  Welcome to the GCOSMOS productivity suite!  │
                └──────────────────────────────────────────────┘

                   ██████       ██████  ██████  ███████ ███    ███  ██████  ███████
                 ██            ██      ██    ██ ██      ████  ████ ██    ██ ██
                 ██   ███ ████ ██      ██    ██ ███████ ██ ████ ██ ██    ██ ███████
                 ██    ██      ██      ██    ██      ██ ██  ██  ██ ██    ██      ██
                  ██████        ██████  ██████  ███████ ██      ██  ██████  ███████


                :) System initialized...
                """);

        while (true) {
            clearScreen();
            System.out.println(manager.getTasks());
            System.out.println("[1] Add Task");
            System.out.println("[2] Mark Completed");
            System.out.println("[3] Clear All Tasks");
            System.out.println("[4] Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Title of the task: ");
                    String title = scanner.nextLine();
                    System.out.println("Tag of the task: ");
                    String tag = scanner.nextLine();
                    Task newTask = new Task(title, tag);
                    System.out.println(manager.addTask(newTask));
                    break;
                case 2:
                    System.out.println("Task number: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    manager.markCompleted(index);
                    break;
                case 3:
                    manager.clearTasks();
                    System.out.println("All tasks cleared!");
                    break;
                case 4:
                    manager.saveTasksToFile("tasks.txt");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, try again!");
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
