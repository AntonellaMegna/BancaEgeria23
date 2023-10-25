package model;


import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter 
@ToString

@Entity
@Table(name = "conto")
public class ContoCorrente {

	@Id   
	  private String numeroconto;
 	  private String iban;
	  private BigDecimal  amount;
	  private String numerocarta;
	  private boolean busy;
	  private String pin;
	
	
	
	 
}
