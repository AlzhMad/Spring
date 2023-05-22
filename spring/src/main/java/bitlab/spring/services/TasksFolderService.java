package bitlab.spring.services;

import bitlab.spring.models.TaskCategory;
import bitlab.spring.models.TasksFolder;

import java.util.List;

public interface TasksFolderService {
    void addTasksFolder(TasksFolder tasksFolder);
    List<TasksFolder> getAll();
    void deleteFolder(Long Id);
    TasksFolder getTaskFolder(Long id);

    void addCategoryToTaskFolder(Long taskFolderId, TaskCategory taskCategory);

    void deleteCategoryFromTaskFolder(Long taskFolderId, TaskCategory taskCategory);
}
