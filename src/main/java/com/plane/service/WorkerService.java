package com.plane.service;

import com.plane.pojo.people.Worker;
import com.plane.pojo.plane.PlanePart;

import java.util.List;

public interface WorkerService {
    public Worker getWorker(long id);
    public void createWorker(Worker worker);
    public List<Worker> getAllWorkers(PlanePart planePart);
    public void updateWorker(Worker worker);
    public void deleteWorker(Worker worker);
}
