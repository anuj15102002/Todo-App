package com.app.TodoApp.Controllers.Services;

import com.app.TodoApp.Models.Tasks;
import com.app.TodoApp.Respository.TaskRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {
    private final TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRespository) {
        this.taskRepository = taskRespository;
    }

    public List<Tasks> getAllTasks(){
        return taskRepository.findAll();

    }

    public void createTask(String title) {
        Tasks task=new Tasks();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTaskById(Long id) {
        Tasks task=taskRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid Id"));
        taskRepository.deleteById(id);
    }
    public void toggleTaskById(Long id)
    {
        Tasks task=taskRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid Id"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
