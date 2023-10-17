package FireworkDeStefano.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FireworkDeStefano.Entities.Product;
import FireworkDeStefano.Entities.Sell;
import FireworkDeStefano.Repository.ProductRepository;
import FireworkDeStefano.Repository.SellRepository;

@Service
public class SellService {

	private final SellRepository sellRepository;
	private final ProductRepository productRepository;

	@Autowired
	public SellService(SellRepository sellRepository, ProductRepository productRepository) {
		this.sellRepository = sellRepository;
		this.productRepository = productRepository;
	}

	public List<Sell> getAllSells() {
		return sellRepository.findAll();
	}

	public Optional<Sell> getSellById(UUID id) {
		return sellRepository.findById(id);
	}

	public void saveSell(Sell sell) {
		sell.setDate(new Date());
		sellRepository.save(sell);
	}

	public void updateSell(UUID id, Sell sell) {
		Optional<Sell> existingSellOptional = sellRepository.findById(id);
		if (existingSellOptional.isPresent()) {
			Sell existingSell = existingSellOptional.get();
			Product product = existingSell.getProductSell();

			double pesoOriginale = product.getTotalWeight();
			double pesoVenduto = existingSell.getGr();
			double differenzaPeso = pesoOriginale - pesoVenduto;

			existingSell.setProductSell(sell.getProductSell());
			existingSell.setGr(sell.getGr());
			existingSell.setDate(new Date());
			sellRepository.save(existingSell);

			product.setTotalWeight(differenzaPeso);
			productRepository.save(product);
		} else {
			System.out.println("Vendita non trovata.");
		}
	}

	public void deleteSell(UUID id) {
		sellRepository.deleteById(id);
	}
}