package production.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import production.exception.AuthenticationException;
import production.pojo.people.User;
import production.security.AuthenticationService;

@RestController("/register")
public class RegistrationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public void addUser(@RequestBody @Valid User user)
            throws AuthenticationException {
        authenticationService.register(user);
    }
}
