package FireworkDeStefano.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FireworkDeStefano.Entities.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, UUID> {

}
