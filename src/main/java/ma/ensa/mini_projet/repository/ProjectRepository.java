package ma.ensa.mini_projet.repository;

import ma.ensa.mini_projet.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
