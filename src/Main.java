import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        System.out.println("""
                ┌──────────────────────────────────────────────┐
                │  Welcome to the GCOSMOS productivity suite!  │
                └──────────────────────────────────────────────┘

                   ██████       ██████  ██████  ███████ ███    ███  ██████  ███████
                 ██            ██      ██    ██ ██      ████  ████ ██    ██ ██
                 ██   ███ ████ ██      ██    ██ ███████ ██ ████ ██ ██    ██ ███████
                 ██    ██      ██      ██    ██      ██ ██  ██  ██ ██    ██      ██
                  ██████        ██████  ██████  ███████ ██      ██  ██████  ███████


                :) System initialized. Press Enter to continue...
                """);
        scanner.nextLine();

        while (true) {
            System.out.println("[1] Add Task");
            System.out.println("[2] List Tasks");
            System.out.println("[3] Mark Completed");
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
                    System.out.println(manager.getTasks());
                    break;
                case 3:
                    System.out.println("Task number: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    manager.markCompleted(index);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, try again!");
            }
        }
    }
}
