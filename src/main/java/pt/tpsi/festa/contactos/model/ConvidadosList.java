package pt.tpsi.festa.contactos.model;

import pt.brunojesus.contactslib.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ConvidadosList {
	private List<Contact> lista;
	private ObservacoesContacto observacoes;

	public ConvidadosList() {
		this.lista = new ArrayList<>();
		this.observacoes = new ObservacoesContacto();
	}

	public ConvidadosList(List<Contact> lista) {
		this.lista = lista;
		this.observacoes = new ObservacoesContacto();
	}

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

	public void desconvidar(int index) {
		if (index >= 0 && index < lista.size()) {
			Contact contact = lista.get(index);
			lista.remove(index);
			observacoes.removerObservacao(contact);
		} else {
			throw new IndexOutOfBoundsException("Índice inválido.");
		}
	}

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
					.add(nomeCompleto + " - Telemovel: " + contacto.getPhoneNumber() + " - Observação: " + observacao);
		}
		return listaContactos;
	}

	@Override
	public String toString() {
		return "ConvidadosList [lista=" + lista + "]";
	}
}
