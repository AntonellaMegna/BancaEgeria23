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
import javax.swing.border.LineBorder;

import model.ContoCorrente;
import model.Movimenti;

import service.Dao;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.regex.Pattern;

public class Prelievo extends JFrame implements ActionListener{
    
    JTextField t1;
    JButton b1,b2,b3;
    JLabel l2;
    
    Prelievo(){
        
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("PRELIEVO");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (3*x);
        int w = z/y;
        String pad ="";
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"PAGINA PRELIEVO ");
        
        
       
        
        l2 = new JLabel("QUANTITA");
        l2.setFont(new Font("System", Font.BOLD, 35));
        
       
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        
        
        b1 = new JButton("PRELEVA");
        b1.setFont(new Font("System", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
    
        b2 = new JButton("INDIETRO");
        b2.setFont(new Font("System", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("ESCI");
        b3.setFont(new Font("System", Font.BOLD, 14));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        
        setLayout(null);
        
      
        
        
        
      
        
        l2.setBounds(290,210,800,60);
        add(l2);
        
        t1.setBounds(250,300,300,50);
        add(t1);
        
        b1.setBounds(260,380,140,50);
        add(b1);
        
        b2.setBounds(415,380,125,50);
        add(b2);
        
        b3.setBounds(300,550,200,50);
        add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,800);
        setLocation(400,20);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    	t1.setBorder(new LineBorder(Color.gray, 1, true));
        try{        
           
          
            
            
            
            if(ae.getSource()==b1){
            	if(t1.getText().matches("[0-9]+")){
    				// Inserimento DB
            		
            	 LocalDate datam= LocalDate.now();;
				 LocalTime oram= LocalTime.now();
									  
			     ContoCorrente conto = service.Dao.selectConto(VarPub.numConto,VarPub.pwd);
			   
			     Movimenti mov= new Movimenti("Prelievo",(new BigDecimal(t1.getText())),datam,oram,conto);
			   			      
			     conto.setAmount(conto.getAmount().subtract((new BigDecimal(t1.getText()))));
			      
			      if( service.Dao.InsDep(mov, conto)== true)
				   {JOptionPane.showMessageDialog(this,"Transazione a buon fine");}else{JOptionPane.showMessageDialog(this,"Prelievo non eseguita");}
			     
            		
            		
    			}
    			else{
    				t1.setBorder(new LineBorder(Color.RED, 1, true));
    				
    			}
                
            }else if(ae.getSource()==b2){
                
                new Transactions().setVisible(true);
                setVisible(false);
                
            }else if(ae.getSource()==b3){
                
                System.exit(0);
                
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }
    
  /*
   *   public static void main(String[] args){
        new Withdrawl().setVisible(true);
    }

   */
    
}
