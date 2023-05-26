package pt.tpsi.festa.contactos.model;

import pt.brunojesus.contactslib.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma lista de convidados, implementa a interface ContactInterface.
 * Permite convidar, desconvidar e listar contactos, além de fornecer uma lista
 * de observações associadas aos contactos.
 *
 * @author Diogo Carvalho, Francisco Simões, Tomás Monteiro
 * @version 1.0.0
 * @since 26-05-2023
 */
public class ConvidadosList implements ContactInterface {

	// ATRIBUTOS

	private List<Contact> lista;
	private ObservacoesContacto observacoes;

	// CONTRUTORES

	/**
	 * Constrói uma nova instância de ConvidadosList com uma lista vazia e
	 * observações padrão.
	 */
	public ConvidadosList() {
		this.lista = new ArrayList<>();
		this.observacoes = new ObservacoesContacto();
	}

	/**
	 * Constrói uma nova instância de ConvidadosList com a lista de contactos e
	 * observações especificadas.
	 *
	 * @param lista       - a lista de contactos para inicializar a instância
	 * @param observacoes - as observações associadas aos contactos
	 */
	public ConvidadosList(List<Contact> lista, ObservacoesContacto observacoes) {
		this.lista = lista;
		this.observacoes = new ObservacoesContacto();
	}

	/**
	 * Constrói uma nova instância de ConvidadosList a partir de outra instância,
	 * realizando uma cópia profunda dos contactos e das observações.
	 *
	 * @param convidado - a instância de ConvidadosList a ser copiada
	 */
	public ConvidadosList(ConvidadosList convidado) {
		this(convidado.getLista(), convidado.getObservacoes());
	}

	// GETTERS AND SETTERS

	/**
	 * Obtém a lista de contactos.
	 *
	 * @return a lista de contactos
	 */
	public List<Contact> getLista() {
		return lista;
	}

	/**
	 * Obtém as observações associadas aos contactos.
	 *
	 * @return as observações associadas aos contactos
	 */
	public ObservacoesContacto getObservacoes() {
		return observacoes;
	}

	/**
	 * Define a lista de contactos.
	 *
	 * @param lista - a lista de contactos a ser definida
	 */
	public void setLista(List<Contact> lista) {
		this.lista = lista;
	}

	/**
	 * Define as observações associadas aos contactos.
	 *
	 * @param observacoes as observações associadas aos contactos
	 */
	public void setObservacoes(ObservacoesContacto observacoes) {
		this.observacoes = observacoes;
	}

	// COMPORTAMENTOS

	/**
	 * Convida um contacto para a lista de convidados, adiciona-o à lista e associa
	 * uma observação.
	 *
	 * @param index      o índice do contacto na lista de contactos disponíveis
	 * @param contacts   a lista de contactos disponíveis para seleção
	 * @param observacao a observação a ser associada ao contacto convidado
	 * @throws IllegalArgumentException  se o contacto já estiver na lista de
	 *                                   convidados
	 * @throws IndexOutOfBoundsException se o índice for inválido, ou seja, menor
	 *                                   que 0 ou maior ao tamanho da lista de
	 *                                   contactos disponíveis
	 */

	@Override
	public void convidar(int index, List<Contact> contacts, String observacao) {
		if (index >= 0 && index < contacts.size()) {
			Contact contact = contacts.get(index);
			if (!lista.contains(contact)) {
				lista.add(contact);
				observacoes.adicionarObservacao(contact, observacao);
			} else {
				throw new IllegalArgumentException("O contacto já está na lista de convidados.");
			}
		} else {
			throw new IndexOutOfBoundsException("Índice inválido. Não foi possível enviar o convite.");
		}
	}

	/**
	 * Remove um contacto da lista de convidados.
	 *
	 * @param index o índice do contacto na lista de convidados
	 * @throws IndexOutOfBoundsException se o índice for inválido, ou seja, menor
	 *                                   que 0 ou maior ao tamanho da lista de
	 *                                   convidados
	 */

	@Override
	public void desconvidar(int index) {
		if (index >= 0 && index < lista.size()) {
			Contact contact = lista.get(index);
			lista.remove(index);
			observacoes.removerObservacao(contact);
		} else {
			throw new IndexOutOfBoundsException("Índice inválido.");
		}
	}

	/**
	 * Retorna uma lista de strings contendo informações detalhadas sobre os
	 * contactos na lista de convidados. As informações incluem o nome completo,
	 * número de telefone e observação associada a cada contacto.
	 *
	 * @return uma lista de strings com informações detalhadas dos contactos na
	 *         lista de convidados
	 */
	@Override
	public List<String> listarConvidados() {
		List<String> listaContactos = new ArrayList<>();
		for (Contact contacto : lista) {
			String nomeCompleto = contacto.getFirstName() + " " + contacto.getLastName();
			String observacao = observacoes.getObservacao(contacto);
			listaContactos
					.add(nomeCompleto + " - Telemovel: " + contacto.getPhoneNumber() + " - Observacao: " + observacao);
		}
		return listaContactos;
	}

	/**
	 * Retorna uma lista de strings contendo informações básicas sobre os contactos
	 * na lista de convidados com todos os convidados possiveis de convidar. As
	 * informações incluem o nome completo e número de telefone de cada contato.
	 *
	 * @param contactos a lista de contactos a serem listados
	 * @return uma lista de strings com informações básicas dos contactos na lista
	 *         de convidados
	 */

	public List<String> listarContactos(List<Contact> contactos) {
		List<String> listaContactos = new ArrayList<>();
		for (Contact contacto : contactos) {
			String nomeCompleto = contacto.getFirstName() + " " + contacto.getLastName();
			listaContactos.add(nomeCompleto + " - Telemovel: " + contacto.getPhoneNumber());
		}
		return listaContactos;
	}

	// MÉTODOS COMPLEMENTARES

	/**
	 * Compara se o objeto atual é igual a outro objeto.
	 *
	 * @param obj O objeto a ser comparado
	 * @return true se os objetos são iguais, false caso contrário
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		ConvidadosList other = (ConvidadosList) obj;
		return lista.equals(other.lista) && observacoes.equals(other.observacoes);
	}

	/**
	 * Retorna uma representação em forma de string da lista de convidados.
	 *
	 * @return Uma string representando a lista de convidados
	 */

	@Override
	public String toString() {
		return "ConvidadosList [lista=" + lista + ", observacoes=" + observacoes + "]";
	}
}
