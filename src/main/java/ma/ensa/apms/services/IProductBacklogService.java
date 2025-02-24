package ma.ensa.apms.services;

import ma.ensa.apms.model.ProductBacklog;

import java.util.List;

public interface IProductBacklogService {
    ProductBacklog saveProductBacklog (ProductBacklog productBacklog);
    List<ProductBacklog> getAllProductBacklog();
    ProductBacklog getProductBacklogById(Long id);
    void deleteProductBacklog(Long id);
}
