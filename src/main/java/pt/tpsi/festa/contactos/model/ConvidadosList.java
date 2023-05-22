package pt.tpsi.festa.contactos;

import java.util.List;

import pt.brunojesus.contactslib.model.*;

public class ConvidadosList extends Contact implements ContactInterface {

	// Atributos
	protected List<Contact> lista;

	// Construtores

	// CONTRUTOR DEFAULT
	public ConvidadosList() {
		this.lista = new List<Contact>();
	}

	// CONTRUTOR COM PARAMETROS
	public ConvidadosList(List<Contact> lista) {
		this.lista = lista;
	}

	// Cópia
	public ConvidadosList(ConvidadosList lista) {
		this.lista = new List<Contact>(lista.getConvidadosList());
	}

	// Getters And Setters

	public List<Contact> getConvidadosList() {
		return lista;
	}

	// Comportamentos

	@Override
	public List<String> listarContactos(List<Contact> contactos) {
		List<String> listaContactos = new List<>();
		for (Contact contato : contactos) {
			String nomeCompleto = contato.getFirstName() + " " + contato.getLastName();
			listaContactos.add(nomeCompleto);
		}
		return listaContactos;
	}

	@Override
	public List<String> listarConvidados(List<ConvidadosList> lista) {
		List<String> listaConvidados = new List<>();
		for (ConvidadosList lista : lista) {
			String nomeCompleto = lista.getFirstName() + " " + lista.getLastName();
			listaConvidados.add(nomeCompleto);
		}
		return listaConvidados;
	}

	@Override
	public void convidar(int index) {
		if (index >= 0 && index < lista.size()) {
			lista.get(index);
		} else {
			throw new IndexOutOfBoundsException("Índice inválido. Não foi possível enviar o convite.");
		}
	}

	@Override
	public void desconvidar(int index) {
		if (index >= 0 && index < lista.size()) {
			lista.remove(index);
		} else {
			throw new IndexOutOfBoundsException("Índice inválido.");
		}
		// Métodos Complementares

	}

}