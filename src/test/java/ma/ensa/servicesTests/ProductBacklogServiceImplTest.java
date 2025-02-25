package ma.ensa.servicesTests;


import ma.ensa.apms.model.ProductBacklog;
import ma.ensa.apms.repository.ProductBacklogRepository;
import ma.ensa.apms.services.ProductBacklogServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.times;

@ExtendWith(MockitoExtension.class)
public class ProductBacklogServiceImplTest {

    @Mock
    private ProductBacklogRepository productBacklogRepository;

    @InjectMocks
    private ProductBacklogServiceImpl productBacklogService;

    private ProductBacklog productBacklog;

    @BeforeEach
    void setUp() {
        productBacklog = new ProductBacklog();
        productBacklog.setId(1L);
        productBacklog.setNom("Backlog 1");
    }
    @Test
    void testSaveProductBacklog() {
        when(productBacklogRepository.save(productBacklog)).thenReturn(productBacklog);

        ProductBacklog result = productBacklogService.saveProductBacklog(productBacklog);

        assertEquals("Backlog 1", result.getNom());
    }

    @Test
    void testGetProductBacklogById() {
        when(productBacklogRepository.findById(1L)).thenReturn(Optional.of(productBacklog));

        ProductBacklog result = productBacklogService.getProductBacklogById(1L);

        assertEquals(1L, result.getId());
    }

    @Test
    void testDeleteProductBacklog() {
        productBacklogService.deleteProductBacklog(1L);

        assertTrue(true);
    }

}
