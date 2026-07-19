import java.util.ArrayList;

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
}
