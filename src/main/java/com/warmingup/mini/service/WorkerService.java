package com.warmingup.mini.service;

import com.warmingup.mini.domain.Worker;
import com.warmingup.mini.dto.request.WorkerCreateRequest;
import com.warmingup.mini.dto.response.WorkerResponse;
import com.warmingup.mini.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

    @Transactional
    public void save(WorkerCreateRequest request) {
        request.isRequireValue();

        workerRepository.save(Worker.builder()
                .id(null)
                .name(request.getName())
                .teamName(request.getTeamName())
                .role(request.getRole())
                .birthday(request.getBirthday())
                .workStartDate(request.getWorkStartDate())
                .build()
        );
    }

    @Transactional(readOnly = true)
    public List<WorkerResponse> workers() {
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
