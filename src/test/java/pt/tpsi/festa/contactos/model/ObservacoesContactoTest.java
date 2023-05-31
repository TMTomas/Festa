package pt.tpsi.festa.contactos.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pt.brunojesus.contactslib.model.Contact;

/**
 * Teste unitário para a classe ObservacoesContacto.
 * 
 * 
 * @author Francisco Simões, Tomás Monteiro, Diogo Carvalho
 * @version 1.0.0
 * @since 31-05-2023
 */
class ObservacoesContactoTest {

	private ObservacoesContacto observacoesContacto;
	private Contact contato1;
	private Contact contato2;

	/**
	 * Configuração inicial para os testes.
	 */
	@BeforeEach
	void setUp() {
		observacoesContacto = new ObservacoesContacto();
		contato1 = new Contact();
		contato2 = new Contact();
	}

	/**
	 * O método adicionarObservacao() verifica se uma observação vai ser adicionada
	 * corretamente a uma contacto.
	 */
	@Test
	void adicionarObservacao() {
		String observacao = "Observacao 1";

		observacoesContacto.adicionarObservacao(contato1, observacao);
		observacoesContacto.adicionarObservacao(contato2, observacao);

		assertTrue(observacoesContacto.possuiObservacao(contato1));
		assertEquals(observacao, observacoesContacto.getObservacao(contato1));
		assertTrue(observacoesContacto.possuiObservacao(contato2));
		assertEquals(observacao, observacoesContacto.getObservacao(contato2));
	}

	/**
	 * O método removerObservacao() verifica se a observação vai ser removida de um
	 * contacto.
	 */
	@Test
	void removerObservacao() {
		String observacao = "Observacao 1";
		observacoesContacto.adicionarObservacao(contato1, observacao);
		observacoesContacto.adicionarObservacao(contato2, observacao);

		observacoesContacto.removerObservacao(contato1);
		observacoesContacto.removerObservacao(contato2);

		assertFalse(observacoesContacto.possuiObservacao(contato1));
		assertNull(observacoesContacto.getObservacao(contato1));
		assertFalse(observacoesContacto.possuiObservacao(contato2));
		assertNull(observacoesContacto.getObservacao(contato2));
	}

	/**
	 * Vai verificar se a observação associada a um contacto é retornada
	 * corretamente.
	 */
	@Test
	void getObservacao() {
		String observacao = "Observacao 1";
		observacoesContacto.adicionarObservacao(contato1, observacao);
		observacoesContacto.adicionarObservacao(contato2, observacao);

		assertEquals(observacao, observacoesContacto.getObservacao(contato1));
		assertEquals(observacao, observacoesContacto.getObservacao(contato2));
	}

	/**
	 * Verifica se retorna true quando um contacto já possuir uma observação.
	 */
	@Test
	void possuiObservacao() {
		String observacao = "Observacao 1";
		observacoesContacto.adicionarObservacao(contato1, observacao);
		observacoesContacto.adicionarObservacao(contato2, observacao);

		assertTrue(observacoesContacto.possuiObservacao(contato1));
		assertTrue(observacoesContacto.possuiObservacao(contato2));
	}

	/**
	 * Vai verificar se retorna false quando um contacto não possuir nenhuma
	 * observação
	 */
	@Test
	void naoPossuiObservacao() {
		assertFalse(observacoesContacto.possuiObservacao(contato1));
		assertFalse(observacoesContacto.possuiObservacao(contato2));
	}
}