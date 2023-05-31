package com.sudheer.project.myFirstProject.todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Size(min=10, message = "Enter atleast 10 characters")
    private String description;
    @Column(name = "targetDate")
    private LocalDate localDate;
    private boolean done;

    public Todo() {

    }

    public Todo(int id, String name, String description, LocalDate localDate, boolean done) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.localDate = localDate;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", localDate=" + localDate +
                ", done=" + done +
                '}';
    }
}
