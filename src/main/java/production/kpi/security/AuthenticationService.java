package production.kpi.security;

import production.kpi.pojo.people.User;

public interface AuthenticationService {
    User login(String email, String password);

    User register(User user);
}