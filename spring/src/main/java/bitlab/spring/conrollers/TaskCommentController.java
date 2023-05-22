package bitlab.spring.conrollers;

import bitlab.spring.models.TaskComment;
import bitlab.spring.services.TaskCommentService;
import bitlab.spring.services.TaskService;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
public class TaskCommentController {
    @Autowired
    TaskCommentService taskCommentService;
    @Autowired
    TaskService taskService;

    @PostMapping("/addComment")
    public String addComment(@RequestParam Long taskId, TaskComment taskComment){
        taskCommentService.addTaskComment(taskId, taskComment);
        return "redirect:/taskDetails/"+taskId;
    }
}
