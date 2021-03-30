package production.repository;

import production.pojo.people.Worker;

import java.util.List;

public interface WorkerRepository {
    Worker findWorkerById(long id);

    Worker updateWorker(Worker worker);

    boolean deleteWorker(Worker worker);

    Worker createWorker(Worker worker);

    List<Worker> findAll();
}

