package pt.tpsi.festa.contactos.model;

import pt.brunojesus.contactslib.model.Contact;

import java.util.ArrayList;

public interface ContactInterface {


	// lista os contactos
	public ArrayList<String> listarContactos(ArrayList<Contact> Contactos);

	// Lista os contactos
	public ArrayList<String> listarConvidados(ArrayList<ConvidadosList> contactos);

	// Convida a partir do índice do ArrayList
	public void convidar(int index);

	// Desconvida a partir do índice do ArrayList
	public void desconvidar(int index);

}