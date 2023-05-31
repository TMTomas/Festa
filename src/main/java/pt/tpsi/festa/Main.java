package pt.tpsi.festa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pt.tpsi.festa.contactos.model.ConvidadosList;
import pt.brunojesus.contactslib.model.Contact;
import pt.brunojesus.report.guestlist.model.Guest;
import pt.tpsi.festa.comesebebes.model.ComesEBebes;
import pt.tpsi.festa.contactos.model.ConvidadosList;
import pt.tpsi.festa.espaco.http.RequestMetreologiaAndLocation;
import pt.tpsi.festa.reports.ProductReport;


public class Main {

	public static void main(String[] args) {

		// Instanciar a classe ConvidadosList
		ConvidadosList convidadosList = new ConvidadosList();

		// Listar os contactos disponíveis
		System.out.println("Contactos Disponíveis:");
		for (String contacto : convidadosList.listarContactos()) {
			System.out.println(contacto);
		}

		// Convidar um contacto
		convidadosList.convidar(0, convidadosList.getListaCompleta(), "teste");

		// Listar os convidados
		System.out.println("\nConvidados:");
		for (String convidado : convidadosList.listarConvidados()) {
			System.out.println(convidado);
		}

		// Desconvidar um contacto
		convidadosList.desconvidar(0);

		// Listar os convidados novamente
		System.out.println("\nConvidados:");
		for (String convidado : convidadosList.listarConvidados()) {
			System.out.println(convidado);
		}
	}
}

