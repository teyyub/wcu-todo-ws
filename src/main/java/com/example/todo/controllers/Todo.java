package com.example.todo.controllers;



import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Todo {

    private Integer id;
    private String description;
    private String note;
    private LocalDateTime createdAt;

    public Todo(String description, String note) {
        this.description = description;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", note='" + note + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
