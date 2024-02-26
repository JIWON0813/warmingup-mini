package com.warmingup.mini.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
public class Team {

    @Id
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Worker> workers = new ArrayList<>();

    public Team(String name){
        this.name = name;
    }

    public String getManager(){
       var manager = workers.stream()
                .filter(worker -> "MANAGER".equals(worker.getRole()))
                .findFirst()
                .orElse(null);

       return manager == null ? null : manager.getName();
    }

    public int getWorkersCount(){
        return workers.size();
    }
}
