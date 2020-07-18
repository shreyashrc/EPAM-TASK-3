package com.epam.view;
import java.awt.*;

import com.epam.control.Controller;
import com.epam.model.Addition;
import com.epam.service.CalculatorService;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Calculator extends JFrame implements ActionListener{

	 JFrame f;
	 JTextField l;
	 String s0, s1, s2; 
	 String ip;
	 Controller c ;
	 CalculatorService cs ;
	 public Calculator() {
		 f = new JFrame("calculator"); 
		 s0 = s1 = s2 = ""; 
		 ip = "" ;
		  c = new Controller();
		  cs = new CalculatorService();
	        try { 
	            // set look and feel 
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
	        } 
	        catch (Exception e) { 
	            System.err.println(e.getMessage()); 
	        } 
	        l = new JTextField(16);
	        l.setEditable(false);
	        
	        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1; 
	        
	        // create number buttons 
	        b0 = new JButton("0"); 
	        b1 = new JButton("1"); 
	        b2 = new JButton("2"); 
	        b3 = new JButton("3"); 
	        b4 = new JButton("4"); 
	        b5 = new JButton("5"); 
	        b6 = new JButton("6"); 
	        b7 = new JButton("7"); 
	        b8 = new JButton("8"); 
	        b9 = new JButton("9"); 
	  
	        // equals button 
	        beq1 = new JButton("="); 
	  
	        // create operator buttons 
	        ba = new JButton("+"); 
	        bs = new JButton("-"); 
	        bd = new JButton("/"); 
	        bm = new JButton("*"); 
	        beq = new JButton("C"); 
	  
	        // create . button 
	        be = new JButton("."); 
	  
	        // create a panel 
	        JPanel p = new JPanel(); 
	  
	        // add action listeners 
	        bm.addActionListener(this); 
	        bd.addActionListener(this); 
	        bs.addActionListener(this); 
	        ba.addActionListener(this); 
	        b9.addActionListener(this); 
	        b8.addActionListener(this); 
	        b7.addActionListener(this); 
	        b6.addActionListener(this); 
	        b5.addActionListener(this); 
	        b4.addActionListener(this); 
	        b3.addActionListener(this); 
	        b2.addActionListener(this); 
	        b1.addActionListener(this); 
	        b0.addActionListener(this); 
	        be.addActionListener(this); 
	        beq.addActionListener(this); 
	        beq1.addActionListener(this); 
	  
	        // add elements to panel 
	        p.add(l); 
	        p.add(ba); 
	        p.add(b1); 
	        p.add(b2); 
	        p.add(b3); 
	        p.add(bs); 
	        p.add(b4); 
	        p.add(b5); 
	        p.add(b6); 
	        p.add(bm); 
	        p.add(b7); 
	        p.add(b8); 
	        p.add(b9); 
	        p.add(bd); 
	        p.add(be); 
	        p.add(b0); 
	        p.add(beq); 
	        p.add(beq1); 
	  
	        // set Background of panel 
	        p.setBackground(Color.blue); 
	  
	        // add panel to frame 
	        f.add(p); 
	  
	        f.setSize(200, 220); 
	        f.show(); 
		 
	 }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		double op1 ;
		double op2 ;
		String s = e.getActionCommand(); 
		if(!s.equals("=")) {
			ip = ip + s;
			l.setText(ip);
		}
		else {
			if(ip.contains("C")) {
				ip = "";
				l.setText("");
			}
			else {
				 {
					System.out.println(ip);						
					String [] snew = ip.split("\\+|-|\\*|/") ;
					double o1 =  Double.parseDouble(snew[0]) ;
					double o2 = Double.parseDouble(snew[1]) ;
					
					if(ip.contains("+")) {
						double res = c.addobj.add(o1, o2);
						l.setText(Double.toString(res));
						try {
							cs.calService(ip+"="+res+" ");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
		            if(ip.contains("-")) {
						double res = c.subobj.subtract(o1, o2);
						l.setText(Double.toString(res));
						try {
							cs.calService(ip+"="+res+" ");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
		            if(ip.contains("*")) {
						double res = c.mulobj.multiply(o1, o2);
						l.setText(Double.toString(res));
						try {
							cs.calService(ip+"="+res+" ");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
		            if(ip.contains("/")) {
						double res = c.divobj.divide(o1, o2);
						l.setText(Double.toString(res));
						try {
							cs.calService(ip+"="+res+" ");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
			}
		}
			
		
           
			
				
		}
			
		
		
		  
  
  
		
	}
	public static void main(String[] args) {
		Calculator c =new  Calculator();
	}

	
}
