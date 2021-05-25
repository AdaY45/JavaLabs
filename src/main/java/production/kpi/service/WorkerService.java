package production.kpi.service;

import production.kpi.pojo.people.Worker;

import java.util.List;

public interface WorkerService {
    Worker getWorker(Integer id);

    Worker createWorker(Worker worker);

    //List<Worker> getAllWorkers(Navy plane);

    Worker updateWorker(Worker worker);

    boolean deleteWorker(Integer workerId);

    Worker save(Worker worker);

    List<Worker> getAll();

    Worker findWorkerByLastname(String filterText);
}
