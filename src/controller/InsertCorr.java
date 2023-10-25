package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import model.ContoCorrente;
import model.Correntista;

public class InsertCorr {
	static Scanner input= new Scanner(System.in);
	
	public static String check(String label,String dato){
		String rit =null;
		  
		 do {
	     	System.out.println(label);
	     	rit = input.next();
	     }while(rit.matches(dato) == false)  ;
	     
	     	 
		return rit;
	};	
	public static void main(String[] args) {
		 
		  LocalDate dataconto= LocalDate.now();;
		  LocalTime oraconto= LocalTime.now();
		 
		  
      ContoCorrente conto = service.Dao.selectConto();
      Correntista cor = new Correntista(check("Inserisci codFiscale","^[a-zA-Z \\-\\.\\']*$"),
      		check("Inserisci nome ","^[a-zA-Z \\-\\.\\']*$"),
      		check("Inserisci cognome ","^[a-zA-Z \\-\\.\\']*$"),
      		check("Inserisci via ","^[A-Za-z0-9+_.-]+@(.+)$"),
      		conto,
      		dataconto,
      		oraconto);
     
    
      String msg = service.Dao.insertCor(cor, conto)== true? "tutto ok ":"fallito";
  	  System.out.println(msg);
  	 
      
	
      
	}

}
