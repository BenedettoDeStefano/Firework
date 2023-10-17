package FireworkDeStefano.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FireworkDeStefano.Entities.Product;
import FireworkDeStefano.Repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProductById(UUID id) {
		return productRepository.findById(id);
	}

	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	public void updateProduct(UUID id, Product product) {
		Optional<Product> existingProductOptional = productRepository.findById(id);
		if (existingProductOptional.isPresent()) {
			Product existingProduct = existingProductOptional.get();
			existingProduct.setNameProduct(product.getNameProduct());
			existingProduct.setBarcode(product.getBarcode());
			existingProduct.setCategories(product.getCategories());
			existingProduct.setTotalWeight(product.getTotalWeight());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setDateAdding(product.getDateAdding());
			productRepository.save(existingProduct);
		} else {
			System.out.println("Prodotto non trovato.");
		}
	}

	public void deleteProduct(UUID id) {
		productRepository.deleteById(id);
	}

}
