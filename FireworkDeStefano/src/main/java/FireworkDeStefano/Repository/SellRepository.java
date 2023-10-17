package FireworkDeStefano.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FireworkDeStefano.Entities.Sell;

@Repository
public interface SellRepository extends JpaRepository<Sell, UUID> {

}
