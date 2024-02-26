package com.warmingup.mini.dto.response;

import com.warmingup.mini.domain.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TeamResponse {

    private String name;

    private String manager;

    private int memberCount;

    public TeamResponse(Team team) {
        this.name = team.getName();
        this.manager = team.getManager();
        this.memberCount = team.getWorkersCount();
    }
}
