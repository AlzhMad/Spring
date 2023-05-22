package bitlab.spring.repositories;

import bitlab.spring.models.Task;
import bitlab.spring.models.TaskCategory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long> {

    @Query( value = "select * from tasks t where t.category_id in (select categories_id from task_folders_categories c where c.tasks_folder_id = :folderId)", nativeQuery = true )
    List<Task> findAllForFolder(@Param("folderId") Long taskFolderId);

    @Modifying
    @Transactional
    @Query(value = "delete from tasks where category_id = :categoryId",nativeQuery = true)
    void deleteByCategoryId(@Param("categoryId") Long categoryId);
}
