package br.com.ime.ocrDoacao.model;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		return cnpj == null || cnpj.length() != 14;
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

