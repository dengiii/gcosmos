import java.util.ArrayList;
import java.io.*;

public class TaskManager {
    private ArrayList<Task> tasks;

    // Constructor
    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    // Methods
    public String addTask(Task task) {
        this.tasks.add(task);
        return "Task '" + task.getTitle() + "' added succesfully";
    }

    public String getTasks() {
        if (this.tasks.isEmpty()) {
            return "No task found...";
        }

        StringBuilder sb = new StringBuilder("--- TASKS LIST ---\n");

        for (int i = 0; i < this.tasks.size(); i++) {
            Task task = this.tasks.get(i);
            sb.append("[").append(i).append("] ").append(task.toString()).append("\n");
        }

        return sb.toString();
    }

    public void markCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = this.tasks.get(index);
            task.setIsCompleted(true);
            System.out.println("Task '" + task.getTitle() + "' marked as completed!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void clearTasks() {
        tasks.clear();
    }

    // helpers
    public void saveTasksToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Task task : tasks) {
                writer.write(task.getTitle() + ";" + task.getTag() + ";" + task.getIsCompleted());
                writer.newLine();
            }
            System.out.println("Tasks saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public void loadTasksFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    String title = parts[0];
                    String tag = parts[1];
                    boolean isCompleted = Boolean.parseBoolean(parts[2]);
                    Task task = new Task(title, tag);
                    task.setIsCompleted(isCompleted);
                    tasks.add(task);
                }
            }
            System.out.println("Tasks loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No saved tasks found. Starting fresh!");
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

    public void markAllCompleted() {
        for (Task task : tasks) {
            task.setIsCompleted(true);
        }
    }
}
