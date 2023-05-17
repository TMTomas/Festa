package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;

import pt.brunojesus.contactslib.model.Contact;

public interface ContactosInterface {
	
	public void importar(/* API Contactos */);
	
	public void listarContactos(ArrayList<Contact> Contactos);
	
	public void listarConvidados(ArrayList<Contact> Convidados);
	
	public void convidar(int index);
	
	public void desconvidar(int index);
	
}
