package com.warmingup.mini.controller;


import com.warmingup.mini.dto.request.WorkerCreateRequest;
import com.warmingup.mini.dto.response.WorkerResponse;
import com.warmingup.mini.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/worker")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @PostMapping("/save")
    public void save(WorkerCreateRequest request){
        workerService.save(request);
    }

    @GetMapping("/list")
    public List<WorkerResponse> workers(){
        return workerService.workers();
    }
}
