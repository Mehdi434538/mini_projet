package ma.ensa.mini_projet.repository;

import ma.ensa.mini_projet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
