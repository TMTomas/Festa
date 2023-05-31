/**
 * 
 * @author António Ferraz
 * @author Eduardo Ribeiro
 * @author Nuno Dias
 * @author Tiago Tomás
 * 
 * Menções importantes
 * @author ChatGPT (Mais valia de alguns membros)
 * @author Daniel Duarte (Obrigado por toda a ajuda e disponibilidade)
 * 
 * Esta classe cria um ProductReport, que se pode exportar para Html, Pdf e Xml.
 * É também possível visualizar o Report sem se criar um ficheiro. Para mais informações consultar a superclasse {@link ReportExporter.java}.
 *
 */
package pt.tpsi.festa.reports;

import pt.brunojesus.report.common.ReportData;
import pt.brunojesus.report.guestlist.model.Guest;
import pt.brunojesus.report.guestlist.model.GuestReportData;
import pt.tpsi.festa.contactos.model.ConvidadosList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
	
public class GuestReport extends ReportExporter{

	// ATRIBUTOS

	protected ConvidadosList convidados;
	protected List<Guest> list;
	
	// ACESSORES
	
	public ConvidadosList getConvidados() {
		return convidados;
	}
	
	public List<Guest> getList() {
		return list;
	}
	
	// CONSTRUTORES

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
    
	// COMPORTAMENTOS
    
    /**
     * Método que "compila" a lista de convidados, resume-se a usar a "List<Guest> list" e preenchê-la com a listaDeConvidados da classe {@link convidadosList.java} para poder ser usada no guestReportData.
     * 
     * @return list;
     */
    
    public List<Guest> compileShoppingList() {

		for (int i = 0; i < convidados.getListaConvidados().size(); i++) {
			
			list.add(new Guest().setName(convidados.getListaConvidados().get(i).getFirstName() + " " + convidados.getListaConvidados().get(i).getLastName())
					.setContact(convidados.getListaConvidados().get(i).getPhoneNumber())
					.setPresent(true));
				
			}
		
		return list;

	}
    
    /**
	 * Atribui valores ao reportData
	 *  
	 * @param partyName	Nome da festa
	 * @param date Data da festa (MM/DD/AAAA HH:mm)
	 * @param address Morada da festa
	 * @param list Lista de convidados
	 * @return 
	 */
	
	public ReportData guestReportData(String partyName, String date, String address) {
		 return reportData = new GuestReportData()
               .setEventName(partyName)
               .setEventDate(new Date(date))
               .setAddress(address)
               .setGuests(list);
		
	}
	
	// METODOS COMPLEMENTARES
	
	public boolean equals(GuestReport guestReport) {

		if (guestReport == guestReport)
			return false;
		else
			return list.equals(guestReport.getList());
	}

	public GuestReport clone() {

		return new GuestReport(this);
	}

	@Override
	public String toString() {
		return "GuestReport [convidadosList=" + convidados + "]";
	}
	
}
