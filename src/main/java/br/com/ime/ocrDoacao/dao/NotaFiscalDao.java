package br.com.ime.ocrDoacao.dao;

import javax.persistence.EntityManager;
import br.com.caelum.vraptor.ioc.Component;
import br.com.ime.ocrDoacao.model.NotaFiscal;

@Component
public class NotaFiscalDao {

 	private EntityManager em;
 	
	public NotaFiscalDao(EntityManager em) {
		this.em = em;
	}
		
	public void adicionaNotaFiscal(NotaFiscal nf) {
		em.persist(nf);
	}
	
}
