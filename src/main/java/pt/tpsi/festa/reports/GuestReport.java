package pt.tpsi.festa.reports;

import pt.brunojesus.report.common.ReportData;
import pt.brunojesus.report.guestlist.model.GuestReportData;
import pt.tpsi.festa.contactos.model.ConvidadosList;

import java.util.Date;

public class GuestReport extends ReportExporter{

	// 1 ATRIBUTOS

	ConvidadosList convidadosList;
	
	// 2 ACESSORES
	
	public ConvidadosList getConvidadosList() {
		return convidadosList;
	}
	
	// 3 CONSTRUTORES
	
	public GuestReport() {
		super();
		convidadosList = new ConvidadosList();
	}
	
    public GuestReport(ConvidadosList convidadosList) {
		super();
		this.convidadosList = convidadosList;
	}
    
    public GuestReport(GuestReport guestReport) {
		super();
    	guestReport.getConvidadosList();
    }

	// 4 COMPORTAMENTOS
	
	public ReportData productReportData(String partyName, String date, String address) {
		 return reportData = new GuestReportData()
               .setEventName(partyName)
               .setEventDate(new Date(date))
               .setAddress(address)
               .setGuests(null);
		
	}

	
	
	// 5 METODOS COMPLEMENTARES
	
	@Override
	public String toString() {
		return "GuestReport [convidadosList=" + convidadosList + "]";
	}
	
}
