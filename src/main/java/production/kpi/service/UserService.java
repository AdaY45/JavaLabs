package production.kpi.service;

import production.kpi.pojo.people.User;

public interface UserService {
    User findUserById(Integer id);

    User findUserByEmail(String email);

    User updateUser(User user);

    boolean deleteUser(User user);

    User createUser(User user);
}
