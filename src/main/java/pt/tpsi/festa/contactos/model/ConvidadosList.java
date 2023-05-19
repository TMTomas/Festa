package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;
import java.util.List;

import pt.brunojesus.contactslib.model.*;

public class ConvidadosList implements ContactInterface {

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
		this.convidados = new ArrayList<Contact>(convidados.getConvidados());
	}

	// Getters And Setters

	public ArrayList<Contact> getConvidadosList() {
		return convidados;
	}

	// Comportamentos

	@Override
	public void listarContactos(ArrayList<Contact> contactos) {
		for (Contact contato : contactos) {
			return (contato.getFirstName() + " " + contato.getLastName());
		}
	}

	public void listarConvidados(ArrayList<Convidados> convidados) {
		for (Convidados convidado : convidados) {
			return (convidado.getFirstName() + " " + convidado.getLastName());
		}
	}

	@Override
	public void convidar(int index) {
		Contact contato = getConvidados().add(index);
		// Lógica para convidar o contato
		// ...
	}

	@Override
	public void desconvidar(int index) {
		Contact contato = getConvidados().remove(index);
		// Lógica para desconvidar o contato
		// ...
	}

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
