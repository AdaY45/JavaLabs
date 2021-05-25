package production.kpi.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import production.kpi.pojo.people.Role;
import production.kpi.repository.RoleRepository;
import production.kpi.service.impl.RoleServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RoleServiceImplTest {
    @Mock
    private RoleRepository roleRepository;
    @InjectMocks
    private RoleServiceImpl roleService;
    private Role role;

    @Before
    public void setUp() throws Exception {
        role = new Role();
    }

    @Test
    public void save() {
        when(roleRepository.save(role)).thenReturn(role);
        assertEquals(role, roleService.save(role));
        verify(roleRepository).save(role);
    }

    @Test
    public void findByName() {
        when(roleRepository.findByName("admin")).thenReturn(role);
        assertEquals(role, roleService.findByName("admin"));
        verify(roleRepository).findByName("admin");
    }
}