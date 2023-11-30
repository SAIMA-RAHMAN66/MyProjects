package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public String getAllTodos(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        model.addAttribute("newTodo", new Todo());
        return "todo";
    }
    
    @PostMapping
    public String saveOrUpdate(@ModelAttribute Todo todo) {
        todoService.saveOrUpdate(todo);
        return "redirect:/todos";
    }

    @GetMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return "redirect:/todos";
    }
    
}
