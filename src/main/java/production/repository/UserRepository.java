package production.repository;

import production.pojo.people.User;

public interface UserRepository {
    User findUserById(long id);

    User findUserByEmail(String email);

    User updateUser(User user);

    boolean deleteUser(User user);

    User createUser(User user);
}