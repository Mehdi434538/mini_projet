package ma.ensa.apms.services;

import ma.ensa.apms.model.User;
import ma.ensa.apms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository UserRepository;

    @Override
    public List<User> findAll() {
        return UserRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return UserRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return UserRepository.save(user);
    }

    @Override
    public User update(User user) {
        return UserRepository.save(user);
    }

    @Override
    public void delete(User user) {
        UserRepository.delete(user);
    }
}
