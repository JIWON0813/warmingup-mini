package com.warmingup.mini.service;

import com.warmingup.mini.domain.Team;
import com.warmingup.mini.dto.request.TeamCreateRequest;
import com.warmingup.mini.dto.response.TeamResponse;
import com.warmingup.mini.repository.TeamRepository;
import com.warmingup.mini.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public void save(TeamCreateRequest request){
        request.checkNotNullName();

        teamRepository.save(new Team(request.getName()));
    }

    @Transactional(readOnly = true)
    public List<TeamResponse> teams(){
        var teams = teamRepository.findAll();

        var result = teams.stream()
                .map(team -> new TeamResponse(team))
                .collect(Collectors.toList());

        return result;
    }
}
