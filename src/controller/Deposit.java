/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.swing.*;
import javax.swing.border.LineBorder;

import model.ContoCorrente;
import model.Correntista;
import model.Movimenti;
import service.Dao;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.regex.Pattern;

public class Deposit extends JFrame implements ActionListener {

	JTextField t1, t2;
	JButton b1, b2, b3;
	JLabel l1, l2, l3;

	Deposit() {

		setFont(new Font("System", Font.BOLD, 22));
		Font f = getFont();
		FontMetrics fm = getFontMetrics(f);
		int x = fm.stringWidth("DEPOSITO");
		int y = fm.stringWidth(" ");
		int z = getWidth() - (5 * x);
		int w = z / y;
		String pad = "";
		pad = String.format("%" + w + "s", pad);
		setTitle(pad + "DEPOSITO");

		l1 = new JLabel("Quantità");
		l1.setFont(new Font("System", Font.BOLD, 35));

		t1 = new JTextField();
		t1.setFont(new Font("Raleway", Font.BOLD, 22));

		b1 = new JButton("DEPOSITO");
		b1.setFont(new Font("System", Font.BOLD, 14));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);

		b2 = new JButton("INDIETRO");
		b2.setFont(new Font("System", Font.BOLD, 14));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);

		b3 = new JButton("ESCI");
		b3.setFont(new Font("System", Font.BOLD, 18));
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);

		setLayout(null);

		l1.setBounds(300, 140, 800, 60);
		add(l1);

		t1.setBounds(210, 200, 300, 50);
		add(t1);

		b1.setBounds(220, 280, 125, 50);
		add(b1);

		b2.setBounds(365, 280, 125, 50);
		add(b2);

		b3.setBounds(250, 380, 200, 50);
		add(b3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		getContentPane().setBackground(Color.WHITE);

		setSize(750, 650);
		setLocation(400, 100);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		t1.setBorder(new LineBorder(Color.gray, 1, true));
		if (ae.getSource() == b1) {
			
			if(t1.getText().matches("^[0-9]+.$")){
							
				// insetrimento DB
					  LocalDate datam= LocalDate.now();;
					  LocalTime oram= LocalTime.now();
					 
					  
			      ContoCorrente conto = service.Dao.selectConto(VarPub.numConto,VarPub.pwd);
			   
			      Movimenti mov= new Movimenti("Deposito",(new BigDecimal(t1.getText())),datam,oram,conto);
			   
			    //  BigDecimal tot= (new BigDecimal(t1.getText()+conto.getAmount()));
			  
			      conto.setAmount(conto.getAmount().add(new BigDecimal(t1.getText())));
			      
			    
			    if( service.Dao.InsDep(mov, conto)== true)
				   {JOptionPane.showMessageDialog(this,"ok");}else{JOptionPane.showMessageDialog(this,"Transazione non eseguita");}
			  	
			
				}
					else{
						t1.setBorder(new LineBorder(Color.RED, 1, true));
				}
			
	
		}
		if (ae.getSource() == b2) {
			setVisible(false);
			Transactions.open();
		}
		if (ae.getSource() == b3) {
			System.exit(0);

		}
	}

 
	/*
	 * public static void main(String[] args) {
		new Deposit().setVisible(true);
	}
	 */

}
