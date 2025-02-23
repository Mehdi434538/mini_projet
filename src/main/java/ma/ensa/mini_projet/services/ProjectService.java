package ma.ensa.mini_projet.services;

import ma.ensa.mini_projet.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProjectService {
    public List<Project> findAll();
    public Project findById(Long id);
    public Project save(Project project);
    public Project update(Project project);
    public void delete(Project project);
}
