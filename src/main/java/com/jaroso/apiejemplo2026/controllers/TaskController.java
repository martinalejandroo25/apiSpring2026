package com.jaroso.apiejemplo2026.controllers;

import com.jaroso.apiejemplo2026.entities.Task;
import com.jaroso.apiejemplo2026.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;


    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Optional<Task> task = taskService.findById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/tasks/title/{title}")
    public ResponseEntity<Task> getTaskByTitle(@PathVariable String title){
        Optional<Task> task = taskService.findByTitle(title);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        //return ResponseEntity.ok(taskService.saveTask(task));
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.saveTask(task));
    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.saveTask(task));
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Task> delete(@PathVariable Long id){
        Optional<Task> task = taskService.findById(id);
        if (task.isPresent()) {
            //Si el id es válido lo borramos y devolvemos 204
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        } else {
            //Si el id no es de una tarea válida
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/tasks")
    public ResponseEntity<Task> deleteAll(){
        taskService.deleteAll();
        return ResponseEntity.noContent().build();
    }

}