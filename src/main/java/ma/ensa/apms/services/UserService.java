package ma.ensa.apms.services;

import ma.ensa.apms.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(Long id);
    public User save(User user);
    public User update(User user);
    public void delete(User user);
}
