package bitlab.spring.services;

import bitlab.spring.models.TaskComment;

import java.util.List;

public interface TaskCommentService {
    List<TaskComment> getAllForTask(Long taskId);
    void addTaskComment(Long taskId, TaskComment Comment);
}
