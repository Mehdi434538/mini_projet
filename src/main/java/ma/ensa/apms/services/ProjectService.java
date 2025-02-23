package ma.ensa.apms.services;

import ma.ensa.apms.model.Project;

import java.util.List;

public interface ProjectService {
    public List<Project> findAll();
    public Project findById(Long id);
    public Project save(Project project);
    public Project update(Project project);
    public void delete(Project project);
}
