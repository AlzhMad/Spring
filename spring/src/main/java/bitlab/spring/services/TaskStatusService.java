package bitlab.spring.services;

import bitlab.spring.models.Task;
import bitlab.spring.models.TaskStatus;

import java.util.List;


public interface TaskStatusService {
    TaskStatus getTaskStatusById(Long Id);
    List<TaskStatus> getAll();
}
