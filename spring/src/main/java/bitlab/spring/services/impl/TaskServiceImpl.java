package bitlab.spring.services.impl;

import bitlab.spring.models.Task;
import bitlab.spring.models.TaskCategory;
import bitlab.spring.repositories.TaskRepository;
import bitlab.spring.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.getById(id);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getAllForFolder(Long taskFolderId){
        return taskRepository.findAllForFolder(taskFolderId);
    }

    @Override
    public void deleteTaskByCategory(Long categoryId) {
        taskRepository.deleteByCategoryId(categoryId);

    }
}
