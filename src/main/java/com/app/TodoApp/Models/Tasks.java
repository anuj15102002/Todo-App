package com.app.TodoApp.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean completed;
    private String title;
}
