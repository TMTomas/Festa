package pt.tpsi.festa.reports;

import pt.brunojesus.report.guestlist.model.GuestReportData;
import pt.tpsi.festa.contactos.model.ConvidadosList;

import java.util.Date;

public class GuestReport extends ReportExporter{

	// 1 ATRIBUTOS

	ConvidadosList convidadosList = new ConvidadosList();
	
	// 2 ACESSORES
	
	// 3 CONSTRUTORES

    // 4 COMPORTAMENTOS
	
	public void productReportData(String partyName, String date, String address) {
		 reportData = new GuestReportData()
               .setEventName(partyName)
               .setEventDate(new Date(date))
               .setAddress(address)
               .setGuests(null);
		
	}
	
    
	// 5 METODOS COMPLEMENTARES
	
	
}
