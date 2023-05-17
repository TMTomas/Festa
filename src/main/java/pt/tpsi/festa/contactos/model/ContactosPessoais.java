package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pt.brunojesus.contactslib.model.Contact;
import pt.tpsi.festa.contactos.exceptions.DataNascimentoNaoAceiteException;

	/**
	* This class represents personal contacts and extends the base Contact class.
	* It implements the ContactosInterface for managing contacts.
	* 
	* @author Francisco Simões
	*/
	public class ContactosPessoais extends Contact implements ContactosInterface{
	
	// Atributos
	
	protected List<Contact> contactosPessoais;
	protected Date dataDeNascimento;

	// Construtores

	// construtor default
	public ContactosPessoais() {
	}

	public ContactosPessoais(Date dataDeNascimento, List<Contact> contactosPessoais) throws DataNascimentoNaoAceiteException {
	if (dataDeNascimento != null) {
		throw new DataNascimentoNaoAceiteException("Data de nascimento not accepted for ContactosPessoais");
	}
	this.dataDeNascimento = dataDeNascimento;
	this.contactosPessoais = new ArrayList<Contact>();
	}

	
	// 3 - Getters And Setters
	
	public List<Contact> getContactosPessoais() {
		return contactosPessoais;
	}

	public void setContactosPessoais(List<Contact> contactosPessoais) {
		this.contactosPessoais = contactosPessoais;
	}

	
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	// 4 - Comportamentos
	
	@Override
	public void importar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarContactos(ArrayList<Contact> contactosPessoais) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarConvidados(ArrayList<Contact> contactosPessoais) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void convidar(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desconvidar(int index) {
		// TODO Auto-generated method stub
		
	}

	// 5 - Métodos Complementares

}
