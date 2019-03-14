package com.codecool.todoapp;

import com.codecool.todoapp.model.Status;
import com.codecool.todoapp.model.Todo;
import com.codecool.todoapp.repository.TodoRepository;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InitData {

    @Autowired
    private TodoRepository todoRepository;

    @Bean
    public CommandLineRunner init() {
        return args -> {
            Todo todo1 = Todo.builder()
                    .title("Feed my guinea pigs.")
                    .status(Status.ACTIVE)
                    .build();

            Todo todo2 = Todo.builder()
                    .title("Pay electricity bill.")
                    .status(Status.COMPLETE)
                    .build();

            Todo todo3 = Todo.builder()
                    .title("Cook something for dinner.")
                    .status(Status.ACTIVE)
                    .build();

            todoRepository.save(todo1);
            todoRepository.save(todo2);
            todoRepository.save(todo3);

        };
    }
}
