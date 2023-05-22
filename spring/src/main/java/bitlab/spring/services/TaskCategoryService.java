package bitlab.spring.services;

import bitlab.spring.models.TaskCategory;

import java.util.List;

public interface TaskCategoryService {
    List<TaskCategory> getAll();
    void addTaskCategory(TaskCategory taskCategory);
    TaskCategory getTaskCategoryId(Long id);
    void deleteTaskCategory(Long id);
    List<TaskCategory> getNotUsedForTaskFolder(Long taskFolderId);

    void deleteTaskCategoryForTaskFolders(Long id);
}
