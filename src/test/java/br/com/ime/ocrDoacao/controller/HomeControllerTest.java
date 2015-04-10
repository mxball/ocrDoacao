package br.com.ime.ocrDoacao.controller;

import org.junit.Test;

public class HomeControllerTest extends SeleniumStart{

	@Test
	public void testVerificaPaginaInicial() {
		selenium.open("/");
		System.out.println("teste");
		
	}

}
