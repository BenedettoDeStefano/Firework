package FireworkDeStefano.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FireworkDeStefano.Entities.Categories;
import FireworkDeStefano.Payload.CategoriesPayload;
import FireworkDeStefano.Repository.CategoriesRepository;

@Service
public class CategoriesService {
	private final CategoriesRepository categoriesRepository;

	@Autowired
	public CategoriesService(CategoriesRepository categoriesRepository) {
		this.categoriesRepository = categoriesRepository;
	}

	public List<Categories> getAllCategories() {
		return categoriesRepository.findAll();
	}

	public Optional<Categories> getCategoryById(UUID id) {
		return categoriesRepository.findById(id);
	}

	public void saveCategory(CategoriesPayload categoryPayload) {
		Categories category = new Categories();
		category.setNameCategory(categoryPayload.getNameCategory());
		categoriesRepository.save(category);
	}

	public void updateCategory(UUID id, CategoriesPayload categoryPayload) {
		Optional<Categories> existingCategoryOptional = categoriesRepository.findById(id);
		if (existingCategoryOptional.isPresent()) {
			Categories existingCategory = existingCategoryOptional.get();
			existingCategory.setNameCategory(categoryPayload.getNameCategory());
			categoriesRepository.save(existingCategory);
		} else {
			System.out.println("Categoria non trovata.");
		}
	}

	public void deleteCategory(UUID id) {
		categoriesRepository.deleteById(id);
	}
}