package com.aliriza.DomesticTaskManager.Controller;

import com.aliriza.DomesticTaskManager.model.Status;
import com.aliriza.DomesticTaskManager.model.Task;
import com.aliriza.DomesticTaskManager.model.Type;
import com.aliriza.DomesticTaskManager.service.TaskService;
import com.aliriza.DomesticTaskManager.service.UserNotFoundException;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//@RestController
@Controller
public class TaskController {
//    @Autowired
//    private TaskRepository taskRepository;
    @Autowired
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

//    @GetMapping("/")
//    public List<Task> getTasks(){
//    return taskService.getTasks();
//    }

    @GetMapping("/tasks")
   public String showTaskList(Model model){
       List<Task> listTasks = taskService.listAll();
        model.addAttribute("listTasks", listTasks);
       return "tasks";
    }

    @GetMapping("/tasks/new")
    public String showNewForm(Model model){
        model.addAttribute("task", new Task());
        model.addAttribute("pageTitle", "Add New Task");
        return "task_form";
    }
//    @GetMapping("/")
//    public String viewHomePage(Model model){
//        model.addAttribute("listTasks", taskService.getTasks());
//        return "frontend";
//    }

    @PostMapping ("/tasks/save")
    public String saveTask(Task task, RedirectAttributes ra){
        taskService.save(task);
        ra.addFlashAttribute("message", "Task has been saved successfully");
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra){
        try{
           Task task = taskService.get(id);
           model.addAttribute("task", task);
           model.addAttribute("pageTitle", "Edit Task (ID: " + id + ")");
           return "task_form";
        } catch (UserNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/tasks";
        }
    }

    @GetMapping("tasks/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id, RedirectAttributes ra){
        try{
           taskService.delete(id);
        } catch (UserNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/tasks";
    }


//    @PostMapping("/tasks/save")
//    public void registerNewTask(
//            @RequestParam String title, String description, Long id, String stopDate, int type, int status){
//        System.out.println(title + " " + description + " " + id + " " + stopDate + " " +  Type.values()[type] + " " + Status.values()[status]);
//
//       // taskService.addNewTask(task);
//    }

//    @DeleteMapping(path = "/{taskId}")
//    public void deleteTask(
//            @PathVariable("taskId") Long taskId){
//        taskService.deleteTask(taskId);
//    }

}