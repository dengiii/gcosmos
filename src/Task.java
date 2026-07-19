public class Task {
    private String title;
    private String tag;
    private boolean isCompleted;

    // Constructor
    public Task(String title, String tag) {
        this.title = title;
        this.tag = tag;
        this.isCompleted = false;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getTag() {
        return tag;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    // Methods
    @Override
    public String toString() {
        String status = isCompleted ? "[x]" : "[]";
        return status + " " + title + " (" + tag + ")";
    }
}
