package ma.ensa.mini_projet.services;

import ma.ensa.mini_projet.model.Project;
import ma.ensa.mini_projet.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(Long id);
    public User save(User user);
    public User update(User user);
    public void delete(User user);
}
