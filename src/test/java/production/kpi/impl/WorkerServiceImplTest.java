package production.kpi.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import production.kpi.pojo.people.Worker;
import production.kpi.repository.WorkerRepository;
import production.kpi.service.impl.WorkerServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WorkerServiceImplTest {
    @Mock
    private WorkerRepository workerRepository;
    @InjectMocks
    private WorkerServiceImpl workerService;
    private Worker worker;
    private List<Worker> workers;

    @Before
    public void setUp() throws Exception {
        worker = new Worker();
        workers = new ArrayList<>();
        workers.add(worker);
    }

    @Test
    public void getWorker() {
        when(workerRepository.findById(1)).thenReturn(Optional.ofNullable(worker));
        assertEquals(worker, workerService.getWorker(1));
        verify(workerRepository).findById(1);
    }

    @Test
    public void createWorker() {
        when(workerRepository.save(worker)).thenReturn(worker);
        assertEquals(worker, workerService.createWorker(worker));
        verify(workerRepository).save(worker);
    }

    @Test
    public void updateWorker() {
        when(workerRepository.save(worker)).thenReturn(worker);
        assertEquals(worker, workerService.updateWorker(worker));
        verify(workerRepository).save(worker);
    }

    @Test
    public void getAll() {
        when(workerRepository.findAll()).thenReturn(workers);
        assertEquals(workers, workerService.getAll());
        verify(workerRepository).findAll();
    }

}