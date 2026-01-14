package com.jaroso.apiejemplo2026.services;

import com.jaroso.apiejemplo2026.entities.Task;

import java.util.List;
import java.util.Optional;

/*
* CRUD:
* C reate
* R etrieve / Read
* U pdate
* D elete*/
public interface TaskService {

    //Estos son metodos de consulta para la base de datos

    //Retrieve / Read
    List<Task> findAll();
    Optional<Task> findById(Long id);
    Optional<Task> findByTitle(String title);

    //CREATE / UPDATE
    Task saveTask(Task task);

    // DELETE
    void deleteTask(Long id);
    void deleteAll();

}
