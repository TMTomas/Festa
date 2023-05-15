package pt.tpsi.festa.contactos.model;

import java.util.Date;

import pt.brunojesus.contactslib.ContactApi;
import pt.brunojesus.contactslib.model.Contact;

public class ContactosPessoais extends Contact {
	
	// 1 - Atributos
	
	protected Date dataNascimento;
	final ContactApi contactAPI = new ContactApi();
	// 2 - Construtores
	
	//CONTRUTOR DEFAULT
	public ContactosPessoais() {
	}
	
	// CONTRUTOR COM PARAMETROS
	public ContactosPessoais(String primeiroNome, String ultimoNome, String numero, Date dataNascimento) {
		super();
		this.dataNascimento = dataNascimento;
	}

	
	// 3 - Getters And Setters
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	// 4 - Comportamentos
	
	
	// 5 - Métodos Complementares
	
}
