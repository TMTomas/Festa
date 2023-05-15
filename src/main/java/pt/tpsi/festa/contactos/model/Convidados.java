package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;
import java.util.List;

import pt.brunojesus.contactslib.model.Contact;

public class Convidados extends Contact {

	// 1 - Atributos
	protected List<String> Convidados;

	// 2 - Construtores

	// Vazio
	public Convidados() {
		this.convidados = new ArrayList<>();
	}

	// Default
	public Convidados(List<Contact> convidados) {
		this.convidados = convidados;
	}

	// Cópia
	public Convidados(Convidados contacto) {

		this.Convidados = new ArrayList<String>(contacto.getConvidados());
	}

	// 3 - Getters And Setters

	public List<String> getConvidados() {
		return Convidados;
	}

	// 4 - Comportamentos

	public void convidar(String convidado) {
		Convidados.add(convidado);
	}

	public void remover(String convidado) {
		Convidados.remove(convidado);
	}

	public List<String> listar() {
		return Convidados;
	}

	// 5 - Métodos Complementares

}
