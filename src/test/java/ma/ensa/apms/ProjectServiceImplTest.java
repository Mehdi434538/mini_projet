package ma.ensa.apms;

import ma.ensa.apms.model.Project;
import ma.ensa.apms.model.Status;
import ma.ensa.apms.repository.ProjectRepository;
import ma.ensa.apms.services.ProjectServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    private Project project;

    @BeforeEach
    void setUp() {
        project = new Project(1L, "Test Project", "Test Description", Status.IN_PROGRESS, new Date(), new Date(), null);
    }

    @Test
    @DisplayName("Test for finding project by ID")
    void testFindById() {
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));
        Project foundProject = projectService.findById(1L);
        assertNotNull(foundProject, "Project should not be null");
        assertEquals("Test Project", foundProject.getNom(), "Project name should match");
        verify(projectRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Test for saving a project")
    void testSave() {
        when(projectRepository.save(project)).thenReturn(project);
        Project savedProject = projectService.save(project);
        assertNotNull(savedProject, "Saved project should not be null");
        assertEquals("Test Project", savedProject.getNom(), "Saved project name should match");
        verify(projectRepository, times(1)).save(project);
    }

    @Test
    @DisplayName("Test for deleting a project")
    void testDelete() {
        doNothing().when(projectRepository).delete(project);
        projectService.delete(project);
        verify(projectRepository, times(1)).delete(project);
    }
}