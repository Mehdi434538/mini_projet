package ma.ensa.apms;

import ma.ensa.apms.model.ProductOwner;
import ma.ensa.apms.model.ScrumMaster;
import ma.ensa.apms.model.TeamMember;
import ma.ensa.apms.model.User;
import ma.ensa.apms.repository.UserRepository;
import ma.ensa.apms.services.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User PO;
    private User SM;

    @BeforeEach
    void setUp() {
        PO = ProductOwner.builder()
                .id(1L)
                .nom("PO1")
                .prenom("PO1")
                .email("PO1@gmail.com")
                .build();
        SM = ScrumMaster.builder()
                .id(2L)
                .nom("SM1")
                .prenom("SM1")
                .email("SM1@gmail.com")
                .build();
    }

    @Test
    @DisplayName("Test for finding all users")
    void testFindAll() {
        List<User> users = Arrays.asList(
                PO,
                SM
        );
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.findAll();

        assertNotNull(result, "User list must not be null");
        assertEquals(2, result.size(), "Must return 2");
        assertEquals("PO1", result.get(0).getNom(), "First user name must match");
        assertEquals("SM1", result.get(1).getNom(), "Second user name must match");
        verify(userRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Test for finding user by ID")
    void testFindById() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(PO));
        User foundUser = userService.findById(1L);
        assertNotNull(foundUser, "Found user must not be null");
        assertEquals("PO1@gmail.com", foundUser.getEmail(), "Email must match");
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Test for returning null when user ID not found")
    void testFindByIdNotFound() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());
        User foundUser = userService.findById(99L);
        assertNull(foundUser, "Must return null if user ID not found");
        verify(userRepository, times(1)).findById(99L);
    }

    @Test
    @DisplayName("Test for saving a user")
    void testSave() {
        // saving PO
        when(userRepository.save(PO)).thenReturn(PO);
        User savedUser = userService.save(PO);
        assertNotNull(savedUser, "Saved PO must be not null");
        assertEquals("PO1", savedUser.getNom(), "Saved user name must be the same");
        verify(userRepository, times(1)).save(PO);
        // saving SM
        when(userRepository.save(SM)).thenReturn(SM);
        savedUser = userService.save(SM);
        assertNotNull(savedUser, "Saved SM must be not null");
        assertEquals("SM1", savedUser.getNom(), "Saved user name must be the same");
        verify(userRepository, times(1)).save(SM);
    }

    @Test
    @DisplayName("Test for updating a user")
    void testUpdate() {
        User updatedUser = ProductOwner.builder()
                .id(1L)
                .nom("PO1")
                .prenom("PO1-updated")
                .email("PO1@gmail.com")
                .build();
        when(userRepository.save(updatedUser)).thenReturn(updatedUser);
        User result = userService.update(updatedUser);
        assertNotNull(result, "Updated user must be not null");
        assertEquals("PO1-updated", result.getPrenom(), "Updated user name must be the same");
        verify(userRepository, times(1)).save(updatedUser);
    }

    @Test
    @DisplayName("Test for deleting a user")
    void testDelete() {
        doNothing().when(userRepository).delete(PO);
        userService.delete(PO);
        verify(userRepository, times(1)).delete(PO);
    }
}