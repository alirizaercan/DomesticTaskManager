package com.aliriza.DomesticTaskManager.service;

import com.aliriza.DomesticTaskManager.model.Status;
import com.aliriza.DomesticTaskManager.model.Task;
import com.aliriza.DomesticTaskManager.model.Type;
import com.aliriza.DomesticTaskManager.repository.TaskRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }


    public void addNewTask(Task task){
        Optional<Task> taskOptional = taskRepository
                .findTaskByTitle(task.getTitle());
        if (taskOptional.isPresent()){
            throw new IllegalStateException("title used");
        }
        taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        boolean exists = taskRepository.existsById(taskId);
        if (!exists){
            throw new IllegalStateException(
                    "task with id" + taskId + "does not exists");
        }
        taskRepository.deleteById(taskId);
    }

}