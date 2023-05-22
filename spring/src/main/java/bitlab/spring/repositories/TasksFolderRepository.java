package bitlab.spring.repositories;

import bitlab.spring.models.TaskCategory;
import bitlab.spring.models.TasksFolder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksFolderRepository extends JpaRepository <TasksFolder, Long>{

    @Modifying
    @Transactional
    @Query(value="delete  from task_folders_categories where tasks_folder_id=:folderId and categories_id =:categoryId  ", nativeQuery = true)
    void deleteCategoryFromTaskFolder(@Param("folderId") Long taskFolderId,@Param("categoryId")  Long taskCategoryId);
}
