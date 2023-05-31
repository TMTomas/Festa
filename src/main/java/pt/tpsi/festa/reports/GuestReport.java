package pt.tpsi.festa.reports;

import pt.brunojesus.contactslib.ContactApi;
import pt.brunojesus.contactslib.model.Contact;
import pt.brunojesus.report.common.ReportData;
import pt.brunojesus.report.guestlist.model.Guest;
import pt.brunojesus.report.guestlist.model.GuestReportData;
import pt.tpsi.festa.contactos.model.ConvidadosList;

import java.util.ArrayList;
import java.util.List;

public class GuestReport {

	// 1 ATRIBUTOS

    final ContactApi contactApi;
    ConvidadosList listaConvidados;
    List<Contact> contactList;
    List<Guest> guestList;
    ReportData reportDataGuest;
	// 2 ACESSORES
	
	// 3 CONSTRUTORES

    public GuestReport() {
        this.listaConvidados = new ConvidadosList();
        this.contactList = new ArrayList<>();
        this.guestList = new ArrayList<>();
        this.contactApi = new ContactApi();
    }

    // 4 COMPORTAMENTOS
    public void createContacts(int quantos){
        contactList = contactApi.generateContacts(4);
    }
	public void addDataGuest(String nome, boolean present){
        for (int i = 0; i < contactList.size(); i++){
            if(contactList.get(i).getFirstName() == nome){
                guestList.add(new Guest().setName(contactList.get(i).getFirstName() + " " + contactList.get(i).getLastName())
                        .setContact(contactList.get(i).getPhoneNumber()).setPresent(present));
            }
        }

    }
    
	// 5 METODOS COMPLEMENTARES
	
	
}
