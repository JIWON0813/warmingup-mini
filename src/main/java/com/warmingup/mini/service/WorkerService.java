package com.warmingup.mini.service;

import com.warmingup.mini.domain.Worker;
import com.warmingup.mini.dto.request.WorkerCreateRequest;
import com.warmingup.mini.dto.response.WorkerResponse;
import com.warmingup.mini.repository.TeamRepository;
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

    private final TeamRepository teamRepository;

    @Transactional
    public void save(WorkerCreateRequest request) {
        request.isRequireValue();

        var team = teamRepository.findById(request.getTeamName()).orElseThrow(IllegalArgumentException::new);
        workerRepository.save(new Worker(request, team));
    }

    @Transactional(readOnly = true)
    public List<WorkerResponse> workers() {
        var workers = workerRepository.findAll();
        var workersResponse = workers.stream()
                .map(worker -> new WorkerResponse(worker))
                .collect(Collectors.toList());
        return workersResponse;
    }
}
