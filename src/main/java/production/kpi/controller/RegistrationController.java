package production.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import production.kpi.exception.AuthenticationException;
import production.kpi.pojo.people.User;
import production.kpi.security.AuthenticationService;


public class RegistrationController {
    @Autowired
    private AuthenticationService authenticationService;


    public void addUser( User user)
            throws AuthenticationException {
        authenticationService.register(user);
    }
}
