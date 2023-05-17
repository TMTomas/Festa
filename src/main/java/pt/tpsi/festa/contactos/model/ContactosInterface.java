package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;

import pt.brunojesus.contactslib.model.Contact;

public interface ContactosInterface {
	
	public void listarContactos(ArrayList<Contactos> Contactos);
		// lista os contactos
	
	public void listarConvidados(ArrayList<Convidados> Convidados);
		// lista e adiciona a um novo arraylist os contactos convidados
	
	public void convidar(int index);
		// convida apartir indice do arraylist
	
	public void desconvidar(int index);
		// desconvida apartir indice do arraylist

	
}
