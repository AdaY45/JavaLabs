package production.kpi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.kpi.pojo.people.Worker;
import production.kpi.repository.WorkerRepository;
import production.kpi.service.WorkerService;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public Worker getWorker(Integer id) {
        return workerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Worker createWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    /*@Override
    public List<Worker> getAllWorkers(Navy plane) {
        return plane.getWorkers();
    }*/

    @Override
    public Worker updateWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public boolean deleteWorker(Integer workerId) {
        workerRepository.deleteById(workerId);
        return true;
    }

    @Override
    public List<Worker> getAll() {
        return workerRepository.findAll();
    }

    @Override
    public Worker findWorkerByLastname(String filterText) {
        return workerRepository.findWorkerByLastname(filterText);
    }

    @Override
    public Worker save(Worker worker) {
        return workerRepository.save(worker);
    }
}
