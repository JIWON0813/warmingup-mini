package com.warmingup.mini.controller;

import com.warmingup.mini.dto.request.TeamCreateRequest;
import com.warmingup.mini.dto.response.TeamResponse;
import com.warmingup.mini.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/save")
    public void save(TeamCreateRequest request){
        teamService.save(request);
    }

    @GetMapping("/list")
    public List<TeamResponse> teams(){
        return null;
    }
}
