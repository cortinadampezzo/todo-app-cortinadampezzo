package com.codecool.todoapp.model;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Todo {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Status status;

    public boolean isComplete() {
        return this.status == Status.COMPLETE;
    }

}
