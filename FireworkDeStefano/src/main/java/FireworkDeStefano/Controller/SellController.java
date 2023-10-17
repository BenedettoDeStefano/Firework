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

import FireworkDeStefano.Entities.Sell;
import FireworkDeStefano.Service.SellService;

@RestController
@RequestMapping("/sells")
public class SellController {

	private final SellService sellService;

	@Autowired
	public SellController(SellService sellService) {
		this.sellService = sellService;
	}

	@GetMapping("")
	public ResponseEntity<List<Sell>> getAllSells() {
		List<Sell> sells = sellService.getAllSells();
		return ResponseEntity.ok(sells);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Sell> getSellById(@PathVariable UUID id) {
		Optional<Sell> sell = sellService.getSellById(id);
		return sell.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("")
	public ResponseEntity<Sell> createSell(@RequestBody Sell sell) {
		sellService.saveSell(sell);
		return ResponseEntity.ok(sell);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Sell> updateSell(@PathVariable UUID id, @RequestBody Sell sell) {
		sellService.updateSell(id, sell);
		return ResponseEntity.ok(sell);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSell(@PathVariable UUID id) {
		sellService.deleteSell(id);
		return ResponseEntity.noContent().build();
	}
}
