package model;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;
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
@Table(name = "correntista")
public class Correntista {
	  @Id   
	  @Column(name = "cf")
	  private String cf;
	  private String nome;
	  private String  cognome;
	  private String via;
	  @OneToOne( fetch= FetchType.EAGER )
	  @JoinColumn( name="numerocc" )
	  private ContoCorrente numerocc;
	  private LocalDate dataconto;
	  private LocalTime oraconto;
}
