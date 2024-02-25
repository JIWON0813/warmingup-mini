package com.warmingup.mini.service;

import com.warmingup.mini.dto.WorkerResponse;
import com.warmingup.mini.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

    @Transactional
    public void save(){
        workerRepository.save(null);
    }

    @Transactional(readOnly = true)
    public List<WorkerResponse> workers(){
        var workers = workerRepository.findAll();
        var workersResponse = workers.stream()
                                                        .map(worker -> WorkerResponse.builder()
                                                                .name(worker.getName())
                                                                .teamName(worker.getTeamName())
                                                                .role(worker.getRole())
                                                                .birthday(worker.getBirthday())
                                                                .workStartDate(worker.getWorkStartDate())
                                                                .build())
                                                        .collect(Collectors.toList());
        return workersResponse;
    }
}
