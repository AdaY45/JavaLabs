package production.kpi.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import production.kpi.KpiApplication;
import production.kpi.pojo.people.Role;
import production.kpi.pojo.people.User;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KpiApplication.class)
public class RegistrationControllerTest {
    @Autowired
    private RegistrationController registrationController;
    @Autowired
    private UserController userController;
    private List<User> users;
    private Integer userId;

    @Before
    public void setUp () {
        users = userController.findAll();
    }

    @Test
    public void addUser() {
        Role role = new Role(Role.RoleName.CLIENT);
        User user = new User("user", "Test", "user", "password", Set.of(role));
        User test = registrationController.addUser(user);
        List<User> actual = userController.findAll();
        userId = actual.get(actual.size() - 1).getId();
        users.get(users.size() - 1).setId(userId);
        user.setId(userId);
        assertEquals(user, test);
    }

    @Test
    public void login() {
        Role role = new Role(Role.RoleName.CLIENT);
        role.setId(1);
        User expected = new User("user", "Test", "user", "password", Set.of(role));
        expected.setId(1);
        User actual = registrationController.login("user", "password");
        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        if (userId != null) {
            userController.delete(userId);
        }
    }
}