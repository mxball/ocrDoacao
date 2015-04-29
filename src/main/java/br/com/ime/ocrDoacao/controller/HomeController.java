package br.com.ime.ocrDoacao.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.ime.ocrDoacao.dao.NotaFiscalDao;
import br.com.ime.ocrDoacao.model.NotaFiscal;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class HomeController {
	
	private final NotaFiscalDao dao;
	private final Result result;
	private final Validator validator;
	public HomeController(NotaFiscalDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}
	
	@Get("/")
	public void hometeste() {
		System.out.println("Pagina Inicial");
	}
	
	@Post("/cadastra")
	public void cadastra(NotaFiscal notafiscal) {
		validaNotaFiscal(notafiscal);
		dao.adicionaNotaFiscal(notafiscal);
		result.redirectTo(HomeController.class).hometeste();
	}
	
	@Get("/notaFiscal")
	public void nota() {
		result.forwardTo("/WEB-INF/jsp/img.jsp");
	}
	
	private void validaNotaFiscal(NotaFiscal notafiscal) {
		if (notafiscal.validaCnpj())
			validator.add(new ValidationMessage("CNPJ inválido. Use apenas números", 
					"notafiscal.cnpj"));
		if (notafiscal.validaCoo())
			validator.add(new ValidationMessage("O COO deve conter 6 dígitos.", 
					"notafiscal.coo"));
		if (notafiscal.validaValor())
			validator.add(new ValidationMessage("Valor inválido.", 
					"notafiscal.valor"));
		if (notafiscal.validaData())
			validator.add(new ValidationMessage("Data de emissão inválida.", 
					"notafiscal.data"));
		validator.onErrorUsePageOf(HomeController.class).hometeste();
	}
	
}