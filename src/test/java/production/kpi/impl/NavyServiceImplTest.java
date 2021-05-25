package production.kpi.impl;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import production.kpi.pojo.plane.Navy;
import production.kpi.repository.NavyRepository;
import production.kpi.service.impl.NavyServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NavyServiceImplTest {
    @Mock
    private NavyRepository navyRepository;
    @InjectMocks
    private NavyServiceImpl navyService;
    private Navy navy;
    private List<Navy> planes;

    @BeforeEach
    public void setUp() {
        navy = new Navy();
        planes = new ArrayList<>();
        planes.add(navy);
    }

    @Test
    public void saveNavy() {
        when(navyRepository.save(navy)).thenReturn(navy);
        assertEquals(navy, navyService.saveNavy(navy));
        verify(navyRepository).save(navy);
    }

    @Test
    public void updateNavy() {
        when(navyRepository.save(navy)).thenReturn(navy);
        assertEquals(navy, navyService.updateNavy(navy));
        verify(navyRepository).save(navy);
    }

    @Test
    public void findAll() {
        navy = new Navy();
        when(navyRepository.findAll()).thenReturn(planes);
        assertEquals(planes, navyService.findAll());
        verify(navyRepository).findAll();
    }
}