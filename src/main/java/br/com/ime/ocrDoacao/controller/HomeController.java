package br.com.ime.ocrDoacao.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

@Resource
public class HomeController {
	
	@Get("/")
	public void home() {
		System.out.println("Pagina Inicial");
	}

}