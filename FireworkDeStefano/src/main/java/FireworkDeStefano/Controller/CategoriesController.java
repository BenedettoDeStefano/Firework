package FireworkDeStefano.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FireworkDeStefano.Entities.Categories;
import FireworkDeStefano.Payload.CategoriesPayload;
import FireworkDeStefano.Service.CategoriesService;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

	private final CategoriesService categoriesService;

	@Autowired
	public CategoriesController(CategoriesService categoriesService) {
		this.categoriesService = categoriesService;
	}

	@GetMapping("")
	public ResponseEntity<List<Categories>> getAllCategories() {
		List<Categories> categories = categoriesService.getAllCategories();
		return ResponseEntity.ok(categories);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categories> getCategoryById(@PathVariable UUID id) {
		Optional<Categories> category = categoriesService.getCategoryById(id);
		return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("")
	public ResponseEntity<Categories> createCategory(@RequestBody CategoriesPayload categoryPayload) {
		categoriesService.saveCategory(categoryPayload);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Categories> updateCategory(@PathVariable UUID id,
			@RequestBody CategoriesPayload categoryPayload) {
		categoriesService.updateCategory(id, categoryPayload);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
		categoriesService.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}
}
