package RAR.TickFlow.exceptions;

import java.util.UUID;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(UUID id) {
        super("Task with ID " + id + " not found!");
    }
    public TaskNotFoundException(String message) {
        super(message);
    }
}
