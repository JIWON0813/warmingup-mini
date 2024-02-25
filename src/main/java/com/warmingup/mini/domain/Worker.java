package com.warmingup.mini.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "team_name")
    private String teamName;

    private String role;

    private LocalDate birthday;

    @Column(name = "work_start_date")
    private LocalDate workStartDate;
}
