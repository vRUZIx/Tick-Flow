package RAR.TickFlow.service;

import RAR.TickFlow.dto.TaskRequestDTO;
import RAR.TickFlow.dto.TaskResponseDTO;
import RAR.TickFlow.entity.Task;
import RAR.TickFlow.enums.Priority;
import RAR.TickFlow.enums.Status;
import RAR.TickFlow.exceptions.InvalidTaskOperationException;
import RAR.TickFlow.exceptions.TaskNotFoundException;
import RAR.TickFlow.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskResponseDTO createTask(TaskRequestDTO request) {
        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .dueDate(request.getDueDate())
                .status(request.getStatus() != null ? request.getStatus() : Status.TODO)
                .priority(request.getPriority() != null ? request.getPriority() : Priority.MEDIUM)
                .tag(request.getTag())
                .build();

        Task saved = taskRepository.save(task);
        return mapToResponseDTO(saved);
    }

    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public TaskResponseDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
        return mapToResponseDTO(task);
    }

    public TaskResponseDTO updateTask(Long id, TaskRequestDTO request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new InvalidTaskOperationException("Task not found with id: " + id));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setDueDate(request.getDueDate());

        if (request.getStatus() != null) {
            task.setStatus(request.getStatus());
        }
        if (request.getPriority() != null) {
            task.setPriority(request.getPriority());
        }
        task.setTag(request.getTag());

        Task updated = taskRepository.save(task);
        return mapToResponseDTO(updated);
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Task not found with id: " + id);
        }
        taskRepository.deleteById(id);
    }

    private TaskResponseDTO mapToResponseDTO(Task task) {
        return TaskResponseDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .dueDate(task.getDueDate())
                .createdAt(task.getCreatedAt())
                .status(task.getStatus())
                .priority(task.getPriority())
                .tag(task.getTag())
                .build();
    }

}
