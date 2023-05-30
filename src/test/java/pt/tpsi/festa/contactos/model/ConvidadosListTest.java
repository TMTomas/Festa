/**
 * Classe de testes para a classe ConvidadosList.

 * @author Diogo Carvalho, Francisco Simões, Tomás Monteiro
 * @version 1.0.0
 * @since 26-05-2023
 */
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

	/**
	 * Configuração inicial para os testes.
	 */
	@BeforeEach
	void setUp() {
		contacts = new ArrayList<>();
		contacts.add(new Contact().setFirstName("Rui").setLastName("Martins").setPhoneNumber("911111111"));
		contacts.add(new Contact().setFirstName("Ana").setLastName("Patricio").setPhoneNumber("922222222"));
		contacts.add(new Contact().setFirstName("Alice").setLastName("Marques").setPhoneNumber("933333333"));

		convidadosList = new ConvidadosList(contacts, new ObservacoesContacto());
	}

	/**
	 * Testa o método listar para listar todos os contactos.
	 */
	@Test
	void listarTodosContactos() {
		List<String> listaContactos = convidadosList.listarContactos(convidadosList.getLista());
		assertEquals(3, listaContactos.size());
		assertTrue(listaContactos.contains("Rui Martins - Telemovel: 911111111"));
		assertTrue(listaContactos.contains("Ana Patricio - Telemovel: 922222222"));
		assertTrue(listaContactos.contains("Alice Marques - Telemovel: 933333333"));
	}

	/**
	 * Testa o método listar para listar os contactos na lista de convidados.
	 */
	@Test
	void listarConvidados() {
		List<String> listaContactos = convidadosList.listarConvidados();
		assertEquals(3, listaContactos.size());
		assertTrue(listaContactos.contains("Rui Martins - Telemovel: 911111111 - Observacao: null"));
		assertTrue(listaContactos.contains("Ana Patricio - Telemovel: 922222222 - Observacao: null"));
		assertTrue(listaContactos.contains("Alice Marques - Telemovel: 933333333 - Observacao: null"));
	}

	/**
	 * Testa o método convidar para adicionar contactos à lista de convidados.
	 */
	@Test
	void convidar() {
		List<Contact> newContacts = new ArrayList<>();
		newContacts.add(new Contact().setFirstName("Hugo").setLastName("Oliveira").setPhoneNumber("944444444"));
		newContacts.add(new Contact().setFirstName("Sara").setLastName("Lima").setPhoneNumber("955555555"));

		convidadosList.convidar(0, newContacts, "alcoolico");
		convidadosList.convidar(1, newContacts, "dancarino");

		List<String> listaContactos = convidadosList.listarConvidados();
		assertEquals(5, listaContactos.size());
		assertTrue(listaContactos.contains("Rui Martins - Telemovel: 911111111 - Observacao: null"));
		assertTrue(listaContactos.contains("Ana Patricio - Telemovel: 922222222 - Observacao: null"));
		assertTrue(listaContactos.contains("Alice Marques - Telemovel: 933333333 - Observacao: null"));
		assertTrue(listaContactos.contains("Hugo Oliveira - Telemovel: 944444444 - Observacao: alcoolico"));
		assertTrue(listaContactos.contains("Sara Lima - Telemovel: 955555555 - Observacao: dancarino"));
	}

	/**
	 * Testa o método convidar para um índice inválido.
	 */
	@Test
	void convidarIndexInvalido() {
		List<Contact> newContacts = new ArrayList<>();
		newContacts.add(new Contact().setFirstName("Hugo").setLastName("Oliveira"));
		newContacts.add(new Contact().setFirstName("Sara").setLastName("Lima"));

		assertThrows(IndexOutOfBoundsException.class, () -> convidadosList.convidar(5, newContacts, "teste1"));
	}

	/**
	 * Testa o método desconvidar para remover um contacto da lista de convidados.
	 */
	@Test
	void desconvidar() {
		convidadosList.desconvidar(1);

		List<String> listaContactos = convidadosList.listarConvidados();
		assertEquals(2, listaContactos.size());
		assertTrue(listaContactos.contains("Rui Martins - Telemovel: 911111111 - Observacao: null"));
		assertFalse(listaContactos.contains("Ana Patricio - Telemovel: 922222222 - Observacao: null"));
		assertTrue(listaContactos.contains("Alice Marques - Telemovel: 933333333 - Observacao: null"));
	}

	/**
	 * Testa o método desconvidar para um índice inválido.
	 */
	@Test
	void desconvidarIndexInvalido() {
		assertThrows(IndexOutOfBoundsException.class, () -> convidadosList.desconvidar(5));
	}

	/**
	 * Testa o método toString para obter a representação em forma de string da
	 * lista de convidados.
	 */
	@Test
	void toStringTest() {
		String expected = "ConvidadosList [lista=" + contacts + ", observacoes=" + convidadosList.getObservacoes()
				+ "]";
		assertEquals(expected, convidadosList.toString());
	}
}
