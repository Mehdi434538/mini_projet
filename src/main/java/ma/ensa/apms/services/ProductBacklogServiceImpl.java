package ma.ensa.apms.services;

import lombok.AllArgsConstructor;
import ma.ensa.apms.model.ProductBacklog;
import ma.ensa.apms.repository.ProductBacklogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductBacklogServiceImpl implements IProductBacklogService{
    private ProductBacklogRepository productBacklogRepository;

    @Override
    public ProductBacklog saveProductBacklog(ProductBacklog productBacklog) {
        return productBacklogRepository.save(productBacklog);
    }

    @Override
    public List<ProductBacklog> getAllProductBacklog() {
        return productBacklogRepository.findAll();
    }

    @Override
    public ProductBacklog getProductBacklogById(Long id) {
        return productBacklogRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProductBacklog(Long id) {
        productBacklogRepository.deleteById(id);
    }
}
