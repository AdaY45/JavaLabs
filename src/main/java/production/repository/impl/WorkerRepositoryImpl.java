package production.repository.impl;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import production.pojo.people.Worker;
import production.repository.WorkerRepository;

import java.util.List;

@Repository
public class WorkerRepositoryImpl implements WorkerRepository {
    public Worker findWorkerById(long id) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Worker updateWorker(Worker worker) {
        throw new NotImplementedException("TODO");
    }

    public boolean deleteWorker(Worker worker) {return false;}

    public Worker createWorker(Worker worker) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public List<Worker> findAll() {
        throw new NotImplementedException("TODO");
    }
}
