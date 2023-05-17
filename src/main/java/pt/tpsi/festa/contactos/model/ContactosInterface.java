package pt.tpsi.festa.contactos.model;

import java.util.ArrayList;

public interface ContactosInterface {
	
	public static void importar(/* API Contactos */) {
		
	}
	
	public static void listarContactos(ArrayList<API> Contactos) {
		// lista os contactos
	}
	
	public static void listarConvidados(ArrayList<Convidados> Convidados){
		// lista e adiciona a um novo arraylist os contactos convidados
	}
	public static void convidar(int index) {
		// convida apartir indice do arraylist
	}
	
	public static void desconvidar(int index) {
		// desconvida apartir indice do arraylist

	}
	
}
