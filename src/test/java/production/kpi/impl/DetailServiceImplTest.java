package production.kpi.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import production.kpi.pojo.plane.Detail;
import production.kpi.repository.DetailRepository;
import production.kpi.service.impl.DetailServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class DetailServiceImplTest {
    @Mock
    private DetailRepository detailRepository;
    @InjectMocks
    private DetailServiceImpl detailService;
    private Detail detail;
    private List<Detail> details;

    @Before
    public void setUp() throws Exception {
        detail = new Detail();
    }

    @Test
    public void findAll() {
        when(detailRepository.findAll()).thenReturn(details);
        assertEquals(details, detailService.findAll());
        verify(detailRepository).findAll();
    }

    @Test
    public void findById() {
        detail = new Detail();
        when(detailRepository.findById(1)).thenReturn(Optional.of(detail));
        assertEquals(detail, detailService.findById(1));
        verify(detailRepository).findById(1);
    }

    @Test
    public void save() {
        when(detailRepository.save(detail)).thenReturn(detail);
        assertEquals(detail, detailService.save(detail));
        verify(detailRepository).save(detail);
    }
}