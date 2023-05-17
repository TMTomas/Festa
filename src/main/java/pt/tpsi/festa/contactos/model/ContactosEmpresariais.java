package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;
import java.util.List;

import pt.brunojesus.contactslib.model.Contact;

public class ContactosEmpresariais extends Contact {
	
	// 1 - Atributos
	List<Contact> contactosEmpresariais;
	
	
	// 2 - Construtores
	
	// default
	public ContactosEmpresariais() {
		this.contactosEmpresariais = new ArrayList<>();
	}

	// c/parametros
	public ContactosEmpresariais(List<Contact> contactosEmpresariais) {
		this.contactosEmpresariais = contactosEmpresariais;
	}

	// Cópia
	public ContactosEmpresariais(ContactosEmpresariais contactosEmpresariais) {
		this.contactosEmpresariais = new ArrayList<>(contactosEmpresariais.getContactosEmpresariais());
	}
	// 3 - Getters And Setters

	public List<Contact> getContactosEmpresariais() {
		return contactosEmpresariais;
	}

	public void setContactosEmpresariais(List<Contact> contactosEmpresariais) {
		this.contactosEmpresariais = contactosEmpresariais;

	}
	
	// 4 - Comportamentos

	// 5 - Métodos Complementares
}
