package com.warmingup.mini.service;

import com.warmingup.mini.dto.TeamResponse;
import com.warmingup.mini.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public void save(){

    }

    @Transactional(readOnly = true)
    public List<TeamResponse> teams(){
        return null;
    }
}
