package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;

public interface ContactInterface {

	// lista os contactos
	public void listarContactos();

	// Lista os contactos
	public ArrayList<String> listarConvidados(ArrayList<ConvidadosList> contactos);

	// Convida a partir do índice do ArrayList
	public void convidar(int index);

	// Desconvida a partir do índice do ArrayList
	public void desconvidar(int index);

}