package production.kpi.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import production.kpi.KpiApplication;
import production.kpi.pojo.people.Client;
import production.kpi.pojo.people.Worker;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KpiApplication.class)
public class WorkerControllerTest {
    @Autowired
    private WorkerController workerController;
    private List<Worker> workers;
    private Integer workerId;
    private Worker worker1;

    @Before
    public void setUp () {
        workers = workerController.findAll();
        worker1 = new Worker("Zalizniy", "Dmytro", "Mechanic", "zaldm@gmail.com",
                "Zal1123456");
    }

    @Test
    public void findAll() {
        List<Worker> expected = new ArrayList<>();
        Worker worker2 = new Worker("Golyb", "Olga", "Technician", "tech@gmail.com",
                "123456");
        expected.add(worker1);
        expected.add(worker2);
        Assertions.assertEquals(expected, workers);
    }

    @Test
    public void findById() {
        Worker actual = workerController.findWorkerById(1);
        Assertions.assertEquals(worker1, actual);
    }

    @Test
    public void save() {
        Worker test = new Worker("Golyb", "Olga", "Technician", "tech@gmail.com",
                "123456");
        Worker actual = workerController.save(test);
        List<Worker> actualWorkers = workerController.findAll();
        workerId = actualWorkers.get(actualWorkers.size() - 1).getId();
        workers.get(workers.size() - 1).setId(workerId);
        test.setId(workerId);
        assertEquals(test, actual);
    }
    @After
    public void tearDown () {
        if (workerId != null) {
            workerController.delete(workerId);
        }
    }
}
