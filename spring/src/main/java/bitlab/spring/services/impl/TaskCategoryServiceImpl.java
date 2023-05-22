package bitlab.spring.services.impl;

import bitlab.spring.models.TaskCategory;
import bitlab.spring.repositories.TaskCategoryRepository;
import bitlab.spring.services.TaskCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCategoryServiceImpl implements TaskCategoryService {
    @Autowired
    private TaskCategoryRepository taskCategoryRepository;
    @Override
    public List<TaskCategory> getAll() {
        return taskCategoryRepository.findAll();
    }

    @Override
    public void addTaskCategory(TaskCategory taskCategory) {
        taskCategoryRepository.save(taskCategory);
    }

    @Override
    public TaskCategory getTaskCategoryId(Long id) {
        return taskCategoryRepository.getById(id);
    }

    @Override
    public void deleteTaskCategory(Long id) {
        taskCategoryRepository.deleteById(id);
    }

    @Override
    public List<TaskCategory> getNotUsedForTaskFolder(Long taskFolderId) {
        return taskCategoryRepository.getNotUsedForTaskFolder(taskFolderId);
    }

    @Override
    public void deleteTaskCategoryForTaskFolders(Long id) {
        taskCategoryRepository.deleteTaskCategoryForTaskFolders(id);
    }
}
