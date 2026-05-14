package RAR.TickFlow;
import RAR.TickFlow.dto.PaginatedResponseDTO;
import RAR.TickFlow.dto.TaskRequestDTO;
import RAR.TickFlow.dto.TaskResponseDTO;
import RAR.TickFlow.entity.Task;
import RAR.TickFlow.enums.Priority;
import RAR.TickFlow.enums.Status;
import RAR.TickFlow.enums.Tag;
import RAR.TickFlow.repository.TaskRepository;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureTestRestTemplate
class TaskControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private TaskRepository taskRepository;
    @BeforeEach
    void setUp() {
        taskRepository.deleteAll();
    }
    @Test
    void createTask_UsingSeedDataFormat_ReturnsCreated() {

        TaskRequestDTO request = TaskRequestDTO.builder()
                .title("Finish Java Project")
                .description("Complete backend APIs for TickFlow application")
                .dueDate(LocalDate.of(2026, 5, 20))
                .status(Status.InProgress)
                .priority(Priority.HIGH)
                .tag(Tag.WORK)
                .build();

        ResponseEntity<TaskResponseDTO> response = restTemplate.postForEntity(
                "/api/tasks", request, TaskResponseDTO.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Finish Java Project", response.getBody().getTitle());
        assertEquals(Status.InProgress, response.getBody().getStatus());

    }
    @Test
    void getAllTasks_AfterManualInsertion_ReturnsAll() {
        // Arrange
        Task task3 = new Task();
        task3.setTitle("Buy Groceries");
        task3.setDueDate(LocalDate.of(2026, 5, 15));
        task3.setStatus(Status.Done);
        Task task4 = new Task();
        task4.setTitle("Gym Training");
        task4.setDueDate(LocalDate.of(2026, 5, 17));
        task4.setStatus(Status.TODO);
        taskRepository.saveAll(List.of(task3, task4));

        ResponseEntity<PaginatedResponseDTO> response = restTemplate.getForEntity("/api/tasks", PaginatedResponseDTO.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().getContent().size());
    }
    @Test
    void updateTask_StatusChange_ReturnsUpdated() {
        Task task2 = new Task();
        task2.setTitle("Study Spring Security");
        task2.setDueDate(LocalDate.of(2026, 5, 18));
        task2.setStatus(Status.TODO);
        var saved = taskRepository.save(task2);
        TaskRequestDTO updateRequest = TaskRequestDTO.builder()
                .title("Study Spring Security")
                .dueDate(LocalDate.of(2026, 5, 18))
                .status(Status.InProgress)
                .build();
        HttpEntity<TaskRequestDTO> requestEntity = new HttpEntity<>(updateRequest);
        ResponseEntity<TaskResponseDTO> response = restTemplate.exchange(
                "/api/tasks/" + saved.getId(),
                HttpMethod.PUT,
                requestEntity,
                TaskResponseDTO.class
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Status.InProgress, response.getBody().getStatus());

    }

}