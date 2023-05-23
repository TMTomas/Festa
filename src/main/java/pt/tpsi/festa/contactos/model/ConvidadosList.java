package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;
import java.util.List;

import pt.brunojesus.contactslib.model.*;

public class ConvidadosList extends Contact implements ContactInterface {

	// Atributos
	protected List<Contact> lista;

	// Construtores

	// CONTRUTOR DEFAULT
	public ConvidadosList() {
		this.lista = new ArrayList<Contact>();
	}

	// CONTRUTOR COM PARAMETROS

	public ConvidadosList(List<Contact> lista) {
		super();
		this.lista = lista;

	}

	// Getters And Setters

	public List<Contact> getConvidadosList() {
		return lista;
	}

	// Comportamentos

	// Listar que lista a lista toda dos contactos gerados com nome e ultimo nome

	@Override
	public List<String> listar(List<Contact> contactos) {
		List<String> listaContactos = new ArrayList<>();
		for (Contact contato : contactos) {
			String nomeCompleto = contato.getFirstName() + " " + contato.getLastName();
			listaContactos.add(nomeCompleto);
		}
		return listaContactos;
	}

	// Listar que lista apenas os nomes guardados que foram convidados
	public List<String> listar() {
		List<String> listaContactos = new ArrayList<>();
		for (Contact contato : lista) {
			String nomeCompleto = contato.getFirstName() + " " + contato.getLastName();
			listaContactos.add(nomeCompleto);
		}
		return listaContactos;
	}

	public void convidar(int index, List<Contact> contacts) {
		if (index >= 0 && index < contacts.size()) {
			Contact contact = contacts.get(index);
			if (!lista.contains(contact)) {
				lista.add(contact);
			} else {
				throw new IllegalArgumentException("O contato já está na lista de convidados.");
			}
		} else {
			throw new IndexOutOfBoundsException("Índice inválido. Não foi possível enviar o convite.");
		}
	}

	public void desconvidar(int index) {
		if (index >= 0 && index < lista.size()) {
			lista.remove(index);
		} else {
			throw new IndexOutOfBoundsException("Índice inválido.");
		}
	}

	// Métodos Complementares

	@Override
	public String toString() {
		return "ConvidadosList [lista=" + lista + "]";
	}

}