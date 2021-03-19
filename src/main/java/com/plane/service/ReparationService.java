package com.plane.service;

import com.plane.pojo.people.Worker;
import com.plane.pojo.plane.Detail;
import com.plane.pojo.plane.Navy;
import com.plane.pojo.plane.PlanePart;
import com.plane.pojo.plane.Reparation;

import java.util.List;

public interface ReparationService {
    public void replaceDetail(Navy plane, Reparation detail, Worker worker);
    public void repairPart(Reparation part, Navy plane, PlanePart planePart, List<Worker> workers);
    public String getStatus();
    public void setWorkerToRepair(Worker worker, PlanePart planePart, Reparation reparation);
}
