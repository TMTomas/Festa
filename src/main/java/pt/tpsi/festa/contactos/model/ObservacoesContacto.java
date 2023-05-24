package pt.tpsi.festa.contactos.model;

import pt.brunojesus.contactslib.model.Contact;

import java.util.HashMap;
import java.util.Map;

public class ObservacoesContacto {
	private Map<Contact, String> observacoes;

	public ObservacoesContacto() {
		this.observacoes = new HashMap<>();
	}

	public void adicionarObservacao(Contact contacto, String observacao) {
		observacoes.put(contacto, observacao);
	}

	public void removerObservacao(Contact contacto) {
		observacoes.remove(contacto);
	}

	public String getObservacao(Contact contacto) {
		return observacoes.get(contacto);
	}

	public boolean possuiObservacao(Contact contacto) {
		return observacoes.containsKey(contacto);
	}
}
