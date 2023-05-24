package pt.tpsi.festa;

import java.util.List;

import pt.brunojesus.contactslib.ContactApi;
import pt.brunojesus.contactslib.model.Contact;
import pt.tpsi.festa.contactos.model.ConvidadosList;

public class Main {

	public static void main(String[] args) {

		System.out.println("IntStream");
		System.out.println("Has " + Runtime.getRuntime().availableProcessors() + " processors");

		final ContactApi contactApi = new ContactApi();

		long start = System.currentTimeMillis();
		List<Contact> l1 = contactApi.generateContacts(4);
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;

		ConvidadosList listaConvidados = new ConvidadosList();

		listaConvidados.convidar(0, l1, "nao gosta de vodka");
		listaConvidados.convidar(1, l1, "nao bebe alcool");

		System.out.println("LISTA COMPLETA DE CONTACTOS:");
		System.out.println(listaConvidados.listar(l1));
		System.out.println();

		System.out.println("LISTA DOS CONVIDADOS:");
		System.out.println(listaConvidados.listar());
		System.out.println();

		System.out.printf("Generating %s contacts to invite took %sms\n", l1.size(), timeElapsed);
	}
}
