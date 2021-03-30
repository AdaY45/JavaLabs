package production.repository.impl;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import production.pojo.people.User;
import production.repository.UserRepository;

@Service
public class UserRepositoryImpl implements UserRepository {

    @Override
    public User findUserById(long id) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public User findUserByEmail(String email) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public User updateUser(User user) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean deleteUser(User user) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public User createUser(User user) {
        throw new NotImplementedException("TODO");
    }
}