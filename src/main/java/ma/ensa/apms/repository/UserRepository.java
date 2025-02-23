package ma.ensa.apms.repository;

import ma.ensa.apms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
