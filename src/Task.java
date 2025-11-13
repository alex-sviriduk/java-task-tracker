package src;

/**
 * Simple Task model.
 */
public class Task {
    private final int id;
    private final String title;
    private String note;
    private boolean done;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.note = "";
        this.done = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getNote() { return note; }
    public boolean isDone() { return done; }

    public void setNote(String note) { this.note = note; }
    public void markDone() { this.done = true; }
    public void markUndone() { this.done = false; }

    @Override
    public String toString() {
        return String.format("[%s] #%d: %s%s",
            (done ? "x" : " "),
            id,
            title,
            (note.isEmpty() ? "" : " — " + note));
    }
}
