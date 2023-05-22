package bitlab.spring.repositories;

import bitlab.spring.models.TaskCategory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Long>  {

    @Query( value = "select * from task_categories where id not in (select categories_id from task_folders_categories where tasks_folder_id = :folderId)", nativeQuery = true )
    List<TaskCategory> getNotUsedForTaskFolder(@Param("folderId") Long taskFolderId);

    @Modifying
    @Transactional
    @Query(value = "delete from task_folders_categories where categories_id = :categoryId",nativeQuery = true)
    void deleteTaskCategoryForTaskFolders(@Param("categoryId") Long id);
}
