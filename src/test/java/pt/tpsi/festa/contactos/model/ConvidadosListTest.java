package pt.tpsi.festa.contactos.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pt.brunojesus.contactslib.model.Contact;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvidadosListTest {

	private ConvidadosList convidadosList;
	private List<Contact> contacts;

	@BeforeEach
	void setUp() {
		contacts = new ArrayList<>();
		contacts.add(new Contact().setFirstName("Rui").setLastName("Martins").setPhoneNumber("941992313"));
		contacts.add(new Contact().setFirstName("Ana").setLastName("Patricio").setPhoneNumber("966612123"));
		contacts.add(new Contact().setFirstName("Alice").setLastName("Marques").setPhoneNumber("911322443"));

		convidadosList = new ConvidadosList(contacts);
	}

	@Test
	void listarTodosContactos() {
		List<String> listaContactos = convidadosList.listar(contacts);
		assertEquals(3, listaContactos.size());
		assertTrue(listaContactos.contains("Rui Martins - Telemovel: 941992313"));
		assertTrue(listaContactos.contains("Ana Patricio - Telemovel: 966612123"));
		assertTrue(listaContactos.contains("Alice Marques - Telemovel: 911322443"));
	}

	@Test
	void listarConvidados() {
		List<String> listaContactos = convidadosList.listar();
		assertEquals(3, listaContactos.size());
		assertTrue(listaContactos.contains("Rui Martins - Telemovel: 941992313"));
		assertTrue(listaContactos.contains("Ana Patricio - Telemovel: 966612123"));
		assertTrue(listaContactos.contains("Alice Marques - Telemovel: 911322443"));
	}

	@Test
	void convidar() {
		List<Contact> newContacts = new ArrayList<>();
		newContacts.add(new Contact().setFirstName("Hugo").setLastName("Oliveira").setPhoneNumber("933222111"));
		newContacts.add(new Contact().setFirstName("Sara").setLastName("Lima").setPhoneNumber("922223344"));

		convidadosList.convidar(0, newContacts);
		convidadosList.convidar(1, newContacts);

		List<String> listaContactos = convidadosList.listar();
		assertEquals(5, listaContactos.size());
		assertTrue(listaContactos.contains("Rui Martins - Telemovel: 941992313"));
		assertTrue(listaContactos.contains("Ana Patricio - Telemovel: 966612123"));
		assertTrue(listaContactos.contains("Alice Marques - Telemovel: 911322443"));
		assertTrue(listaContactos.contains("Hugo Oliveira - Telemovel: 933222111"));
		assertTrue(listaContactos.contains("Sara Lima - Telemovel: 922223344"));
	}

	@Test
	void convidarIndexInvalido() {
		List<Contact> newContacts = new ArrayList<>();
		newContacts.add(new Contact().setFirstName("Hugo").setLastName("Oliveira").setPhoneNumber("933222111"));
		newContacts.add(new Contact().setFirstName("Sara").setLastName("Lima").setPhoneNumber("922223344"));

		assertThrows(IndexOutOfBoundsException.class, () -> convidadosList.convidar(5, newContacts));
	}

	@Test
	void convidarJaEstaNaLista() {
		List<Contact> newContacts = new ArrayList<>();
		newContacts.add(new Contact().setFirstName("Rui").setLastName("Martins").setPhoneNumber("941992313"));

		assertThrows(IllegalArgumentException.class, () -> convidadosList.convidar(0, newContacts));
	}

	@Test
	void desconvidar() {
		convidadosList.desconvidar(1);

		List<String> listaContactos = convidadosList.listar();
		assertEquals(2, listaContactos.size());
		assertTrue(listaContactos.contains("Rui Martins - Telemovel: 941992313"));
		assertFalse(listaContactos.contains("Ana Patricio - Telemovel: 966612123"));
		assertTrue(listaContactos.contains("Alice Marques - Telemovel: 911322443"));
	}

	@Test
	void desconvidarIndexInvalido() {
		assertThrows(IndexOutOfBoundsException.class, () -> convidadosList.desconvidar(5));
	}

	@Test
	void toStringTest() {
		String expected = "ConvidadosList [lista=" + contacts + "]";
		assertEquals(expected, convidadosList.toString());
	}

}
