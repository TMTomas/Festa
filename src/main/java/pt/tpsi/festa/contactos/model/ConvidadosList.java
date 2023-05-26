package pt.tpsi.festa.contactos.model;

import pt.brunojesus.contactslib.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ConvidadosList implements ContactInterface {

	// 1 - ATRIBUTOS

	private List<Contact> lista;
	private ObservacoesContacto observacoes;

	// 2 - CONTRUTORES

	// CONSTRUTOR DEFAULT
	public ConvidadosList() {
		this.lista = new ArrayList<>();
		this.observacoes = new ObservacoesContacto();
	}

	// CONTRUTOR COM PARAMETROS

	public ConvidadosList(List<Contact> lista, ObservacoesContacto observacoes) {
		this.lista = lista;
		this.observacoes = new ObservacoesContacto();
	}

	// CONTRUTOR COPIA

	public ConvidadosList(ConvidadosList convidado) {
		this(convidado.getLista(), convidado.getObservacoes());
	}

	// 3 - GETTERS AND SETTERS

	public List<Contact> getLista() {
		return lista;
	}

	public ObservacoesContacto getObservacoes() {
		return observacoes;
	}

	public void setLista(List<Contact> lista) {
		this.lista = lista;
	}

	public void setObservacoes(ObservacoesContacto observacoes) {
		this.observacoes = observacoes;
	}

	// 4 - COMPROTAMENTOS

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

	@Override
	public List<String> listar(List<Contact> contactos) {
		List<String> listaContactos = new ArrayList<>();
		for (Contact contacto : contactos) {
			String nomeCompleto = contacto.getFirstName() + " " + contacto.getLastName();
			listaContactos.add(nomeCompleto + " - Telemovel: " + contacto.getPhoneNumber());
		}
		return listaContactos;
	}

	public List<String> listar() {
		List<String> listaContactos = new ArrayList<>();
		for (Contact contacto : lista) {
			String nomeCompleto = contacto.getFirstName() + " " + contacto.getLastName();
			String observacao = observacoes.getObservacao(contacto);
			listaContactos
					.add(nomeCompleto + " - Telemovel: " + contacto.getPhoneNumber() + " - Observacao: " + observacao);
		}
		return listaContactos;
	}

	// 5 - MÉTODOS COMPLEMENTARES

	public boolean equals(ConvidadosList convidadosList) {

		if (convidadosList == null) {
			return false;
		} else {
			return lista.equals(lista.get(0)) && observacoes.equals(observacoes.getObservacao(observacoes));

		}
	}

	@Override
	public String toString() {
		return "ConvidadosList [lista=" + lista + ", observacoes=" + observacoes + "]";
	}

}
