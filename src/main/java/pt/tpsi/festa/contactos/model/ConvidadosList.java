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
		this.lista = lista;
	}

	// Cópia
	public ConvidadosList(ConvidadosList lista) {
		this.lista = new ArrayList<Contact>(lista.getConvidadosList());
	}

	// Getters And Setters

	public List<Contact> getConvidadosList() {
		return lista;
	}

	// Comportamentos

	@Override
	public List<String> listar(List<Contact> contactos) {
		List<String> listaContactos = new ArrayList<>();
		for (Contact contato : contactos) {
			String nomeCompleto = contato.getFirstName() + " " + contato.getLastName();
			listaContactos.add(nomeCompleto);
		}
		return listaContactos;
	}

	public void convidar(int index) {
		if (index >= 0 && index < lista.size()) {
			lista.get(index);
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
		// Métodos Complementares

	}

}