package bitlab.spring.conrollers;
import bitlab.spring.models.*;
import bitlab.spring.services.TaskCategoryService;
import bitlab.spring.services.TaskService;
import bitlab.spring.services.TasksFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskFolderController {
    @Autowired
    private TasksFolderService tasksFolderService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskCategoryService taskCategoryService;

    @GetMapping("/")
    public String getTaskFolders(Model model){
        List<TasksFolder> tasksFolders = tasksFolderService.getAll();
        model.addAttribute("folders", tasksFolders);
        return "taskFolders";
    }


    @GetMapping("/taskFolderDetails/{id}")
    public String getTaskFolder(@PathVariable Long id, Model model){
        TasksFolder tasksFolder = tasksFolderService.getTaskFolder(id);
        List<Task> tasks = taskService.getAllForFolder(id);
        List<TaskCategory> taskCategories = taskCategoryService.getNotUsedForTaskFolder(id);
        model.addAttribute("folder", tasksFolder);
        model.addAttribute("taski", tasks);
        model.addAttribute("categories", taskCategories);
        return "taskFolderDetails";
    }

    @PostMapping("/addTaskFolder")
    public String addTaskFolder(TasksFolder tasksFolder){
        tasksFolderService.addTasksFolder(tasksFolder);
        return "redirect:/";
    }

    @PostMapping("/addCategoryToTaskFolder")
    public String addCategoryToTaskFolder(@RequestParam Long taskFolderId, TaskCategory taskCategory){
        tasksFolderService.addCategoryToTaskFolder(taskFolderId, taskCategory);
        return "redirect:/taskFolderDetails/"+taskFolderId;
    }

    @PostMapping("/deleteCategoryFromTaskFolder")
    public String deleteCategoryFromTaskFolder(@RequestParam Long taskFolderId, TaskCategory taskCategory){
        tasksFolderService.deleteCategoryFromTaskFolder(taskFolderId, taskCategory);
        return "redirect:/taskFolderDetails/"+taskFolderId;
    }
}
