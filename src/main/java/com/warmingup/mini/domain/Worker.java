package com.warmingup.mini.domain;

import com.warmingup.mini.dto.request.WorkerCreateRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JoinColumn(name = "team_name")
    @ManyToOne
    private Team team;

    private String role;

    private LocalDate birthday;

    @Column(name = "work_start_date")
    private LocalDate workStartDate;

    public Worker(WorkerCreateRequest request, Team team) {
        if(request.getRole().equals("MANAGER") && team.getManager() != null){
            throw new IllegalArgumentException("TEAM의 MANAGER가 이미 존재합니다.");
        }

        this.id = null;
        this.name = request.getName();
        this.team = team;
        this.role = request.getRole();
        this.birthday = request.getBirthday();
        this.workStartDate = request.getWorkStartDate();
    }
}
