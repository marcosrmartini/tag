package br.com.adin.tag.model.relatorios;

import java.io.Serializable;

import br.com.adin.tag.model.Customer;

public class RelatorioTAG implements Serializable{

	private static final long serialVersionUID = 1L;
	private Customer customer;
	private String inicio;
	private String termino;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getTermino() {
		return termino;
	}

	public void setTermino(String termino) {
		this.termino = termino;
	}


	
}
