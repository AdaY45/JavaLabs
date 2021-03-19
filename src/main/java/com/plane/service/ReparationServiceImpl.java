package com.plane.service;

import com.plane.exception.PlaneNotFoundException;
import com.plane.exception.WorkerNotFoundException;
import com.plane.pojo.people.Worker;
import com.plane.pojo.plane.Detail;
import com.plane.pojo.plane.Navy;
import com.plane.pojo.plane.PlanePart;
import com.plane.pojo.plane.Reparation;
import com.plane.repository.NavyRepository;
import com.plane.repository.PlanePartRepository;
import com.plane.repository.ReparationRepository;
import com.plane.repository.WorkerRepository;

import java.util.List;

public class ReparationServiceImpl implements ReparationService{
    private ReparationRepository reparationRepository;
    private WorkerRepository workerRepository;
    private NavyRepository planeRepository;
    private PlanePartRepository planePartRepository;

    @Override
    public void replaceDetail(Navy plane, Reparation detail, Worker worker) {
        Worker workerResponsible = workerRepository.findWorkerById(worker.getId());
        if(workerResponsible == null)
            throw new WorkerNotFoundException();
        else
            detail.saveDetail(workerResponsible);
        Navy planeToRepair = planeRepository.findPlaneById(plane.getId());
        if(planeToRepair == null)
            throw new PlaneNotFoundException();
        detail.saveDetail(planeToRepair);
        detail.setReparationStatus("Repaired");
        reparationRepository.save(detail);
    }

    @Override
    public void repairPart(Reparation part, Navy plane, PlanePart planePart, List<Worker> workers) {
        Navy planeToRepair = planeRepository.findPlaneById(plane.getId());
        if(planeToRepair == null)
            throw new PlaneNotFoundException();
        if(workers == null)
            throw new WorkerNotFoundException();
        PlanePart partToBeRepaired = planePartRepository.findPartById(planePart.getId());
        if(partToBeRepaired == null)
            throw new PlaneNotFoundException();
        planeToRepair.savePlane(planePart);
        part.savePart(plane);
        part.setReparationStatus("Repaired");
        reparationRepository.save(part);
    }

    @Override
    public String getStatus() {
        return reparationRepository.getStatus();
    }

    @Override
    public void setWorkerToRepair(Worker worker, PlanePart planePart, Reparation reparation) {
        Worker workerToBeSet = workerRepository.findWorkerById(worker.getId());
        if(workerToBeSet == null)
            throw new WorkerNotFoundException();
        else
            reparation.saveWorker(workerToBeSet, planePart);
        reparationRepository.save(reparation);
    }

}
