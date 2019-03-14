package com.codecool.todoapp.controller;

import com.codecool.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    private static final String SUCCESS = "{\"success\":true}";

    @Autowired
    private TodoRepository todoRepository;

    @PostMapping("/add")
    public void addNewTodo() {

    }

    @PostMapping("/todos")
    public void listTodos() {

    }

    @GetMapping("/todos/{id}")
    public void findById() {

    }

    @PutMapping("/todos/{id}/toggle")
    public void toggleStatusById() {

    }

    @PutMapping("/todos/{id}")
    public void updateById() {

    }

    @DeleteMapping("/todos/{id}")
    public void removeById() {

    }

    @PutMapping("/todos/toggle_all")
    public void toggleAllStatus() {

    }

    @DeleteMapping("todos/remove_completed")
    public void removeAllCompleted() {

    }
}
