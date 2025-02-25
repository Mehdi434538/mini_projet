package ma.ensa.apms.services;

import ma.ensa.apms.model.Project;
import ma.ensa.apms.model.ScrumMaster;

import java.util.List;

public interface ScrumMasterService {
    public Project createProject(Long scrumMasterId, Project project);
    public List<Project> getProjects(Long scrumMasterId);
}
