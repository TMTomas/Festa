package pt.tpsi.festa.contactos;

import java.util.ArrayList;
import java.util.List;

public class Contactos {

	// 1 - Atributos
	private String primeiroNome;
	private String ultimoNome;
	private String numero;
	private List<String> Lista;
	private List<String> Convidados;

	// 2 - Construtores

	// Vazio
	public Contactos() {

	}

	// Default
	public Contactos(String primeiroNome, String ultimoNome, String numero) {
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.numero = numero;
		this.Lista = new ArrayList<String>();
		this.Convidados = new ArrayList<String>();
	}

	// Cópia
	public Contactos(Contactos contacto) {
		this(contacto.getPrimeiroNome(), contacto.getUltimoNome(), contacto.getNumero());
		this.Lista = new ArrayList<String>(contacto.getLista());
		this.Convidados = new ArrayList<String>(contacto.getConvidados());
	}

	// 3 - Getters And Setters
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<String> getLista() {
		return Lista;
	}

	public List<String> getConvidados() {
		return Convidados;
	}

	// 4 - Comportamentos

	public boolean isValido() {
		// EXPRESSÃO REGULAR PARA VALIDAR NÚMERO DE TELEMOVEL EM PORTUGAL
		String padrao = "^\\+351(2[1-9]|[3-9]\\d)\\d{7}$";
		// VERIFICA SE O NUMERO DE TELEMOVEL CORRESPONDE À EXPRESSÃO REGULAR
		return numero.matches(padrao);
	}

	public void convidar(String convidado) {
		Convidados.add(convidado);
	}

	public void remover(String convidado) {
		Convidados.remove(convidado);
	}

	public String listar() {
		for (String convidado : Convidados) {
			return convidado;
		}
		return null;
	}

	// 5 - Métodos Complementares

}
