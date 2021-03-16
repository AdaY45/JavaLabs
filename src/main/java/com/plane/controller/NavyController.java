package com.plane.controller;

import com.plane.exception.WorkerNotFoundException;
import com.plane.pojo.plane.Navy;
import com.plane.pojo.people.Worker;
import com.plane.service.NavyServiceImpl;
import com.plane.service.WorkerServiceImpl;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NavyController {
    private NavyServiceImpl planeService;
    private WorkerServiceImpl workerService;

    public NavyController(NavyServiceImpl planeService, WorkerServiceImpl workerService) {
        this.planeService = planeService;
        this.workerService = workerService;
    }

    public void createNavyPLane(Integer id, Navy plane) {
        Worker worker = workerService.getWorker(id);
        if(worker != null) {
            planeService.saveNavy(plane, worker);
        } else {
            throw new WorkerNotFoundException();
        }
    }

    public Navy getNavyById(Integer id) {
        return planeService.getNavy(id);
    }

    public List<Navy> getAllPlanesOfWorker(Integer id) {
        Worker worker = workerService.getWorker(id);
        if(worker != null) {
            return planeService.getPlanesOfWorker(worker);
        } else {
            throw new WorkerNotFoundException();
        }
    }

    public void updateNavy(Integer id, Navy plane) {
        Worker worker = workerService.getWorker(id);
        if(worker != null) {
            planeService.updateNavy(plane);
        } else {
            throw new WorkerNotFoundException();
        }
    }

    public void deletePlane(Integer id, Navy plane) {
        Worker worker = workerService.getWorker(id);
        if(worker != null) {
            planeService.deleteNavy(plane);
        } else {
            throw new WorkerNotFoundException();
        }
    }
}
