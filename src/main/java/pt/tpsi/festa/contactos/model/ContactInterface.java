package pt.tpsi.festa.contactos.model;

import pt.brunojesus.contactslib.model.Contact;

import java.util.ArrayList;

public interface ContactInterface {

	// Lista os contactos
	void listarContactos(ArrayList<Contact> contactos);

	// Lista e adiciona a um novo ArrayList os contactos convidados
	void listarConvidados(ArrayList<ConvidadosList> convidados);

	// Convida a partir do índice do ArrayList
	void convidar(int index);

	// Desconvida a partir do índice do ArrayList
	void desconvidar(int index);

	// Verifica se o contacto está convidado
	boolean verificarConvidado(Contact contato);
}