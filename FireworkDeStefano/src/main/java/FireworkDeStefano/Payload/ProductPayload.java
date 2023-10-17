package FireworkDeStefano.Payload;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPayload {
	private String nameProduct;
	private String barcode;
	private UUID categoryId;
	private double totalWeight;
	private double price;
	private Date dateAdding;
	private int stock;
}