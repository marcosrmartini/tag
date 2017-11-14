package br.com.adin.tag.model.relatorios;

import java.io.Serializable;
import java.util.Date;

import br.com.adin.tag.model.Customer;

public class RelatorioTAG implements Serializable{

	private static final long serialVersionUID = 1L;
	private Customer customer;
	private Date inicio;
	private Date termino;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

}
