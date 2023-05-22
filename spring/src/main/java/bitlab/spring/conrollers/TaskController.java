package bitlab.spring.conrollers;

import bitlab.spring.models.Task;
import bitlab.spring.models.TaskCategory;
import bitlab.spring.models.TaskComment;
import bitlab.spring.models.TaskStatus;
import bitlab.spring.services.TaskCategoryService;
import bitlab.spring.services.TaskCommentService;
import bitlab.spring.services.TaskService;
import bitlab.spring.services.TaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private  TaskService taskService;

    @Autowired
    private TaskStatusService taskStatusService;

    @Autowired
    private TaskCategoryService taskCategoryService;

    @Autowired
    private TaskCommentService taskCommentService;

    @GetMapping("/tasks")
    public String getTasks(Model model){
        List<TaskCategory> taskCategories = taskCategoryService.getAll();
        List<TaskStatus> taskStatuses = taskStatusService.getAll();
        List<Task> tasks = taskService.getAll();
        model.addAttribute("taski", tasks);
        model.addAttribute("categories", taskCategories);
        model.addAttribute("statuses", taskStatuses);
        return "tasks";
    }

    @GetMapping("/taskDetails/{id}")
    public String getTask(@PathVariable Long id, Model model){
        List<TaskCategory> taskCategories = taskCategoryService.getAll();
        List<TaskStatus> taskStatuses = taskStatusService.getAll();
        List<TaskComment> taskComments = taskCommentService.getAllForTask(id);
        Task task = taskService.getTask(id);
        model.addAttribute("task", task);
        model.addAttribute("categories", taskCategories);
        model.addAttribute("statuses", taskStatuses);
        model.addAttribute("comments", taskComments);
        return "taskDetails";
    }
    @PostMapping("/addTask")
    public String addTask(Task task){
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @PostMapping("/editTask")
    public String editTask(Task task){
        taskService.addTask(task);
        return "redirect:/taskDetails/"+task.getId();
    }
    @PostMapping("/deleteTask")
    public String deleteTask(@RequestParam Long id){
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
