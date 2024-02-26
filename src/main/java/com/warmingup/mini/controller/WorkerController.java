package com.warmingup.mini.controller;

import com.warmingup.mini.dto.request.WorkerCreateRequest;
import com.warmingup.mini.dto.response.WorkerResponse;
import com.warmingup.mini.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/worker")
public class WorkerController {

    private final WorkerService workerService;

    @PostMapping("/save")
    public void save(@RequestBody WorkerCreateRequest request){
        workerService.save(request);
    }

    @GetMapping("/list")
    public List<WorkerResponse> workers(){
        return workerService.workers();
    }
}
