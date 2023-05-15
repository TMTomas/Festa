package pt.tpsi.festa.contactos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContactosPessoais extends Contact {
	
	// 1 - Atributos
	
	protected Date dataNascimento;
	
	// 2 - Construtores
	
	//CONTRUTOR DEFAULT
	public ContactosPessoais() {
	}
	
	// CONTRUTOR COM PARAMETROS
	public ContactosPessoais(String primeiroNome, String ultimoNome, String numero, Date dataNascimento) {
		super(primeiroNome, ultimoNome, numero);
		this.Lista = new ArrayList<String>();
		this.Convidados = new ArrayList<String>();
		this.dataNascimento = dataNascimento;
	}

	
	// 3 - Getters And Setters
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	// 4 - Comportamentos
	
	
	// 5 - Métodos Complementares
	
}
