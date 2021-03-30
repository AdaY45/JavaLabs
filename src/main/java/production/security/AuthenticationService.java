package production.security;

import production.pojo.people.User;

public interface AuthenticationService {
    User login(String email, String password);

    User register(User user);
}