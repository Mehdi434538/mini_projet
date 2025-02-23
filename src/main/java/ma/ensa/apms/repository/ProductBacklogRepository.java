package ma.ensa.apms.repository;

import ma.ensa.apms.model.ProductBacklog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBacklogRepository extends JpaRepository<ProductBacklog, Long> {
}
