package production.service;

import production.pojo.people.Worker;
import production.pojo.plane.Navy;
import java.util.List;

public interface WorkerService {
    Worker getWorker(long id);

    Worker createWorker(Worker worker);

    List<Worker> getAllWorkers(Navy plane);

    Worker updateWorker(Worker worker);

    boolean deleteWorker(Worker worker);

    List<Worker> getAll();
}
