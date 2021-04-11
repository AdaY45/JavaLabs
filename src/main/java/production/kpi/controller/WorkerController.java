package production.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import production.kpi.pojo.people.Worker;
import production.kpi.service.WorkerService;

import java.util.List;


public class WorkerController {
    @Autowired
    private WorkerService workerService;

    Worker findWorkerById( Integer id) {
        return workerService.getWorker(id);
    }


    List<Worker> findAll() {
        return workerService.getAll();
    }
}
