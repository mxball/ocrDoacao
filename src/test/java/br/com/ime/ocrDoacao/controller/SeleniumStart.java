package br.com.ime.ocrDoacao.controller;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.thoughtworks.selenium.DefaultSelenium;

public abstract class SeleniumStart {
		public static DefaultSelenium selenium;
		  
	    @BeforeClass
	    public static void setup() {
	        String url = "http://localhost:8080";
	        selenium = new DefaultSelenium("localhost", 4444, "*firefox /usr/bin/firefox", url);
	        selenium.start();
	    }


	    @AfterClass
	    public static void tearDown() {
	        selenium.stop();
	    }
}
