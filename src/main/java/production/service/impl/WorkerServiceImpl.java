package production.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.pojo.people.Worker;
import production.pojo.plane.Navy;
import production.repository.NavyRepository;
import production.repository.WorkerRepository;
import production.service.WorkerService;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private NavyRepository navyRepository;

    @Override
    public Worker getWorker(long id) {
        return workerRepository.findWorkerById(id);
    }

    @Override
    public Worker createWorker(Worker worker) {
        return workerRepository.createWorker(worker);
    }

    @Override
    public List<Worker> getAllWorkers(Navy plane) {
        return plane.getWorker();
    }

    @Override
    public Worker updateWorker(Worker worker) {
        return workerRepository.updateWorker(worker);
    }

    @Override
    public boolean deleteWorker(Worker worker) {
        return workerRepository.deleteWorker(worker);
    }

    @Override
    public List<Worker> getAll() {
        return workerRepository.findAll();
    }
}
