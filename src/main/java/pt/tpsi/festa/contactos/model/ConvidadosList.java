package pt.tpsi.festa.contactos.model;

import pt.brunojesus.contactslib.model.Contact;
import pt.brunojesus.contactslib.ContactApi;

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

	private List<Contact> listaConvidados = new ArrayList<>();
	private ObservacoesContacto observacoes = new ObservacoesContacto();
	private ContactApi contactApi = new ContactApi();
	private List<Contact> listaCompleta = iniciarListaCompleta();

	// CONTRUTORES

	/**
	 * Constrói uma nova instância de ConvidadosList com uma lista vazia de
	 * convidados e observações padrão.
	 */
	public ConvidadosList() {

	}

	/**
	 * Constrói uma nova instância de ConvidadosList com a lista especificada de
	 * contactos e observações.
	 *
	 * @param listaConvidados - a lista de contactos para inicializar a instância
	 * @param observacoes     - as observações associadas aos contactos
	 * @param contactApi      - a instância de ContactApi
	 * @param listaCompleta   - a lista completa de contactos
	 */
	public ConvidadosList(List<Contact> listaConvidados, ObservacoesContacto observacoes, ContactApi contactApi,
			List<Contact> listaCompleta) {
		super();
		this.listaConvidados = listaConvidados;
		this.observacoes = observacoes;
		this.contactApi = contactApi;
		this.listaCompleta = listaCompleta;
	}

	/**
	 * Constrói uma nova instância de ConvidadosList com base em outra instância,
	 * realizando uma cópia profunda dos contactos e observações.
	 *
	 * @param convidado - a instância de ConvidadosList a ser copiada
	 */
	public ConvidadosList(ConvidadosList convidado) {
		this(convidado.getListaConvidados(), convidado.getObservacoes(), convidado.getContactApi(),
				convidado.getListaCompleta());
	}

	// GETTERS AND SETTERS

	/**
	 * Retorna a lista de contactos na lista de convidados.
	 *
	 * @return a lista de contactos na lista de convidados
	 */
	public List<Contact> getListaConvidados() {
		return listaConvidados;
	}

	/**
	 * Retorna as observações associadas aos contactos na lista de convidados.
	 *
	 * @return as observações associadas aos contactos na lista de convidados
	 */
	public ObservacoesContacto getObservacoes() {
		return observacoes;
	}

	/**
	 * Retorna a ContactApi utilizada pela lista de convidados.
	 *
	 * @return a ContactApi utilizada pela lista de convidados
	 */
	public ContactApi getContactApi() {
		return contactApi;
	}

	/**
	 * Retorna a lista completa de contactos gerados pela API.
	 *
	 * @return a lista completa de contactos gerados pela API
	 */
	public List<Contact> getListaCompleta() {
		return listaCompleta;
	}

	/**
	 * Define a lista de contactos na lista de convidados.
	 *
	 * @param lista a lista de contactos a ser definida
	 */
	public void setLista(List<Contact> listaConvidados) {
		this.listaConvidados = listaConvidados;
	}

	/**
	 * Define as observações associadas aos contactos na lista de convidados.
	 *
	 * @param observacoes as observações a serem definidas
	 */
	public void setObservacoes(ObservacoesContacto observacoes) {
		this.observacoes = observacoes;
	}

	/**
	 * Define a ContactApi a ser utilizada pela lista de convidados.
	 *
	 * @param contactApi a ContactApi a ser definida
	 */
	public void setContactApi(ContactApi contactApi) {
		this.contactApi = contactApi;
	}

	/**
	 * Define a lista completa de contactos gerados pela API.
	 *
	 * @param listaCompleta a lista completa de contactos a ser definida
	 */
	public void setListaCompleta(List<Contact> listaCompleta) {
		this.listaCompleta = listaCompleta;
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
		if (index >= 0 && index < listaCompleta.size()) {
			Contact contact = listaCompleta.get(index);
			if (!listaConvidados.contains(contact)) {
				listaConvidados.add(contact);
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
		if (index >= 0 && index < listaConvidados.size()) {
			Contact contact = listaConvidados.get(index);
			listaConvidados.remove(index);
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
		for (Contact contacto : listaConvidados) {
			String nomeCompleto = contacto.getFirstName() + " " + contacto.getLastName();
			String observacao = observacoes.getObservacao(contacto);
			listaContactos
					.add(nomeCompleto + " - Telemovel: " + contacto.getPhoneNumber() + " - Observacao: " + observacao);
		}
		return listaContactos;
	}

	/**
	 * Retorna uma lista de strings contendo informações básicas sobre os contactos
	 * na listaCompleta de contactos gerados pela API. As informações incluem o nome
	 * completo e número de telefone de cada contacto.
	 *
	 * @return uma lista de strings com informações básicas dos contactos na
	 *         listaCompleta de contactos gerados pela API
	 */
	public List<String> listarContactos() {
		List<String> listaContactos = new ArrayList<>();
		for (Contact contacto : listaCompleta) {
			String nomeCompleto = contacto.getFirstName() + " " + contacto.getLastName();
			listaContactos.add(nomeCompleto + " - Telemovel: " + contacto.getPhoneNumber());
		}
		return listaContactos;
	}

	// MÉTODOS COMPLEMENTARES

	/**
	 * Inicializa a lista completa de contactos criada pela ContactApi. O método
	 * gera um número especificado de contactos e os atribui ao campo listaCompleta.
	 * 
	 * @return
	 */
	public List<Contact> iniciarListaCompleta() {
		WriteandReadJson writeandReadJson = new WriteandReadJson();
		listaCompleta = writeandReadJson.readFiletoList(listaCompleta);
		
		if (listaCompleta == null || listaCompleta.isEmpty()) {
			listaCompleta = contactApi.generateContacts(30);
			writeandReadJson.writeListOnFile(listaCompleta);
		}
		return listaCompleta;
	}

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
		return listaConvidados.equals(other.listaConvidados) && observacoes.equals(other.observacoes);
	}

	/**
	 * Retorna uma representação em forma de string da lista de convidados.
	 *
	 * @return Uma string representando a lista de convidados
	 */

	@Override
	public String toString() {
		return "ConvidadosList [lista=" + listaConvidados + ", observacoes=" + observacoes + "]";
	}
}