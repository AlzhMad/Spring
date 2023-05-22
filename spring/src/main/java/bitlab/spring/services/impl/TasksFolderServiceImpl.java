package bitlab.spring.services.impl;

import bitlab.spring.models.TaskCategory;
import bitlab.spring.models.TasksFolder;
import bitlab.spring.repositories.TasksFolderRepository;
import bitlab.spring.services.TaskService;
import bitlab.spring.services.TasksFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksFolderServiceImpl implements TasksFolderService {
    @Autowired
    private TasksFolderRepository tasksFolderRepository;
    @Override
    public void addTasksFolder(TasksFolder tasksFolder) {
        tasksFolderRepository.save(tasksFolder);
    }

    @Override
    public List<TasksFolder> getAll() {
        return tasksFolderRepository.findAll();
    }

    @Autowired
    private TaskService taskService;
    @Override
    public void deleteFolder(Long Id) {
        List<TaskCategory> taskCategories = tasksFolderRepository.getById(Id).getCategories();
        tasksFolderRepository.deleteById(Id);

    }
    @Override
    public TasksFolder getTaskFolder(Long id) {
        return tasksFolderRepository.getById(id);
    }

    @Override
    public void addCategoryToTaskFolder(Long taskFolderId, TaskCategory taskCategory) {
        TasksFolder tasksFolder= tasksFolderRepository.getById(taskFolderId);
        tasksFolder.getCategories().add(taskCategory);
        tasksFolderRepository.save(tasksFolder);
    }

    @Override
    public void deleteCategoryFromTaskFolder(Long taskFolderId, TaskCategory taskCategory) {
        tasksFolderRepository.deleteCategoryFromTaskFolder(taskFolderId,taskCategory.getId());
    }
}
