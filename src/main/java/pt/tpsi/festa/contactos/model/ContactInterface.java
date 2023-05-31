package pt.tpsi.festa.contactos.model;

import pt.brunojesus.contactslib.model.Contact;

import java.util.List;

public interface ContactInterface {

	// lista os contactos
	List<String> listarContactos();

	// lista os convidados
	List<String> listarConvidados();

	// Convida a partir do índice do ArrayList
	public void convidar(int index, List<Contact> contacts, String observacao);

	// Desconvida a partir do índice do ArrayList
	public void desconvidar(int index);

}