package ma.ensa.apms.services;

import ma.ensa.apms.model.Project;
import ma.ensa.apms.model.ScrumMaster;
import ma.ensa.apms.repository.ProjectRepository;
import ma.ensa.apms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScrumMasterServiceImpl implements ScrumMasterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public ScrumMaster findById(Long id) {
        return userRepository.findById(id)
                .filter(user -> user instanceof ScrumMaster)
                .map(user -> (ScrumMaster) user)
                .orElse(null);
    }

    public Project createProject(Long scrumMasterId, Project project) {
        ScrumMaster scrumMaster = findById(scrumMasterId);
        if (scrumMaster == null) {
            throw new RuntimeException("ScrumMaster not found"); // IllegalArgumentException more better
        }
        project = projectRepository.save(project);
        List<Project> projects = scrumMaster.getProjects();
        projects.add(project);
        userRepository.save(scrumMaster);
        return project;
    }

    public List<Project> getProjects(Long scrumMasterId) {
        ScrumMaster scrumMaster = findById(scrumMasterId);
        return scrumMaster != null ? scrumMaster.getProjects() : null;
    }
}