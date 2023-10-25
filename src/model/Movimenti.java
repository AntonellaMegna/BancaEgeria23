package model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "movimenti")
public class Movimenti {
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int idm;
	  private String tipo;
	  private BigDecimal  amount;
	  private LocalDate datam;
	  private LocalTime oram;  
	  @ManyToOne( fetch= FetchType.EAGER )
	  @JoinColumn( name="numerocc" )
	  private ContoCorrente numerocc;
	  
	  public Movimenti(String tipo, BigDecimal amount, LocalDate datam, LocalTime oram, ContoCorrente numerocc) {
			super();
			this.tipo = tipo;
			this.amount = amount;
			this.datam = datam;
			this.oram = oram;
			this.numerocc = numerocc;
		}
	
	}
	
	
	
	
	
	 

