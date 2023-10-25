/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;

import javax.swing.*;

import model.ContoCorrente;
import model.Movimenti;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


public class PrelievoVeloce extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
   
    
    PrelievoVeloce(){
        
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("FAST CASH");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (4*x);
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"FAST CASH");
    
        
        
        
        l1 = new JLabel("SELEZIONA QUANTITA");
        l1.setFont(new Font("System", Font.BOLD, 38));
        
     
        
    
    
       
        b1 = new JButton("10");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
    
        b2 = new JButton("500");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("1000");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        b4 = new JButton("2000");
        b4.setFont(new Font("System", Font.BOLD, 18));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        
        b5 = new JButton("5000");
        b5.setFont(new Font("System", Font.BOLD, 18));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        
        b6 = new JButton("10000");
        b6.setFont(new Font("System", Font.BOLD, 18));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        
        b7 = new JButton("INDIETRO");
        b7.setFont(new Font("System", Font.BOLD, 14));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        
        b7 = new JButton("ESCI");
        b7.setFont(new Font("System", Font.BOLD, 18));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        
        
        setLayout(null);
        
      
        
     
        
        l1.setBounds(100,100,700,40);
        add(l1);
        
        b1.setBounds(40,250,300,60);
        add(b1);
        
        b2.setBounds(440,250,300,60);
        add(b2);
        
        b3.setBounds(40,360,300,60);
        add(b3);
        
        b4.setBounds(440,360,300,60);
        add(b4);
        
        b5.setBounds(40,470,300,60);
        add(b5);
        
        b6.setBounds(440,470,300,60);
        add(b6);
        
        b7.setBounds(240,600,300,60);
        add(b7);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,800);
        setLocation(400,20);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
    	
       if(ae.getSource()==b1){
       	  JOptionPane.showMessageDialog(this,b1.getText());
       	  Prel(b1.getText());
       }
       if(ae.getSource()==b2){
    	   Prel(b2.getText());
       }
       if(ae.getSource()==b3){
    	   Prel(b3.getText());
       }
       if(ae.getSource()==b4){
    	   Prel(b4.getText());
       }
       if(ae.getSource()==b5){
    	   Prel(b5.getText());
       }
       if(ae.getSource()==b6){
    	   Prel(b6.getText());
       }
       
       if(ae.getSource()==b7){
    	   System.exit(0);
           
       }
 
       
       
       
            
    }
void Prel (String cifraPrel){
	 LocalDate datam= LocalDate.now();;
	 LocalTime oram= LocalTime.now();
						  
     ContoCorrente conto = service.Dao.selectConto(VarPub.numConto,VarPub.pwd);
   
     Movimenti mov= new Movimenti("Prelievo",( new BigDecimal(cifraPrel)),datam,oram,conto);
   			      
     conto.setAmount(conto.getAmount().subtract(( new BigDecimal(cifraPrel))));
      
      if( service.Dao.InsDep(mov, conto)== true)
	   {JOptionPane.showMessageDialog(this,"Transazione a buon fine");}
      else{JOptionPane.showMessageDialog(this,"Prelievo non eseguito");}
     
		
}
    
  /*
   *   public static void main(String[] args){
        new FastCash().setVisible(true);
    }
   */
}
