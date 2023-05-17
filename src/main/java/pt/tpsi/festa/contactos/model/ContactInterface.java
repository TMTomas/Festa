package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;

public interface ContactInterface {

	// lista os contactos
	public void listarContactos(ArrayList<Contact> Contactos);

	// lista e adiciona a um novo arraylist os contactos convidados
	public void listarConvidados(ArrayList<Convidados> Convidados);

	// convida apartir indice do arraylist
	public void convidar(int index);

	// desconvida apartir indice do arraylist
	public void desconvidar(int index);

}
