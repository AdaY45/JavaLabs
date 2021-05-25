package production.kpi.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import production.kpi.pojo.plane.PlanePart;
import production.kpi.repository.PlanePartRepository;
import production.kpi.service.impl.PlanePartServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlanePartServiceImplTest {
    @Mock
    private PlanePartRepository planePartRepository;
    @InjectMocks
    private PlanePartServiceImpl planePartService;
    private PlanePart planePart;
    private List<PlanePart> planeParts;

    @Before
    public void setUp() throws Exception {
        planePart = new PlanePart();
    }

    @Test
    public void findPartById() {
        when(planePartRepository.findById(1)).thenReturn(Optional.ofNullable(planePart));
        assertEquals(planePart, planePartService.findPartById(1));
        verify(planePartRepository).findById(1);
    }

    @Test
    public void update() {
        when(planePartRepository.save(planePart)).thenReturn(planePart);
        assertEquals(planePart, planePartService.update(planePart));
        verify(planePartRepository).save(planePart);
    }

    @Test
    public void findAll() {
        when(planePartRepository.findAll()).thenReturn(planeParts);
        assertEquals(planeParts, planePartService.findAll());
        verify(planePartRepository).findAll();
    }

    @Test
    public void create() {
        when(planePartRepository.save(planePart)).thenReturn(planePart);
        assertEquals(planePart, planePartService.create(planePart));
        verify(planePartRepository).save(planePart);
    }
}