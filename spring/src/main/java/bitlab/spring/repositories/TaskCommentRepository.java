package bitlab.spring.repositories;

import bitlab.spring.models.TaskComment;
import lombok.Lombok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskCommentRepository extends JpaRepository<TaskComment, Long > {
    @Query(value = "SELECT * FROM  comments WHERE task_id = ?1 order by date desc", nativeQuery = true)
    List<TaskComment> findAllByTaskId(Long taskId);
}
