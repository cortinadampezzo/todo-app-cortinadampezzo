package com.codecool.todoapp.service;

import com.codecool.todoapp.model.Status;
import com.codecool.todoapp.model.Todo;
import com.codecool.todoapp.repository.TodoRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public void addNewTodo(String title) {
        Todo todo = Todo.builder()
                .title(title)
                .status(Status.ACTIVE)
                .build();
        todoRepository.saveAndFlush(todo);
    }

    public String getTodosByStatus(String status) {
        List<Todo> todos;
        if (status.equals("active")) {
            todos = todoRepository.findTodosByStatus(Status.ACTIVE);
        } else if (status.equals("complete")) {
            todos = todoRepository.findTodosByStatus(Status.COMPLETE);
        } else {
            todos = todoRepository.findAll();
        }

        JSONArray jsonArray = new JSONArray();
        for (Todo todo : todos) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", todo.getId());
            jsonObject.put("title", todo.getTitle());
            jsonObject.put("completed", todo.isComplete());
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString(2);
    }

    public void toggleStatusById(long id) {
        Todo todo = todoRepository.findById(id);
        if (todo.getStatus().equals(Status.ACTIVE)) {
            todo.setStatus(Status.COMPLETE);
        } else {
            todo.setStatus(Status.ACTIVE);
        }
        todoRepository.save(todo);
    }

    public void updateById(long id, String title) {
        Todo todo = todoRepository.findById(id);
        todo.setTitle(title);
        todoRepository.save(todo);
    }

    public void removeById(long id) {
        todoRepository.deleteById(id);
    }

    public void toggleAllStatus() {
        List<Todo> todos = todoRepository.findAll();
        for (Todo todo: todos) {
            if (!todo.isComplete()) {
                todo.setStatus(Status.COMPLETE);
            } else {
                todo.setStatus(Status.ACTIVE);
            }
            todoRepository.save(todo);
        }
    }

    public void removeAllCompleted() {
        List<Todo> todos = todoRepository.findAll();
        for (Todo todo: todos) {
            if (todo.getStatus().equals(Status.COMPLETE)) {
                todoRepository.delete(todo);
            }
        }
    }

}
