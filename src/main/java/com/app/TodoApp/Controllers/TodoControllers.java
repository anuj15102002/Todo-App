package com.app.TodoApp.Controllers;


import com.app.TodoApp.Services.TaskServices;
import com.app.TodoApp.Models.Tasks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoControllers {
    private final TaskServices taskServices;

    public TodoControllers(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @GetMapping
    public String getTasks(Model model)
    {
        List<Tasks> tasks=taskServices.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping
    public String  addTasks(@RequestParam String title)
    {
        taskServices.createTask(title);
        return "redirect:/";

    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskServices.deleteTaskById(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id)
    {
        taskServices.toggleTaskById(id);
        return "redirect:/";
    }

    }
