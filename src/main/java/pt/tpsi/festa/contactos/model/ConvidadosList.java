package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;

import pt.brunojesus.contactslib.model.Contact;

public class ConvidadosList extends Contact implements ContactInterface {

	// Atributos
	protected ArrayList<Contact> convidados;

	// Construtores

	// CONSTRUTOR DEFAULT
	public ConvidadosList() {
		this.convidados = new ArrayList<>();
	}

	// CONSTRUTOR COM PARAMETROS
	public ConvidadosList(ArrayList<Contact> convidados) {
		this.convidados = convidados;
	}

	// Cópia
	public ConvidadosList(ConvidadosList convidados) {
		this.convidados = new ArrayList<>(convidados.getConvidadosList());
	}

	// Getters And Setters

	public ArrayList<Contact> getConvidadosList() {
		return convidados;
	}

	// Comportamentos

	@Override
	public void listarContactos(ArrayList<Contact> contactos) {
		for (Contact contato : contactos) {
			throw new UnsupportedOperationException("Not implemented yet.");
		}
	}

	@Override
	public void listarConvidados(ArrayList<ConvidadosList> convidados) {
		for (ConvidadosList lista : convidados) {
			listarContactos(lista.getConvidadosList());
		}
	}

	@Override
	public void convidar(int index) {
		if (index >= 0 && index < convidados.size()) {
			Contact contato = convidados.get(index);
		} else {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}

	@Override
	public void desconvidar(int index) {
		if (index >= 0 && index < convidados.size()) {
			Contact contato = convidados.remove(index);
		} else {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}

	@Override
	public boolean verificarConvidado(Contact contato) {
		return convidados.contains(contato);
	}
}
