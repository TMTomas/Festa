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
		contacts.add(new Contact().setFirstName("John").setLastName("Doe"));
		contacts.add(new Contact().setFirstName("Jane").setLastName("Smith"));
		contacts.add(new Contact().setFirstName("Alice").setLastName("Johnson"));

		convidadosList = new ConvidadosList(contacts);
	}

	@Test
	void listarTodosContactos() {
		List<String> listaContactos = convidadosList.listar(contacts);
		assertEquals(3, listaContactos.size());
		assertTrue(listaContactos.contains("John Doe"));
		assertTrue(listaContactos.contains("Jane Smith"));
		assertTrue(listaContactos.contains("Alice Johnson"));
	}

	@Test
	void listarConvidados() {
		List<String> listaContactos = convidadosList.listar();
		assertEquals(3, listaContactos.size());
		assertTrue(listaContactos.contains("John Doe"));
		assertTrue(listaContactos.contains("Jane Smith"));
		assertTrue(listaContactos.contains("Alice Johnson"));
	}

	@Test
	void convidar() {
		List<Contact> newContacts = new ArrayList<>();
		newContacts.add(new Contact().setFirstName("Bob").setLastName("Brown"));
		newContacts.add(new Contact().setFirstName("Sarah").setLastName("Davis"));

		convidadosList.convidar(0, newContacts);
		convidadosList.convidar(1, newContacts);

		List<String> listaContactos = convidadosList.listar();
		assertEquals(5, listaContactos.size());
		assertTrue(listaContactos.contains("John Doe"));
		assertTrue(listaContactos.contains("Jane Smith"));
		assertTrue(listaContactos.contains("Alice Johnson"));
		assertTrue(listaContactos.contains("Bob Brown"));
		assertTrue(listaContactos.contains("Sarah Davis"));
	}

	@Test
	void convidarIndexInvalido() {
		List<Contact> newContacts = new ArrayList<>();
		newContacts.add(new Contact().setFirstName("Bob").setLastName("Brown"));
		newContacts.add(new Contact().setFirstName("Sarah").setLastName("Davis"));

		assertThrows(IndexOutOfBoundsException.class, () -> convidadosList.convidar(5, newContacts));
	}

	@Test
	void convidarJaEstaNaLista() {
		List<Contact> newContacts = new ArrayList<>();
		newContacts.add(new Contact().setFirstName("John").setLastName("Doe"));

		assertThrows(IllegalArgumentException.class, () -> convidadosList.convidar(0, newContacts));
	}

	@Test
	void desconvidar() {
		convidadosList.desconvidar(1);

		List<String> listaContactos = convidadosList.listar();
		assertEquals(2, listaContactos.size());
		assertTrue(listaContactos.contains("John Doe"));
		assertFalse(listaContactos.contains("Jane Smith"));
		assertTrue(listaContactos.contains("Alice Johnson"));
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
