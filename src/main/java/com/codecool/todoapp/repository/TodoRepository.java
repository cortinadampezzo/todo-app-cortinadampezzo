package com.codecool.todoapp.repository;

import com.codecool.todoapp.model.Status;
import com.codecool.todoapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    Todo findById(long id);

    List<Todo> findTodosByStatus(Status status);

}
