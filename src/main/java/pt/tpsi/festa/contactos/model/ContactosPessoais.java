package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pt.brunojesus.contactslib.ContactApi;
import pt.brunojesus.contactslib.model.Contact;
import pt.tpsi.festa.contactos.exceptions.DataNascimentoNaoAceiteException;

/**
 * 
 * 
 * @author Francisco Simões
 * 
 */
	public class ContactosPessoais extends Contact implements ContactosInterface{
	
	// 1 - Atributos
	protected List<Contact> contactosPessoais;
	protected Date dataDeNascimento;

	// 2 - Construtores

	// CONTRUTOR DEFAULT
	public ContactosPessoais() {
	}

	// CONTRUTOR COM PARAMETROS
	public ContactosPessoais(Date dataDeNascimento, List<Contact> contactosPessoais) throws DataNascimentoNaoAceiteException {
	if (dataDeNascimento != null) {
		throw new DataNascimentoNaoAceiteException("Data de nascimento not accepted for ContactosPessoais");
	}
	this.dataDeNascimento = dataDeNascimento;
	this.contactosPessoais = new ArrayList<Contact>();
	}

	
	// 3 - Getters And Setters
	public List<Contact> getContactosPessoais() {
		return contactosPessoais;
	}


	public void setContactosPessoais(List<Contact> contactosPessoais) {
		this.contactosPessoais = contactosPessoais;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	// 4 - Comportamentos
	

	// 5 - Métodos Complementares

}
