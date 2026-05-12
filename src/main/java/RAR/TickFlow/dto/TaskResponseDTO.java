package RAR.TickFlow.dto;

import RAR.TickFlow.enums.Priority;
import RAR.TickFlow.enums.Status;
import RAR.TickFlow.enums.Tag;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponseDTO {

    private UUID id;

    private String title;

    private String description;

    private LocalDate dueDate;

    private LocalDate createdAt;

    private Status status;

    private Priority priority;

    private Tag tag;
}
