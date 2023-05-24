package pt.tpsi.festa.contactos.model;

import pt.brunojesus.contactslib.model.Contact;

import java.util.List;

public interface ContactInterface {

	// lista os contactos
	List<String> listar(List<Contact> contactos);

	// Convida a partir do índice do ArrayList
	public void convidar(int index, List<Contact> contactos);

	// Desconvida a partir do índice do ArrayList
	public void desconvidar(int index);

}