package pt.tpsi.festa.contactos.model;

import pt.brunojesus.contactslib.model.Contact;

import java.util.HashMap;
import java.util.Map;

public class ObservacoesContacto extends Contact {

	// 1 - ATRIBUTOS

	private Map<Contact, String> observacoes;

	// 2 - CONTRUTORES

	// CONSTRUTOR DEFAULT
	public ObservacoesContacto() {
		this.observacoes = new HashMap<>();
	}

	// CONTRUTOR COM PARAMETROS
	public ObservacoesContacto(Map<Contact, String> observacoes) {
		super();
		this.observacoes = observacoes;
	}

	// 3 - GETTERS AND SETTERS

	public String getObservacao(Contact contacto) {
		return observacoes.get(contacto);
	}

	// 4 - COMPROTAMENTOS

	public void adicionarObservacao(Contact contacto, String observacao) {
		observacoes.put(contacto, observacao);
	}

	public void removerObservacao(Contact contacto) {
		observacoes.remove(contacto);
	}

	public boolean possuiObservacao(Contact contacto) {
		return observacoes.containsKey(contacto);
	}
}
