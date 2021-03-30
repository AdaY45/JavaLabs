package production.service;

import production.pojo.people.User;

public interface UserService {
    User findUserById(long id);

    User findUserByEmail(String email);

    User updateUser(User user);

    boolean deleteUser(User user);

    User createUser(User user);
}
