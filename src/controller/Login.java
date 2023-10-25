/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;



import java.sql.*;
import java.util.regex.Pattern;

public class Login extends JFrame implements ActionListener {
	JLabel l1, l2, l3,l4;
	JTextField tf1;
	JPasswordField pf2;
	JButton b1, b2;

	Login() {

		// Move the text to the center

		setFont(new Font("System", Font.BOLD, 22));
		Font f = getFont();
		FontMetrics fm = getFontMetrics(f);
		int x = fm.stringWidth("BANCOMAT AUTOMATICO");
		int y = fm.stringWidth(" ");
		int z = getWidth() - (x);
		int w = z / y;
		String pad = "";
		pad = String.format("%" + w + "s", pad);
		setTitle(pad + "                BANCOMAT AUTOMATICO               ");

		l1 = new JLabel("     BENVENUTO");
		l1.setFont(new Font("Osward", Font.BOLD, 38));

		l2 = new JLabel("Carta:");
		l2.setFont(new Font("Raleway", Font.BOLD, 28));

		l3 = new JLabel("PIN:");
		l3.setFont(new Font("Raleway", Font.BOLD, 28));
		l4 = new JLabel("");
		l4.setFont(new Font("Osward", Font.BOLD, 18));
		l4.setVisible(false);
		
		tf1 = new JTextField(15);
		pf2 = new JPasswordField(15);

		b1 = new JButton("OK");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);

		b2 = new JButton("CANCELLA");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);

		setLayout(null);

		l1.setBounds(175, 50, 450, 200);
		add(l1);

		l2.setBounds(125, 150, 375, 200);
		add(l2);

		tf1.setBounds(300, 235, 230, 30);
		add(tf1);

		l3.setBounds(125, 225, 375, 200);
		add(l3);
		l4.setBounds(125, 25, 275, 100);
		add(l4);
		tf1.setFont(new Font("Arial", Font.BOLD, 14));

		pf2.setFont(new Font("Arial", Font.BOLD, 14));
		pf2.setBounds(300, 310, 230, 30);
		add(pf2);
		tf1.setText("1234567890");
		pf2.setText("1234");
		b1.setFont(new Font("Arial", Font.BOLD, 14));
		b1.setBounds(300, 400, 100, 30);
		add(b1);

		b2.setFont(new Font("Arial", Font.BOLD, 14));
		b2.setBounds(430, 400, 100, 30);
		add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);

		getContentPane().setBackground(Color.WHITE);

		setSize(750, 650);
		setLocation(400, 100);
		setVisible(true);

	}
     public void label(String msg){
    	    l4.setText(msg); 
			l4.setVisible(true);
			l4.setForeground(Color.RED);
     }
	 
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == b1) {
			// OK
			tf1.setBorder(new LineBorder(Color.gray, 1, true));
		
			if (tf1.getText().matches("[0-9]+")==false && pf2.getText().toString().matches("[0-9]{4}"))
				{
				tf1.setBorder(new LineBorder(Color.red, 1, true));
				 label("Dati inserirti non corretti"); 
				 JOptionPane.showMessageDialog(this,"Dati inserirti non corretti");
				 
				}else
				{				 
			    if(service.Dao.selectConto(tf1.getText(), pf2.getText() )!= null){
			    	VarPub.utente="Antonella";
			    	VarPub.numConto=tf1.getText();
			    	VarPub.pwd=pf2.getText();
			        setVisible(false);
			    	Transactions.open();
			    	
			    	
			    }else{
			    	label("Correntista non presente");
			    	 JOptionPane.showMessageDialog(this,"Correntista non presente");
			    	 tf1.setBorder(new LineBorder(Color.gray, 1, true));
					 l4.setVisible(false);
					 tf1.setText("");
					 pf2.setText("");
			    }
			    
		  	     
		  	     
				}

		} else {
			// CANCEL
			if (ae.getSource() == b2) {
				tf1.setBorder(new LineBorder(Color.gray, 1, true));
				l4.setVisible(false);
				tf1.setText("");
				pf2.setText("");
			}

		}

	}

	public static void main(String[] args) {

		new Login().setVisible(true);
	}

}