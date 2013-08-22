package com.imaginea.colearn.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LMSConfigProperties extends Properties{
	
	public LMSConfigProperties() {
		try {
			InputStream propFileInputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties");			
			this.load(propFileInputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
