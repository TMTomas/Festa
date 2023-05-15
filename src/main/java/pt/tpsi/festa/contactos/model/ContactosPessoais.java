package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;
import java.util.Date;

import pt.brunojesus.contactslib.ContactApi;
import pt.brunojesus.contactslib.model.Contact;

public class ContactosPessoais extends pt.tpsi.festa.contactos.model.Contact {
	
	// 1 - Atributos
	ArrayList<ContactApi> contactosPessoais;
	protected Date dataDeNascimento;
	
	// 2 - Construtores
	
	// CONTRUTOR DEFAULT
	public ContactosPessoais() {
	}
	
	// CONTRUTOR COM PARAMETROS
	public ContactosPessoais(String firstName, String lastName, Date dataDeNascimento) {
	super();
	this.dataDeNascimento = dataDeNascimento;
	}

	
	// 3 - Getters And Setters

	
	// 4 - Comportamentos
	
	
	// 5 - Métodos Complementares
	
}
