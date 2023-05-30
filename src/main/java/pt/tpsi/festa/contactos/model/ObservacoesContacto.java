package pt.tpsi.festa.contactos.model;

import pt.brunojesus.contactslib.model.Contact;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa uma classe de observações associadas a contactos.
 * 
 * 
 * 
 * @author Diogo Carvalho, Francisco Simões, Tomás Monteiro
 * @version 1.0.0
 * @since 26-05-2023
 */
public class ObservacoesContacto extends Contact {

	// ATRIBUTOS

	private Map<Contact, String> observacoes;

	// CONTRUTORES

	/**
	 * Constrói uma nova instância da classe ObservacoesContacto com um mapa vazio
	 * de observações.
	 */
	public ObservacoesContacto() {
		this.observacoes = new HashMap<>();
	}

	/**
	 * Constrói uma nova instância da classe ObservacoesContacto com o mapa de
	 * observações especificado.
	 *
	 * @param observacoes - o mapa de observações para inicializar a instância
	 */
	public ObservacoesContacto(Map<Contact, String> observacoes) {
		super();
		this.observacoes = observacoes;
	}

	// GETTERS AND SETTERS

	/**
	 * Obtém a observação associada ao contacto fornecido.
	 *
	 * @param contacto - é o contacto para o qual a observação vai ser obtida
	 * @return a observação associada ao contacto, ou retorna null se nenhuma
	 *         observação for encontrada
	 */
	public String getObservacao(Contact contacto) {
		return observacoes.get(contacto);
	}

	// COMPORTAMENTOS

	/**
	 * Adiciona uma observação para o contacto especificado.
	 *
	 * @param contacto   - o contacto para o qual adicionar a observação
	 * @param observacao - a observação a ser adicionada
	 */
	public void adicionarObservacao(Contact contacto, String observacao) {
		observacoes.put(contacto, observacao);
	}

	/**
	 * Remove a observação associada ao contato especificado.
	 *
	 * @param contacto - o contato para o qual remover a observação
	 */
	public void removerObservacao(Contact contacto) {
		observacoes.remove(contacto);
	}

	/**
	 * Verifica se uma observação existe para o contato especificado.
	 *
	 * @param contacto - o contato para verificar se há uma observação
	 * @return true se uma observação existe para o contato, ou retorna false caso
	 *         contrário
	 */
	public boolean possuiObservacao(Contact contacto) {
		return observacoes.containsKey(contacto);
	}
}
