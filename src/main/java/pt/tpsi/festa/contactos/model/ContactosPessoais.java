package pt.tpsi.festa.contactos.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.yaml.snakeyaml.constructor.CustomClassLoaderConstructor;

import pt.brunojesus.contactslib.model.Contact;


/**
 * 
 * 
 * @author Francisco Simões
 * 
 */
public class ContactosPessoais extends Contact{
	
	// 1 - Atributos
	protected List<Contact> contactosPessoais;
	protected Date dataDeNascimento;

	// 2 - Construtores

	// CONTRUTOR DEFAULT
	public ContactosPessoais() {
	}

	// CONTRUTOR COM PARAMETROS

	public ContactosPessoais(Date dataDeNascimento, List<ContactosPessoais> contactosPessoais) {
	this.dataDeNascimento = dataDeNascimento;
	this.contactosPessoais = new ArrayList<Contact>();
	}

	public ContactosPessoais(String firstName, String lastName, Date dataDeNascimento) {
		super();
		this.dataDeNascimento = dataDeNascimento;

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
	
//	public void saveToFile(String filename) throws IOException, FileNotFoundException {}
//	
//	public void loadToFile(String filename) throws IOException, FileNotFoundException {}

	// 4 - Comportamentos


	// 5 - Métodos Complementares

}
