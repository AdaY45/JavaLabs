package com.plane.controller;

import com.plane.exception.WorkerNotFoundException;
import com.plane.pojo.people.Worker;
import com.plane.pojo.plane.Plane;
import com.plane.pojo.plane.PlanePart;
import com.plane.service.WorkerServiceImpl;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WorkerController {
    private WorkerServiceImpl workerService;

    public void createWorker(Worker worker) {
        workerService.createWorker(worker);
    }

    public Worker getWorkerById(Integer id) {
        Worker worker = workerService.getWorker(id);
        if(worker == null) {
            throw new WorkerNotFoundException();
        }
        return worker;
    }

    public List<Worker> getAllWorkers(PlanePart planePart) {
        return workerService.getAllWorkers(planePart);
    }

    public void updateWorker(Worker worker) {
        workerService.updateWorker(worker);
    }

    public void deleteWorker(Worker worker) {
        workerService.deleteWorker(worker);
    }
}
