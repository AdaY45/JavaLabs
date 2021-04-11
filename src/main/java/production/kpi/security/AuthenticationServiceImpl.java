package production.kpi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.kpi.exception.AuthenticationException;
import production.kpi.pojo.people.Client;
import production.kpi.pojo.people.Role;
import production.kpi.pojo.people.User;
import production.kpi.pojo.people.Worker;
import production.kpi.service.ClientService;
import production.kpi.service.RoleService;
import production.kpi.service.UserService;
import production.kpi.service.WorkerService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private ClientService clientService;

    @Override
    public production.kpi.pojo.people.User login(String email, String password) {
        User userFromDb = userService.findUserByEmail(email);
        if (userFromDb != null && password.equals(userFromDb.getPassword())) {
            return userFromDb;
        }
        throw new AuthenticationException("Wrong login or password");
    }

    @Override
    public User register(User user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        Role workerRole = roleService.findByName("WORKER");
        if (user.getRoles().stream()
                .anyMatch(r -> r.equals(workerRole))) {
            Worker worker = new Worker(user.getId(), user.getFirstName(), user.getLastName(),
                    "", user.getEmail(), user.getPassword());
            workerService.createWorker(worker);
            return new Worker(user.getId(), user.getFirstName(), user.getLastName(),
                    "", user.getEmail(), user.getPassword());
        } else {
            Client client = new Client(user.getFirstName(), user.getLastName()
                    , user.getEmail(), user.getPassword());
            clientService.save(client);
            return client;
        }
    }
}
