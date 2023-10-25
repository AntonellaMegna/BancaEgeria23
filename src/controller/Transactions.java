/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transactions extends JFrame implements ActionListener {

	JLabel l1,l2;
	JButton b1, b2, b3, b4, b5, b6, b7;

	Transactions() {
       
		setFont(new Font("System", Font.BOLD, 22));
		Font f = getFont();
		FontMetrics fm = getFontMetrics(f);
		int x = fm.stringWidth("OPERAZIONI");
		int y = fm.stringWidth(" ");
		int z = getWidth() - (3 * x);
		int w = z / y;
		String pad = "";
		// for (int i=0; i!=w; i++) pad +=" ";
		pad = String.format("%" + w + "s", pad);
		setTitle(pad + "OPERAZIONE");

		l1 = new JLabel("Salve " + controller.VarPub.utente );
		l1.setFont(new Font("System", Font.BOLD, 34));

		 
		
		b1 = new JButton("DEPOSITO");
		b1.setFont(new Font("System", Font.BOLD, 18));
		
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);

		b2 = new JButton("PRELIEVO");
		b2.setFont(new Font("System", Font.BOLD, 18));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);

		b3 = new JButton("PRELIEVO FAST");
	    
		b3.setFont(new Font("System", Font.BOLD, 18));
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);

		b4 = new JButton("VISUALIZZA");
		
		b4.setFont(new Font("System", Font.BOLD, 18));
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);

		

		b7 = new JButton("EXIT");
		b7.setFont(new Font("System", Font.BOLD, 18));
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);

		setLayout(null);

		l1.setBounds(100, 100, 700, 40);
		add(l1);
		 
		b1.setBounds(40, 250, 300, 60);
		add(b1);

		b2.setBounds(440, 250, 300, 60);
		add(b2);

		b3.setBounds(40, 360, 300, 60);
		add(b3);

		b4.setBounds(440, 360, 300, 60);
		add(b4);

		b7.setBounds(240, 470, 300, 60);
		add(b7);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		b7.addActionListener(this);

		getContentPane().setBackground(Color.WHITE);

		setSize(850, 800);
		setLocation(400, 20);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == b1) {

			// apriamo Deposito
			   new Deposit().setVisible(true);
			   setVisible(false);

		} else if (ae.getSource() == b2) {

			// apriamo PRelievo
			 new Prelievo().setVisible(true); 
			 setVisible(false);
		} else if (ae.getSource() == b3) {

			// Apriamo fast prelievo
			 new PrelievoVeloce().setVisible(true); 
			 setVisible(false);

		} else if (ae.getSource() == b4) {

			// Apriamo vista movimenti
			
			 new ListaMov().setVisible(true);
			   setVisible(false);
		
		} else if (ae.getSource() == b7) {

			System.exit(0);

		}

	}

	public static void open() {
	
		new Transactions().setVisible(true);
	}
}
