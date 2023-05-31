package pt.tpsi.festa.reports;

import pt.brunojesus.contactslib.model.Contact;
import pt.brunojesus.report.common.ReportData;
import pt.brunojesus.report.guestlist.model.Guest;
import pt.brunojesus.report.guestlist.model.GuestReportData;
import pt.brunojesus.report.productlist.model.Product;
import pt.tpsi.festa.contactos.model.ConvidadosList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuestReport extends ReportExporter{

	// 1 ATRIBUTOS

	ConvidadosList convidados;
	protected List<Guest> list;
	
	// 2 ACESSORES
	
	public ConvidadosList getConvidados() {
		return convidados;
	}
	
	public List<Guest> getList() {
		return list;
	}
	
	// 3 CONSTRUTORES

	public GuestReport() {
		super();
		convidados = new ConvidadosList();
		list =  new ArrayList<>();
	}
	
    public GuestReport(ConvidadosList convidadosList, List<Guest> list) {
		super();
		this.convidados = convidadosList;
		this.list = list;
	}
    
    public GuestReport(GuestReport guestReport) {
    	this(guestReport.getConvidados(), guestReport.getList());
    }
    
	// 4 COMPORTAMENTOS
    
    public List<Guest> compileShoppingList() {

		for (int i = 0; i < convidados.getListaConvidados().size(); i++) {
			
			list.add(new Guest().setName(convidados.getListaConvidados().get(i).getFirstName() + " " + convidados.getListaConvidados().get(i).getLastName())
					.setContact(convidados.getListaConvidados().get(i).getPhoneNumber())
					.setPresent(true));
				
			}
		
		return list;

	}
	
	public ReportData productReportData(String partyName, String date, String address) {
		 return reportData = new GuestReportData()
               .setEventName(partyName)
               .setEventDate(new Date(date))
               .setAddress(address)
               .setGuests(list);
		
	}
	
	// 5 METODOS COMPLEMENTARES
	
	public boolean equals(GuestReport guestReport) {

		if (guestReport == guestReport)
			return false;
		else
			return list.equals(guestReport.getConvidados());
	}

	public GuestReport clone() {

		return new GuestReport(this);
	}

	@Override
	public String toString() {
		return "GuestReport [convidadosList=" + convidados + "]";
	}
	
}
