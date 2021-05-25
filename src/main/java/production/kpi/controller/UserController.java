package production.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import production.kpi.pojo.people.User;
import production.kpi.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<User> findAll() {
        return userService.findAll();
    }

    public List<User> findUserByLastname(String filterText) {
        return userService.findUserByLastname(filterText);
    }

    public boolean delete(Integer userId) {
        return userService.delete(userId);
    }
}
