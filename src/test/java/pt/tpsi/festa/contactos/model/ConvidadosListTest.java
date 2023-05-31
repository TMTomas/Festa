/**
 * Classe de testes para a classe ConvidadosList.

 * @author Diogo Carvalho, Francisco Simões, Tomás Monteiro
 * @version 1.0.0
 * @since 31-05-2023
 */
package pt.tpsi.festa.contactos.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pt.brunojesus.contactslib.ContactApi;
import pt.brunojesus.contactslib.model.Contact;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvidadosListTest {

	private ConvidadosList convidadosList;
	private List<Contact> contacts;
	private List<Contact> listaCompleta;
	private ContactApi contactApi;

	/**
	 * Configuração inicial para os testes.
	 */
	@BeforeEach
	void setUp() {
		contacts = new ArrayList<>();
		contacts.add(new Contact().setFirstName("Rui").setLastName("Martins").setPhoneNumber("911111111"));
		contacts.add(new Contact().setFirstName("Ana").setLastName("Patricio").setPhoneNumber("922222222"));
		contacts.add(new Contact().setFirstName("Alice").setLastName("Marques").setPhoneNumber("933333333"));

		convidadosList = new ConvidadosList(contacts, new ObservacoesContacto(), contactApi, listaCompleta);
	}

	/**
	 * Testa o método listar para listar todos os contactos.
	 */
	@Test
	void listarContactos() {
		List<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact().setFirstName("Rui").setLastName("Martins").setPhoneNumber("911111111"));
		contacts.add(new Contact().setFirstName("Ana").setLastName("Patricio").setPhoneNumber("922222222"));
		contacts.add(new Contact().setFirstName("Alice").setLastName("Marques").setPhoneNumber("933333333"));

		ConvidadosList convidadosList = new ConvidadosList(contacts, new ObservacoesContacto(), null, contacts);

		List<String> listaContactos = convidadosList.listarContactos();

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
		List<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact().setFirstName("Rui").setLastName("Martins").setPhoneNumber("911111111"));
		contacts.add(new Contact().setFirstName("Ana").setLastName("Patricio").setPhoneNumber("922222222"));
		contacts.add(new Contact().setFirstName("Alice").setLastName("Marques").setPhoneNumber("933333333"));

		ConvidadosList convidadosList = new ConvidadosList(new ArrayList<>(), new ObservacoesContacto(), null,
				contacts);

		convidadosList.convidar(0, contacts, "alcoolico");

		List<String> listaContactos = convidadosList.listarConvidados();
		assertEquals(1, listaContactos.size());
		assertTrue(listaContactos.contains("Rui Martins - Telemovel: 911111111 - Observacao: alcoolico"));

		assertThrows(IllegalArgumentException.class, () -> convidadosList.convidar(0, contacts, "dancarino"));

		assertThrows(IndexOutOfBoundsException.class, () -> convidadosList.convidar(5, contacts, "observacao"));
	}

	/**
	 * Testa o método convidar para um índice inválido.
	 */
	@Test
	void convidarIndexInvalido() {
		List<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact().setFirstName("Rui").setLastName("Martins").setPhoneNumber("911111111"));
		contacts.add(new Contact().setFirstName("Ana").setLastName("Patricio").setPhoneNumber("922222222"));
		contacts.add(new Contact().setFirstName("Alice").setLastName("Marques").setPhoneNumber("933333333"));

		ConvidadosList convidadosList = new ConvidadosList(new ArrayList<>(), new ObservacoesContacto(), null,
				contacts);

		assertThrows(IndexOutOfBoundsException.class, () -> convidadosList.convidar(5, contacts, "teste1"));
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
