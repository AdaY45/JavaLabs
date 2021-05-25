package production.kpi.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import production.kpi.pojo.plane.TypeOfWork;
import production.kpi.repository.TypeOfWorkRepository;
import production.kpi.service.impl.TypeOfWorkServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TypeOfWorkServiceImplTest {
    @Mock
    private TypeOfWorkRepository typeOfWorkRepository;
    @InjectMocks
    private TypeOfWorkServiceImpl typeOfWorkService;
    private TypeOfWork type;

    @Before
    public void setUp() throws Exception {
        type = new TypeOfWork();
    }

    @Test
    public void save() {
        when(typeOfWorkRepository.save(type)).thenReturn(type);
        assertEquals(type, typeOfWorkService.save(type));
        verify(typeOfWorkRepository).save(type);
    }

    @Test
    public void findByTitle() {
        when(typeOfWorkRepository.findByTitle("fixing")).thenReturn(type);
        assertEquals(type, typeOfWorkService.findByTitle("fixing"));
        verify(typeOfWorkRepository).findByTitle("fixing");
    }
}