package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;
import java.util.List;

import pt.brunojesus.contactslib.model.Contact;

public class Convidados {

	// Atributos
	protected List<Contact> convidados;

	// Construtores

	// Vazio
	public Convidados() {
		this.convidados = new ArrayList<>();
	}

	// Default
	public Convidados(List<Contact> convidados) {
		this.convidados = convidados;
	}

	// Cópia
	public Convidados(Convidados convidados) {
		this.convidados = new ArrayList<>(convidados.getConvidados());
	}

	// Getters And Setters

	public List<Contact> getConvidados() {
		return convidados;
	}

	// Comportamentos

	public void convidar(Contact convidado) {
		convidados.add(convidado);
	}

	public void remover(Contact convidado) {
		convidados.remove(convidado);
	}

	public List<Contact> listar() {
		return convidados;
	}

	// Métodos Complementares

}
