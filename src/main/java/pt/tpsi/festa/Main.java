package pt.tpsi.festa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pt.brunojesus.contactslib.ContactApi;
import pt.brunojesus.contactslib.model.Contact;
import pt.brunojesus.report.guestlist.model.Guest;
import pt.tpsi.festa.comesebebes.model.ComesEBebes;
import pt.tpsi.festa.contactos.model.ConvidadosList;
import pt.tpsi.festa.espaco.http.RequestMetreologiaAndLocation;
import pt.tpsi.festa.reports.ProductReport;

public class Main {
    
	public static void main(String[] args) {
	
//		 convidados.convidar(0, l1, "É maneta");
//		    convidados.convidar(1, l1, "Não bebe água");
//		    convidados.convidar(2, l1, "Quem é ele??");
//		    convidados.convidar(3, l1, "Amigo imaginário");
//        System.out.println(convidados.listarConvidados());
        
    	final ContactApi contactApi = new ContactApi();
    	List<Contact> contactList = contactApi.generateContacts(4);

    	System.out.println("LISTA CONTACTOS");
    	
        for (int i = 0; i < contactList.size(); i++) {
			System.out.println(contactList.get(i).getFirstName()); 
			System.out.println(contactList.get(i).getLastName());  
			System.out.println(contactList.get(i).getPhoneNumber());
		}
        
    	List<Guest> guestList = new ArrayList<>();
        
        guestList.add(new Guest().setName(contactList.get(0).getFirstName() + " " + contactList.get(0).getLastName())
				.setContact(contactList.get(0).getPhoneNumber()).setPresent(true));
        
        
        System.out.println("LISTA CONVIDADOS");
        
        for (int i = 0; i < guestList.size(); i++) {
			System.out.println(guestList.get(i).getName());
			System.out.println(guestList.get(i).getContact());

		}
        
//        RequestMetreologiaAndLocation request = new RequestMetreologiaAndLocation();
//		ProductReport productReport = new ProductReport();
//        request.pesquisar("Continente");
//        
//        for (int i = 0; i < request.getLocationListBase().size(); i++) {
//        	 System.out.println(request.getLocationListBase().get(i).getNameLocation());
//		}
//       productReport.getComesEBebes().adicionar("Nuggets", 0, 20, false);
//       productReport.createPDF("Festa", "11/09/2001", request.selecionar(0).getNameLocation());
	}
	
}
