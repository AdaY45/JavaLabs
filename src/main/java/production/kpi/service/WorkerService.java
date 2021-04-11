package production.kpi.service;
import production.kpi.pojo.people.Worker;
import production.kpi.pojo.plane.Navy;

import java.util.List;

public interface WorkerService {
    Worker getWorker(Integer id);

    Worker createWorker(Worker worker);

    List<Worker> getAllWorkers(Navy plane);

    Worker updateWorker(Worker worker);

    boolean deleteWorker(Worker worker);

    List<Worker> getAll();
}
