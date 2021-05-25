package production.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import production.kpi.exception.AuthenticationException;
import production.kpi.pojo.people.User;
import production.kpi.security.AuthenticationService;

@Controller
public class RegistrationController {
    @Autowired
    private AuthenticationService authenticationService;

    public User addUser(User user)
            throws AuthenticationException {
        return authenticationService.register(user);
    }

    public User login(String email, String password)
            throws AuthenticationException {
        return authenticationService.login(email, password);
    }
}
