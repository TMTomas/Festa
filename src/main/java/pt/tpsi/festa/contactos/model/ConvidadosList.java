package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;

import pt.brunojesus.contactslib.model.Contact;

public class ConvidadosList extends Contact implements ContactInterface {

	// Atributos
	protected ArrayList<Contact> convidados;

	// Construtores

	// CONTRUTOR DEFAULT
	public ConvidadosList() {
		this.convidados = new ArrayList<Contact>();
	}

	// CONTRUTOR COM PARAMETROS
	public ConvidadosList(ArrayList<Contact> convidados) {
		this.convidados = convidados;
	}

	// Cópia
	public ConvidadosList(ConvidadosList convidados) {
		this.convidados = new ArrayList<Contact>(convidados.getConvidadosList());
	}

	// Getters And Setters

	public ArrayList<Contact> getConvidadosList() {
		return convidados;
	}

	// Comportamentos
	@Override
	public void listarContactos() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<String> listarConvidados(ArrayList<ConvidadosList> convidados) {
		ArrayList<String> listaConvidados = new ArrayList<>();
		for (ConvidadosList convidado : convidados) {
			String nomeCompleto = convidado.getFirstName() + " " + convidado.getLastName();
			listaConvidados.add(nomeCompleto);
		}
		return listaConvidados;
	}

	public void convidar(int index) {
		if (index >= 0 && index < convidados.size()) {
			convidados.get(index);
		} else {
			throw new IndexOutOfBoundsException("Índice inválido. Não foi possível enviar o convite.");
		}
	}

	@Override
	public void desconvidar(int index) {
		if (index >= 0 && index < convidados.size()) {
			convidados.remove(index);
		} else {
			throw new IndexOutOfBoundsException("Índice inválido.");
		}

		
	// Métodos Complementares

	}

}