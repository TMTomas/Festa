package pt.tpsi.festa.contactos.model;

import java.util.List;

import pt.brunojesus.contactslib.ContactApi;
import pt.brunojesus.contactslib.model.Contact;

public class GerarContactos {
	public static void main(String[] args) {
		ContactApi contactApi = new ContactApi();
		List<Contact> contactos = contactApi.generateContacts(10);

		Lista list = new Lista();
		list.receberContatos(contactos);

	}
}
