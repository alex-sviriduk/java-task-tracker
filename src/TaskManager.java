package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Manages a simple in-memory list of tasks.
 */
public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public Task addTask(String title) {
        Task t = new Task(nextId++, title);
        tasks.add(t);
        return t;
    }

    public List<Task> listTasks() {
        return new ArrayList<>(tasks);
    }

    public Optional<Task> findById(int id) {
        return tasks.stream().filter(t -> t.getId() == id).findFirst();
    }

    public boolean completeTask(int id) {
        Optional<Task> maybe = findById(id);
        if (maybe.isPresent()) {
            maybe.get().markDone();
            return true;
        }
        return false;
    }

    public boolean removeTask(int id) {
        return tasks.removeIf(t -> t.getId() == id);
    }

    public void clearAll() {
        tasks.clear();
        nextId = 1;
    }
}
