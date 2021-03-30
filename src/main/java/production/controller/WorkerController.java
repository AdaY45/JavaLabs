package production.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import production.pojo.people.Worker;
import production.service.WorkerService;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {
    @Autowired
    private WorkerService workerService;
    @GetMapping("/id")
    Worker findWorkerById(@RequestParam(name = "id") Long id) {
        return workerService.getWorker(id);
    }

    @GetMapping
    List<Worker> findAll() {
        return workerService.getAll();
    }
}
