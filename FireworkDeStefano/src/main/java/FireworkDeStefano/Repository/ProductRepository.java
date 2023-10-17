package FireworkDeStefano.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import FireworkDeStefano.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
	List<Product> findByNameProductContainingIgnoreCase(String nameProduct);
}
