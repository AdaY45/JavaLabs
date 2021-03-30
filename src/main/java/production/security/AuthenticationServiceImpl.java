package production.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.exception.AuthenticationException;
import production.pojo.people.Client;
import production.pojo.people.Role;
import production.pojo.people.User;
import production.pojo.people.Worker;
import production.service.ClientService;
import production.service.RoleService;
import production.service.UserService;
import production.service.WorkerService;

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
    public User login(String email, String password) {
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
        Role workerRole = roleService.findByTitle("WORKER");
        if (user.getRole().equals(workerRole)) {
            Worker worker = new Worker(user.getId(), user.getFirstName(), user.getLastName(),
                    "", user.getEmail(), user.getPassword());
            workerService.createWorker(worker);
            return new Worker(user.getId(), user.getFirstName(), user.getLastName(),
                    "", user.getEmail(), user.getPassword());
        } else {
            Client client = new Client(user.getId(), user.getFirstName(), user.getLastName()
                    , user.getEmail(), user.getPassword());
            clientService.save(client);
            return client;
        }
    }
}
