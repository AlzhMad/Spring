package bitlab.spring.services;

import bitlab.spring.models.Task;
import bitlab.spring.models.TaskCategory;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskService{
    List<Task> getAll();
    void addTask(Task task);
    Task getTask(Long id);
    void deleteTask(Long id);
    public List<Task> getAllForFolder(Long taskFolderId);

    void deleteTaskByCategory(Long categoryId);

}
