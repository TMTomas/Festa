package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;
import java.util.List;

import pt.brunojesus.contactslib.model.Contact;

public class Convidados {

	// Atributos
	protected List<Contact> convidados;

	// Construtores

	// CONTRUTOR DEFAULT
	public Convidados() {
		this.convidados = new ArrayList<Contact>();
	}

	// CONTRUTOR COM PARAMETROS
	public Convidados(List<Contact> convidados) {
		this.convidados = convidados;
	}

	// Cópia
	public Convidados(Convidados convidados) {
		this.convidados = new ArrayList<Contact>(convidados.getConvidados());
	}

	// Getters And Setters

	public List<Contact> getConvidados() {
		return convidados;
	}

	// Comportamentos

	// public void convidar(Contact convidado) {
	// convidados.add(convidado);
	// }
	//
	// public void remover(Contact convidado) {
	// convidados.remove(convidado);
	// }
	//
	// public List<Contact> listar() {
	// return convidados;
	// }
	//
	// public boolean verificarConvidado(Contact contato) {
	// return convidados.contains(contato);
	// }

	// Métodos Complementares

}
