package bitlab.spring.services.impl;

import bitlab.spring.models.TaskStatus;
import bitlab.spring.repositories.TaskStatusRepository;
import bitlab.spring.services.TaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskStatusServiceImpl implements TaskStatusService {
    @Autowired
    private TaskStatusRepository taskStatusRepository;
    @Override
    public TaskStatus getTaskStatusById(Long Id) {
        return taskStatusRepository.getById(Id);
    }

    @Override
    public List<TaskStatus> getAll() {
        return taskStatusRepository.findAll();
    }
}
