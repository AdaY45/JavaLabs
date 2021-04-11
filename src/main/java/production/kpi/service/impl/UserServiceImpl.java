package production.kpi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.kpi.pojo.people.User;
import production.kpi.repository.UserRepository;
import production.kpi.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(User user) {
        userRepository.delete(user);
        return true;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
