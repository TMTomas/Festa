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
		contacts.add(new Contact().setFirstName("Rui").setLastName("Martins").setPhoneNumber("911111111"));
		contacts.add(new Contact().setFirstName("Ana").setLastName("Patricio").setPhoneNumber("922222222"));
		contacts.add(new Contact().setFirstName("Alice").setLastName("Marques").setPhoneNumber("933333333"));

		convidadosList = new ConvidadosList(contacts);
	}

	@Test
	void listarTodosContactos() {
		List<String> listaContactos = convidadosList.listar(contacts);
		assertEquals(3, listaContactos.size());
		assertTrue(listaContactos.contains("Rui Martins - Telemovel: 911111111"));
		assertTrue(listaContactos.contains("Ana Patricio - Telemovel: 922222222"));
		assertTrue(listaContactos.contains("Alice Marques - Telemovel: 933333333"));
	}

	@Test
	void listarConvidados() {
		List<String> listaContactos = convidadosList.listar();
		assertEquals(3, listaContactos.size());
		assertTrue(listaContactos.contains("Rui Martins - Telemovel: 911111111 - Observação: null"));
		assertTrue(listaContactos.contains("Ana Patricio - Telemovel: 922222222 - Observação: null"));
		assertTrue(listaContactos.contains("Alice Marques - Telemovel: 933333333 - Observação: null"));
	}

	@Test
	void convidar() {
		List<Contact> newContacts = new ArrayList<>();
		newContacts.add(new Contact().setFirstName("Hugo").setLastName("Oliveira").setPhoneNumber("944444444"));
		newContacts.add(new Contact().setFirstName("Sara").setLastName("Lima").setPhoneNumber("955555555"));

		convidadosList.convidar(0, newContacts, "alcoolico");
		convidadosList.convidar(1, newContacts, "dancarino");

		List<String> listaContactos = convidadosList.listar();
		assertEquals(5, listaContactos.size());
		assertTrue(listaContactos.contains("Rui Martins - Telemovel: 911111111 - Observação: null"));
		assertTrue(listaContactos.contains("Ana Patricio - Telemovel: 922222222 - Observação: null"));
		assertTrue(listaContactos.contains("Alice Marques - Telemovel: 933333333 - Observação: null"));
		assertTrue(listaContactos.contains("Hugo Oliveira - Telemovel: 944444444 - Observação: alcoolico"));
		assertTrue(listaContactos.contains("Sara Lima - Telemovel: 955555555 - Observação: dancarino"));
	}

	@Test
	void convidarIndexInvalido() {
		List<Contact> newContacts = new ArrayList<>();
		newContacts.add(new Contact().setFirstName("Hugo").setLastName("Oliveira"));
		newContacts.add(new Contact().setFirstName("Sara").setLastName("Lima"));

		assertThrows(IndexOutOfBoundsException.class, () -> convidadosList.convidar(5, newContacts, "teste1"));
	}

	@Test
	void desconvidar() {
		convidadosList.desconvidar(1);

		List<String> listaContactos = convidadosList.listar();
		assertEquals(2, listaContactos.size());
		assertTrue(listaContactos.contains("Rui Martins - Telemovel: 911111111 - Observação: null"));
		assertFalse(listaContactos.contains("Ana Patricio - Telemovel: 922222222 - Observação: null"));
		assertTrue(listaContactos.contains("Alice Marques - Telemovel: 933333333 - Observação: null"));
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
