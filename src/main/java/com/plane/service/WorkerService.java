package com.plane.service;

import com.plane.pojo.plane.Worker;

import java.util.Collections;
import java.util.List;

public interface WorkerService {
    public Worker getWorker(long id);
    public void createWorker(Worker worker);
    public List<Worker> getAllWorkers();
    public void updateWorker(Worker worker);
    public void deleteWorker(Worker worker);
}
