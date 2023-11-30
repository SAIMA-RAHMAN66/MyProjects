package com.example.todo.service;

import com.example.todo.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo getTodoById(Long id);
    Todo saveOrUpdate(Todo todo);
    void deleteTodo(Long id);
}
