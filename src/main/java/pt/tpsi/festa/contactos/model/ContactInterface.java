package pt.tpsi.festa.contactos;

import pt.brunojesus.contactslib.model.Contact;


import java.util.ArrayList;

public interface ContactInterface {

	// lista os contactos
	public List<String> listarContactos(List<Contact> Contactos);

	// Lista os contactos
	public List<String> listarConvidados(List<ConvidadosList> contactos);

	// Convida a partir do índice do ArrayList
	public void convidar(int index);

	// Desconvida a partir do índice do ArrayList
	public void desconvidar(int index);

}