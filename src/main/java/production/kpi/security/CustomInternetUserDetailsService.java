package production.kpi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import production.kpi.pojo.people.User;
import production.kpi.service.UserService;

@Service
@Primary
public class CustomInternetUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public CustomInternetUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(email);
        org.springframework.security.core.userdetails.User.UserBuilder userBuilder;
        if (user != null) {
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(email);
            userBuilder.password(user.getPassword());
            String[] roles = user.getRoles().stream()
                    .map(role -> role.getName().name())
                    .toArray(String[]::new);
            userBuilder.roles(roles);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return userBuilder.build();
    }
}