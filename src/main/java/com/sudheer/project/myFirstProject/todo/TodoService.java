package com.sudheer.project.myFirstProject.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;
    static{
        todos.add(new Todo(++todosCount,"sudheer","Learn AWS", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todosCount,"sudheer","Learn Devops", LocalDate.now().plusYears(2),false));
    }

    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate =
                todo -> todo.getName().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void adddTodo(String username, String description, LocalDate localDate, boolean done){
        Todo todo = new Todo(++todosCount, username,description,localDate,done);
        todos.add(todo);
    }

    public void deleteById(int id) {
        //todo.getId() == id
        // todo -> todo.getId() == id
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
