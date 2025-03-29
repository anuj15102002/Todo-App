package com.app.TodoApp.Respository;

import com.app.TodoApp.Models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Tasks,Long> {
}
