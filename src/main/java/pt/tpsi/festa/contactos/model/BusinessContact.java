package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;
import java.util.List;

import pt.brunojesus.contactslib.model.Contact;

public class BusinessContact extends Contact {
	
	// 1 - Atributos
	List<Contact> businessContact;
	
	
	// 2 - Construtores
	
	// default
	public BusinessContact() {
		this.businessContact = new ArrayList<>();
	}

	// c/parametros
	public BusinessContact(List<Contact> businessContact) {
		this.businessContact = businessContact;
	}

	// Cópia
	public BusinessContact(BusinessContact businessContact) {
		this.businessContact = new ArrayList<>(businessContact.getBusinessContact());
	}
	// 3 - Getters And Setters

	public List<Contact> getBusinessContact() {
	    if (businessContact == null) {
	        throw new NullPointerException("A lista de contactos empresariais não foi devidamente inicializada.");
	    }
	    return businessContact;
	}
	
	public Contact getBusinessContact(int index) {
	    if (index < 0 || index >= businessContact.size()) {
	        throw new IndexOutOfBoundsException("O índice fornecido está fora dos limites da lista de contactos empresariais.");
	    }
	    return businessContact.get(index);
	}


	public void setBusinessContact(List<Contact> businessContact) {
		this.businessContact = businessContact;

	}
	
	// 4 - Comportamentos

	// 5 - Métodos Complementares
}
