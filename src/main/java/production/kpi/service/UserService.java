package production.kpi.service;

import production.kpi.pojo.people.User;

import java.util.List;

public interface UserService {
    User findUserById(Integer id);

    User findUserByEmail(String email);

    User updateUser(User user);

    boolean deleteUser(User user);

    User createUser(User user);

    List<User> findAll();

    List<User> findUserByLastname(String filterText);

    boolean delete(Integer userId);
}
