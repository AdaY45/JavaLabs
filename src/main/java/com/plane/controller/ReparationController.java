package com.plane.controller;

import com.plane.exception.WorkerNotFoundException;
import com.plane.pojo.people.Worker;
import com.plane.pojo.plane.Detail;
import com.plane.pojo.plane.Navy;
import com.plane.pojo.plane.PlanePart;
import com.plane.pojo.plane.Reparation;
import com.plane.service.ReparationServiceImpl;
import com.plane.service.WorkerServiceImpl;

import java.util.List;

public class ReparationController {
    private ReparationServiceImpl reparationService;
    private WorkerServiceImpl workerService;

    public ReparationController(ReparationServiceImpl reparationService, WorkerServiceImpl workerService) {
        this.reparationService = reparationService;
        this.workerService = workerService;
    }

    public void detailReplacement(Navy plane, Reparation detail, Integer id) {
        Worker worker = workerService.getWorker(id);
        if(worker != null)
            reparationService.replaceDetail(plane,detail,worker);
        else
            throw new WorkerNotFoundException();
    }

    public void partReparation(Reparation part, Navy plane, PlanePart planePart) {
        List<Worker> workers = workerService.getAllWorkers(planePart);
        if(workers != null)
            reparationService.repairPart(part, plane, planePart,workers);
        else
            throw new WorkerNotFoundException();
    }

    public String getReparationStatus() {
        return reparationService.getStatus();
    }

    public void setWorkerToRepair(Worker worker,PlanePart planePart, Reparation reparation) {
        reparationService.setWorkerToRepair(worker,planePart,reparation);
    }
}
