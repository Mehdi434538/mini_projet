package ma.ensa.apms.repository;

import ma.ensa.apms.model.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStoryRepository extends JpaRepository<UserStory, Long> {
}
