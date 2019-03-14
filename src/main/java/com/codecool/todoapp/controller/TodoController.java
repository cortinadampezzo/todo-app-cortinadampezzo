package com.codecool.todoapp.controller;

import com.codecool.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping(path = "/addTodo")
    public void addNewTodo(@RequestParam("todo-title") String title) {
        todoService.addNewTodo(title);
    }

    @PostMapping(path = "/list")
    public String getTodosByStatus(@RequestParam("status") String status) {
        return todoService.getTodosByStatus(status);
    }

    @PutMapping(path = "/todos/{id}/toggle_status")
    public void toggleStatusById(@PathVariable("id") long id) {
        todoService.toggleStatusById(id);
    }

    @PutMapping(path = "/todos/{id}")
    public void updateById(@PathVariable("id") long id, @RequestParam("todo-title") String title) {
        todoService.updateById(id, title);
    }

    @DeleteMapping(path = "/todos/{id}")
    public void removeById(@PathVariable("id") long id) {
        todoService.removeById(id);
    }

    @PutMapping(path = "/todos/toggle_all")
    public void toggleAllStatus() {
        todoService.toggleAllStatus();
    }

    @DeleteMapping(path = "todos/completed")
    public void removeAllCompleted() {
        todoService.removeAllCompleted();
    }

}
