package com.aliriza.DomesticTaskManager.Controller;

import com.aliriza.DomesticTaskManager.model.Task;
import com.aliriza.DomesticTaskManager.service.TaskService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "swagger-ui.html")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(){
    return taskService.getTasks();
    }


    @PostMapping
    public void registerNewTask(@RequestBody Task task){
        taskService.addNewTask(task);
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(
            @PathVariable("taskId") Long taskId){
        taskService.deleteTask(taskId);
    }

}