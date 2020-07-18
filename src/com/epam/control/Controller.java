package com.epam.control;

import com.epam.model.*;

public class Controller {

   public Addition addobj;
   public Subtract subobj;
   public Multiplication mulobj;
   public Divide divobj ;
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
		addobj = new Addition() ;
		subobj = new Subtract() ;
		mulobj =new Multiplication() ;
		divobj = new Divide();
		
	}
	public void add() {
		 
	}
	
	
	
}
