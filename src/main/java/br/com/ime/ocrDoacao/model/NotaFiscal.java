package br.com.ime.ocrDoacao.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		this.cnpj = cnpj;
	}
	
	public void setCoo(String coo) {
		this.coo = coo;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public void setData(String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		try {
			this.data = sdf.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

