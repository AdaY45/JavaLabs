package production.kpi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import production.kpi.exception.AuthenticationException;
import production.kpi.pojo.people.Role;
import production.kpi.pojo.people.User;
import production.kpi.service.RoleService;
import production.kpi.service.UserService;
import production.kpi.service.WorkerService;

import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User login(String email, String password) {
        User userFromDb = userService.findUserByEmail(email);
        if (userFromDb != null && passwordEncoder.matches(password,
                userFromDb.getPassword())) {
            return userFromDb;
        }
        throw new AuthenticationException("Wrong login or password");
    }

    @Override
    public User register(User user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            roleService.save(role);
        }
        newUser.setRoles(roles);
        return userService.createUser(newUser);
    }

}
