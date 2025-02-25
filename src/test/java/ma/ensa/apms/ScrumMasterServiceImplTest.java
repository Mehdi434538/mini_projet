package ma.ensa.apms;

import ma.ensa.apms.model.Project;
import ma.ensa.apms.model.ScrumMaster;
import ma.ensa.apms.model.Status;
import ma.ensa.apms.repository.ProjectRepository;
import ma.ensa.apms.repository.UserRepository;
import ma.ensa.apms.services.ScrumMasterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ScrumMasterServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ScrumMasterServiceImpl scrumMasterService;

    private ScrumMaster SM;
    private Project project;

    @BeforeEach
    void setUp() {
        SM = ScrumMaster.builder()
                .id(1L)
                .nom("SM1")
                .prenom("SM1")
                .email("SM1@gmail.com")
                .projects(new ArrayList<>())
                .build();
        project = Project.builder()
                .id(1L)
                .nom("Project 1")
                .description("Project Description")
                .status(Status.IN_PROGRESS)
                .dateDebut(new Date())
                .dateFin(new Date())
                .build();
    }

    @Test
    @DisplayName("Test for finding ScrumMaster by ID")
    void testFindById() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(SM));

        ScrumMaster result = scrumMasterService.findById(1L);

        assertNotNull(result, "ScrumMaster must be not null");
        assertEquals("SM1", result.getNom(), "Name must match");
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Test for creating a project for ScrumMaster")
    void testCreateProject() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(SM));
        when(projectRepository.save(project)).thenReturn(project);
        when(userRepository.save(SM)).thenReturn(SM);

        Project result = scrumMasterService.createProject(1L, project);

        assertNotNull(result, "Created project must not be null");
        assertEquals("Project 1", result.getNom(), "Project name must match");
        assertTrue(SM.getProjects().contains(project), "Project must be in ScrumMaster’s list");
        verify(projectRepository, times(1)).save(project);
        verify(userRepository, times(1)).save(SM);
    }

    @Test
    @DisplayName("Test for getting ScrumMaster’s projects")
    void testGetProjects() {
        SM.getProjects().add(project);
        when(userRepository.findById(1L)).thenReturn(Optional.of(SM));

        List<Project> result = scrumMasterService.getProjects(1L);

        assertNotNull(result, "Project list must be not null");
        assertEquals(1, result.size(), "Must return 1 project");
        assertEquals("Project 1", result.get(0).getNom(), "Project name must match");
        verify(userRepository, times(1)).findById(1L);
    }
}