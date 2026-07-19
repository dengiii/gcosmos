public class Task {
    private String title;
    private String tag;
    private boolean isCompleted;
    private boolean isTracked;

    // Constructor
    public Task(String title, String tag) {
        this.title = title;
        this.tag = tag;
        this.isCompleted = false;
        this.isTracked = false;
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

    public boolean getIsTracked() {
        return isTracked;
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

    public void setIsTracked(boolean isTracked) {
        this.isTracked = isTracked;
    }

    // Methods
    @Override
    public String toString() {
        String statusCompleted = isCompleted ? "[x]" : "";
        String statusTrack = isTracked ? "[-]" : "";
        return statusCompleted + " " + statusTrack + " " + title + " (" + tag + ")";
    }

}
