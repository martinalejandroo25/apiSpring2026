package com.jaroso.apiejemplo2026.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "tasks")
@AllArgsConstructor //estas anotaciones pertenecen a Lombok y automatiza las clases POJO
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement
    private Long id;

    private String title;
    private String description;
    @Column(name = "finish_date", nullable = false)
    private LocalDate finishDate;
}
