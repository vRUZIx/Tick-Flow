package RAR.TickFlow.Mapper;

import RAR.TickFlow.dto.TaskRequestDTO;
import RAR.TickFlow.dto.TaskResponseDTO;
import RAR.TickFlow.entity.Task;
import RAR.TickFlow.enums.Priority;
import RAR.TickFlow.enums.Status;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    public Task toEntity(TaskRequestDTO dto) {
        if (dto == null) return null;

        return Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .dueDate(dto.getDueDate())
                .status(dto.getStatus() != null ? dto.getStatus() : Status.TODO) // default dəyər
                .priority(dto.getPriority() != null ? dto.getPriority() : Priority.MEDIUM)
                .tag(dto.getTag())
                .build();
    }

    public TaskResponseDTO toResponseDTO(Task task) {
        if (task == null) return null;

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

    public List<TaskResponseDTO> toResponseDTOList(List<Task> tasks) {
        return tasks.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public void updateTask(TaskRequestDTO dto, Task task) {
        if (dto == null || task == null) return;

        if (dto.getTitle() != null) task.setTitle(dto.getTitle());
        if (dto.getDescription() != null) task.setDescription(dto.getDescription());
        if (dto.getDueDate() != null) task.setDueDate(dto.getDueDate());
        if (dto.getStatus() != null) task.setStatus(dto.getStatus());
        if (dto.getPriority() != null) task.setPriority(dto.getPriority());
        if (dto.getTag() != null) task.setTag(dto.getTag());
    }
}