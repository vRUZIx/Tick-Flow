package RAR.TickFlow.repository;

import RAR.TickFlow.entity.Task;
import RAR.TickFlow.enums.Priority;
import RAR.TickFlow.enums.Status;
import RAR.TickFlow.enums.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("""
        SELECT t FROM Task t
        WHERE (:status IS NULL OR t.status = :status)
        AND (:priority IS NULL OR t.priority = :priority)
        AND (:tag IS NULL OR t.tag = :tag)
        AND (
            :search IS NULL OR
            LOWER(t.title) LIKE LOWER(CONCAT('%', :search, '%')) OR
            LOWER(t.description) LIKE LOWER(CONCAT('%', :search, '%'))
        )
    """)
    Page<Task> filterAndSearch(
            Status status,
            Priority priority,
            Tag tag,
            String search,
            Pageable pageable
    );
}