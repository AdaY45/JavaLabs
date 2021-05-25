package production.kpi.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import production.kpi.pojo.people.User;
import production.kpi.repository.UserRepository;
import production.kpi.service.impl.UserServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @Test
    public void findUserById() {
        when(userRepository.findById(1)).thenReturn(Optional.ofNullable(user));
        assertEquals(user, userService.findUserById(1));
        verify(userRepository).findById(1);
    }

    @Test
    public void findUserByEmail() {
        when(userRepository.findUserByEmail("email")).thenReturn(user);
        assertEquals(user, userService.findUserByEmail("email"));
        verify(userRepository).findUserByEmail("email");
    }

    @Test
    public void updateUser() {
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user, userService.updateUser(user));
        verify(userRepository).save(user);
    }

    @Test
    public void createUser() {
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user, userService.createUser(user));
        verify(userRepository).save(user);
    }
}