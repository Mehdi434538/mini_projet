package ma.ensa.servicesTests;


import ma.ensa.apms.model.Epic;
import ma.ensa.apms.repository.EpicRepository;
import ma.ensa.apms.services.EpicServiceImpl;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EpicServiceImplTest {

    @Mock
    private EpicRepository epicRepository;

    @InjectMocks
    private EpicServiceImpl epicService;

    private Epic epic1;
    private Epic epic2;


    @BeforeEach
    void setUp() {
        epic1 = new Epic();
        epic1.setId(1L);
        epic1.setTitre("Epic 1");
        epic1.setDescription("Description 1");
        epic1.setPriorite(1);
        epic1.setStatus("En cours");

        epic2 = new Epic();
        epic2.setId(2L);
        epic2.setTitre("Epic 2");
        epic2.setDescription("Description 2");
        epic2.setPriorite(2);
        epic2.setStatus("Terminé");
    }

    @Test
    void saveEpic() {
        when(epicRepository.save(epic1)).thenReturn(epic1);

        Epic savedEpic = epicService.saveEpic(epic1);

        assertNotNull(savedEpic);
        assertEquals("Epic 1", savedEpic.getTitre());
    }

    @Test
    void getAllEpic() {
        when(epicRepository.findAll()).thenReturn(Arrays.asList(epic1, epic2));

        List<Epic> epics = epicService.getAllEpic();

        assertNotNull(epics);
        assertEquals(2, epics.size());
    }

    @Test
    void getEpicById() {
        when(epicRepository.findById(1L)).thenReturn(Optional.of(epic1));

        Epic foundEpic = epicService.getEpicById(1L);

        assertNotNull(foundEpic);
        assertEquals(1L, foundEpic.getId().longValue());
    }

    @Test
    void deleteEpic() {

        when(epicRepository.findById(1L)).thenReturn(Optional.of(epic1));


        epicService.deleteEpic(1L);

        when(epicRepository.findById(1L)).thenReturn(Optional.empty());


        Epic deletedEpic = epicService.getEpicById(1L);
        assertNull(deletedEpic);
    }
}
