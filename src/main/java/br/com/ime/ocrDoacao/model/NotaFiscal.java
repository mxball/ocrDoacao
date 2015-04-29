package br.com.ime.ocrDoacao.model;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NotaFiscal {
	@Id 
	@GeneratedValue
	private int id;	
	private String cnpj;
	private String coo;
	private float valor;
	private Date data;
	private int instituicaoId;
	
	public NotaFiscal() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public String getCoo() {
		return coo;
	}
	
	public float getValor() {
		return valor;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCnpj(String cnpj) {
		cnpj = cnpj.replaceAll("[-/.]", "");
		this.cnpj = cnpj;
	}
	
	public void setCoo(String coo) {
		this.coo = coo;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public void setData(String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.data = sdf.parse(data);
		} catch (Exception e) {
			this.data = null;
		}
	}
	
	public boolean validaCnpj() {
		if(cnpj == null || cnpj.length() != 14)
			return true;
	
		try {
			int  sm = 0;
		    int peso = 2;
		    int r, dig13, dig14, num;
		    for (int i = 11; i >= 0; i--) {
			// (48 eh a posição de '0' na tabela ASCII)
		        num = (int)(cnpj.charAt(i) - 48);
		        sm = sm + (num * peso);
		        peso = peso + 1;
		        if (peso == 10)
		           peso = 2;
		    }
		      r = sm % 11;
		      if ((r == 0) || (r == 1))
		         dig13 = '0';
		      else dig13 = (char)((11-r) + 48);
	
		      sm = 0;
		      peso = 2;
		      for (int i = 12; i >= 0; i--) {
		        num = (int)(cnpj.charAt(i)- 48);
		        sm = sm + (num * peso);
		        peso = peso + 1;
		        if (peso == 10)
		           peso = 2;
		      }
	
		      r = sm % 11;
		      if ((r == 0) || (r == 1))
		         dig14 = '0';
		      else dig14 = (char)((11-r) + 48);
	
		      if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) {
		    	  return false;		      
		      }
	    } 
		catch (InputMismatchException erro) {
	        return true;
	    }
		
		return true;
	}
			
	public boolean validaCoo() {
		return coo == null || coo.length() != 6;
	}
	
	public boolean validaValor() {
		return valor <= 0.0;
	}
	
	public boolean validaData() {
		return data == null || data.after(Calendar.getInstance().getTime());
	}

	public int getInstituicaoId() {
		return instituicaoId;
	}

	public void setInstituicaoId(int instituicaoId) {
		this.instituicaoId = instituicaoId;
	}
	
}

