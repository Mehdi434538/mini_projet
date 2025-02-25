package ma.ensa.servicesTests;

import ma.ensa.apms.model.UserStory;
import ma.ensa.apms.repository.UserStoryRepository;
import ma.ensa.apms.services.UserStoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserStoryServiceImplTest {

    @Mock
    private UserStoryRepository userStoryRepository;

    @InjectMocks
    private UserStoryServiceImpl userStoryService;

    private UserStory userStory1, userStory2;

    @BeforeEach
    void setUp() {
        userStory1 = new UserStory();
        userStory1.setId(1L);
        userStory1.setTitre("Story 1");
        userStory1.setDescription("Description 1");
        userStory1.setPriorite(1);
        userStory1.setStatus("TODO");

        userStory2 = new UserStory();
        userStory2 = new UserStory();
        userStory2.setId(2L);
        userStory2.setTitre("Story 2");
        userStory2.setDescription("Description 2");
        userStory2.setPriorite(2);
        userStory2.setStatus("IN_PROGRESS");
    }

    @Test
    void saveUserStory() {
        when(userStoryRepository.save(userStory1)).thenReturn(userStory1);

        UserStory savedStory = userStoryService.saveUserStory(userStory1);

        assertNotNull(savedStory);
        assertEquals(userStory1.getId(), savedStory.getId());
        assertEquals(userStory1.getTitre(), savedStory.getTitre());
    }

    @Test
    void getAllUserStory() {
        when(userStoryRepository.findAll()).thenReturn(Arrays.asList(userStory1, userStory2));

        List<UserStory> stories = userStoryService.getAllUserStory();

        assertNotNull(stories);
        assertEquals(2, stories.size());
    }

    @Test
    void getUserStoryById() {
        when(userStoryRepository.findById(1L)).thenReturn(Optional.of(userStory1));

        UserStory foundStory = userStoryService.getUserStoryById(1L);

        assertNotNull(foundStory);
        assertEquals(1L, foundStory.getId().longValue());
    }

    @Test
    void getUserStoryById_NotFound() {
        when(userStoryRepository.findById(3L)).thenReturn(Optional.empty());

        UserStory foundStory = userStoryService.getUserStoryById(3L);

        assertNull(foundStory);
    }

    @Test
    void deleteUserStory() {

        when(userStoryRepository.findById(1L)).thenReturn(Optional.of(userStory1));


        userStoryService.deleteUserStory(1L);


        when(userStoryRepository.findById(1L)).thenReturn(Optional.empty());

        UserStory deletedStory = userStoryService.getUserStoryById(1L);
        assertNull(deletedStory);
    }


}
