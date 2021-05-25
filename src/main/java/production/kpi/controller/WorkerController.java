package production.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import production.kpi.pojo.people.Worker;
import production.kpi.service.WorkerService;

import java.util.List;

@Controller
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    public Worker findWorkerById( Integer id) {
        return workerService.getWorker(id);
    }


    public List<Worker> findAll() {
        return workerService.getAll();
    }

    /*public List<Worker> getAllWorkersOfPlane(Navy plane) {
        return workerService.getAllWorkers(plane);
    }*/

    public Worker save(Worker worker) {
        return workerService.save(worker);
    }

    public Worker updateWorker(Worker worker) {
        return workerService.updateWorker(worker);
    }

    public boolean delete(Integer workerId) {
        return workerService.deleteWorker(workerId);
    }

    public Worker findWorkerByLastname(String filterText) {
        return workerService.findWorkerByLastname(filterText);
    }
}
