package bitlab.spring.conrollers;

import bitlab.spring.models.TaskCategory;
import bitlab.spring.services.TaskCategoryService;
import bitlab.spring.services.TaskService;
import bitlab.spring.services.TasksFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskCategoryController {
    @Autowired
    TaskCategoryService taskCategoryService;


    @Autowired
    TaskService taskService;

    @GetMapping("/taskCategories")
    public String getTaskCategories(Model model){
        List<TaskCategory> taskCategories = taskCategoryService.getAll();
        model.addAttribute("categories", taskCategories);
        return "taskCategories";
    }
    @PostMapping("/addTaskCategory")
    public String TaskCategory(TaskCategory taskCategory){
        taskCategoryService.addTaskCategory(taskCategory);
        return "redirect:/taskCategories";
    }

    @PostMapping("/editTaskCategory")
    public String editTaskCategory(TaskCategory taskCategory){
        taskCategoryService.addTaskCategory(taskCategory);
        return "redirect:/taskCategories";
    }
    @PostMapping("/deleteTaskCategory")
    public String deleteTaskCategory(@RequestParam Long id){
        taskService.deleteTaskByCategory(id);
        taskCategoryService.deleteTaskCategoryForTaskFolders(id);
        taskCategoryService.deleteTaskCategory(id);
        return "redirect:/taskCategories";
    }
}
