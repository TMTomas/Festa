package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;

import pt.brunojesus.contactslib.model.*;

public interface ContactInterface {

	// lista os contactos
	public ArrayList<String> listarContactos(ArrayList<Contact> Contactos);

	// lista e adiciona a um novo arraylist os contactos convidados
	public ArrayList<String> listarConvidados(ArrayList<ConvidadosList> Convidados);

	// convida apartir indice do arraylist
	public void convidar(int index);

	// desconvida apartir indice do arraylist
	public void desconvidar(int index);

}
