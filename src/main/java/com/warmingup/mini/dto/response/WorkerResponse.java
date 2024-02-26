package com.warmingup.mini.dto.response;

import com.warmingup.mini.domain.Worker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class WorkerResponse {

    private String name;

    private String teamName;

    private String role;

    private LocalDate birthday;

    private LocalDate workStartDate;

    public WorkerResponse(Worker worker) {
        this.name = worker.getName();
        this.teamName = worker.getTeam().getName();
        this.role = worker.getRole();
        this.birthday = worker.getBirthday();
        this.workStartDate = worker.getWorkStartDate();
    }
}
