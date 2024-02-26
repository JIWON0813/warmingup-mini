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

    private final WorkerRepository workerRepository;
    @Transactional
    public void save(TeamCreateRequest request){
        request.checkNotNullName();

        teamRepository.save(new Team(request.getName()));
    }

    //TODO... refactoring
    @Transactional(readOnly = true)
    public List<TeamResponse> teams(){
        var teams = teamRepository.findAll();
        var workers = workerRepository.findAll();

        var result = teams.stream().map(team -> {
            var manager = workers.stream().filter(worker -> worker.getRole().equals("MANAGER")).findFirst().orElse(null);
            var count = workers.stream().filter(worker -> worker.getTeamName().equals(team.getName())).count();
            return new TeamResponse(team.getName(), manager == null ? null : manager.getName(), count);
        }).collect(Collectors.toList());

        return result;
    }
}
