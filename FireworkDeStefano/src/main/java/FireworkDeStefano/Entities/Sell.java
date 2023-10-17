package FireworkDeStefano.Entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sell {

	@Id
	@GeneratedValue
	private UUID id;
	@ManyToOne
	private Product productSell;
	private double gr;
	private Date date;
	@ManyToOne
	private User user;

}
