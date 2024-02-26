package com.warmingup.mini.controller;

import com.warmingup.mini.dto.request.TeamCreateRequest;
import com.warmingup.mini.dto.response.TeamResponse;
import com.warmingup.mini.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/team")
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/save")
    public void save(@RequestBody TeamCreateRequest request){
        teamService.save(request);
    }

    @GetMapping("/list")
    public List<TeamResponse> teams(){
        return teamService.teams();
    }
}
