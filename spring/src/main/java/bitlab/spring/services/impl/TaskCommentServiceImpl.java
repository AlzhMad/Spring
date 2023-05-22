package bitlab.spring.services.impl;

import bitlab.spring.models.TaskComment;
import bitlab.spring.repositories.TaskCommentRepository;
import bitlab.spring.services.TaskCommentService;
import bitlab.spring.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class TaskCommentServiceImpl implements TaskCommentService {


    @Autowired
    private TaskCommentRepository taskCommentRepository;



    @Override
    public List<TaskComment> getAllForTask(Long taskId) {

        return taskCommentRepository.findAllByTaskId(taskId);
    }

    @Autowired
    private TaskService taskService;

    @Override
    public void addTaskComment(Long taskId,TaskComment taskComment) {
        taskComment.setTask(taskService.getTask(taskId));
        taskComment.setDate(LocalDateTime.now());
        taskCommentRepository.save(taskComment);
    }
}
