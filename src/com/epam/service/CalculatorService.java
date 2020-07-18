package com.epam.service;

import java.io.FileOutputStream;
import java.io.IOException;

public class CalculatorService {
	public void calService(String s) throws IOException {
		 FileOutputStream outputStream = new FileOutputStream("C:/Users/Siddharth/CalculatorHistory.txt", true);
		    byte[] strToBytes = s.getBytes();
		    outputStream.write(strToBytes);
		  
		    outputStream.close();
		
	}

}
