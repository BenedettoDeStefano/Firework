package FireworkDeStefano.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import FireworkDeStefano.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
