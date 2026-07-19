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
            System.out.println("[4] Start Pomodoro Timer");
            System.out.println("[5] Exit");
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
                    System.out.println("Enter task number to track: ");
                    int taskIndex = scanner.nextInt();
                    scanner.nextLine();
                    manager.trackTask(taskIndex);
                    System.out.println("Starting 25-minute work session...");
                    startTimer(25);
                    System.out.println("Time's up! Starting 5-minute break...");
                    startTimer(5);
                    System.out.println("Break finished!");
                    System.out.println("Press Enter to return to the menu...");
                    scanner.nextLine();
                    break;
                case 5:
                    manager.saveTasksToFile("tasks.txt");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, try again!");
            }
        }
    }

    // Methods
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void startTimer(int minutes) {
        int totalSeconds = minutes * 60;

        while (totalSeconds > 0) {
            int mins = totalSeconds / 60;
            int secs = totalSeconds % 60;

            System.out.printf("\rTime remaining: %02d:%02d", mins, secs);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Timer was interrupted!");
            }

            totalSeconds--;
        }

    }
}
