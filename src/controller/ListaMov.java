/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.Movimenti;

import service.Dao;

import java.sql.*;
import java.util.ArrayList;

public class ListaMov extends JFrame implements ActionListener{
 
    JTextField t1=new JTextField(15);
    JButton b1;
   
   
    
    ListaMov(){
    	    	
    	JOptionPane.showMessageDialog(this,Dao.selectMov(VarPub.numConto));
    	ArrayList <Movimenti> mov = new ArrayList <Movimenti>(Dao.selectMov(VarPub.numConto)) ;
 
    	
	    String data[][]=new String[mov.size()][3];;
	    int j=0;
    for (Movimenti mv :mov) {
			data[j][0]= mv.getDatam().toString();
			data[j][1]= mv.getAmount().toString();
			data[j][2]= mv.getTipo();
			j++;
		}
	    String column[]={"Data","Amount","Type"};         
	    JTable jt=new JTable(data,column);    
	    jt.setBounds(30,40,200,300);          
	    JScrollPane sp=new JScrollPane(jt);    
	    add(sp);          
	    setSize(300,400);    
	    setVisible(true); 
     		
	  
    }
	    
    public void actionPerformed(ActionEvent ae){
     
    	
    }
    
  /*
   *   public static void main(String[] args){
        new MiniStatement().setVisible(true);
    }
   */
    
}