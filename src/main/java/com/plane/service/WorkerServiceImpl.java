package com.plane.service;

import com.plane.pojo.people.Worker;
import com.plane.repository.WorkerRepository;

import java.util.Collections;
import java.util.List;

public class WorkerServiceImpl implements WorkerService{
    private WorkerRepository workerRepository;

    @Override
    public Worker getWorker(long id) {
        return workerRepository.findWorkerById(id);
    }

    @Override
    public void createWorker(Worker worker) {
        workerRepository.createWorker(worker);
    }

    @Override
    public List<Worker> getAllWorkers() {
        return Collections.emptyList();
    }

    @Override
    public void updateWorker(Worker worker) {
        workerRepository.updateWorker(worker);
    }

    @Override
    public void deleteWorker(Worker worker) {
        workerRepository.deleteWorker(worker);
    }
}
