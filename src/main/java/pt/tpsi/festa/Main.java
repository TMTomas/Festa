package pt.tpsi.festa;

import java.util.List;

import pt.brunojesus.contactslib.ContactApi;
import pt.brunojesus.contactslib.model.Contact;
import pt.tpsi.festa.contactos.model.ConvidadosList;
import pt.tpsi.festa.reports.ProductReport;


public class Main {

	public static void main(String[] args) {


		System.out.println("IntStream");
		System.out.println("Has " + Runtime.getRuntime().availableProcessors() + " processors");

		final ContactApi contactApi = new ContactApi();

		long start = System.currentTimeMillis();
		List<Contact> l1 = contactApi.generateContacts(4);
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;

		ProductReport productReport = new ProductReport();
		
		productReport.getComesEBebes().adicionar("batata frita", 0, 7, false);
		productReport.getComesEBebes().adicionar("morangos", 0, 5, false);
		productReport.getComesEBebes().adicionar("cornetto", 0, 5, false);
		productReport.getComesEBebes().adicionar("pastilha gorila", 0, 5, false);
		productReport.getComesEBebes().adicionar("nuggets", 0, 3, false);

		productReport.createPDF();

		

//		  ReportData guestReportData = new GuestReportData()
//	                .setEventName("My event name")
//	                .setEventDate(new Date())
//	                .setAddress("ESGTS\nIPSantarem")
//	                .setGuests(
//	                        List.of(
//	                                new Guest().setName("Bruno Jesus").setContact("+351911234567").setPresent(true),
//	                                new Guest().setName("Guest 1").setContact("+351911234568").setPresent(false),
//	                                new Guest().setName("Guest 2").setContact("student@ipsantarem.pt")
//	                        )
//	 
//		  Report guestReport = compiler.apply(guestReportData);
//		  

//		  viewer.accept(guestReport);
	}


		ConvidadosList listaConvidados = new ConvidadosList();

		listaConvidados.convidar(0, l1, "nao gosta de vodka");
		listaConvidados.convidar(1, l1, "nao bebe alcool");

		System.out.println("LISTA COMPLETA DE CONTACTOS:");
		System.out.println(listaConvidados.listarContactos(l1));
		System.out.println();

		System.out.println("LISTA DOS CONVIDADOS:");
		System.out.println(listaConvidados.listarConvidados());
		System.out.println();

		System.out.printf("Generating %s contacts to invite took %sms\n", l1.size(), timeElapsed);
	}
}
