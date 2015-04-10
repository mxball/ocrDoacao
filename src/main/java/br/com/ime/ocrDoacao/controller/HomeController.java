package br.com.ime.ocrDoacao.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.ime.ocrDoacao.dao.NotaFiscalDao;
import br.com.ime.ocrDoacao.model.NotaFiscal;
import br.com.caelum.vraptor.Result;

@Resource
public class HomeController {
	
	private NotaFiscalDao dao;
	private Result result;
	
	public HomeController(NotaFiscalDao dao, Result result) {
		this.dao = dao;
		this.result = result;
	}
	
	@Get("/")
	public void home() {
		System.out.println("Pagina Inicial");
	}
	
	@Post("/cadastra")
	public void cadastra(NotaFiscal notafiscal) {
		System.out.println(notafiscal.toString());
		dao.adicionaNotaFiscal(notafiscal);
		result.redirectTo(HomeController.class).home();
	}
	

}