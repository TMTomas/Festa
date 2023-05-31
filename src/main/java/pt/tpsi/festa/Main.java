package pt.tpsi.festa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pt.tpsi.festa.contactos.model.ConvidadosList;
import pt.brunojesus.contactslib.model.Contact;
import pt.brunojesus.report.guestlist.model.Guest;
import pt.brunojesus.report.guestlist.model.GuestReportData;
import pt.tpsi.festa.comesebebes.model.ComesEBebes;
import pt.tpsi.festa.contactos.model.ConvidadosList;
import pt.tpsi.festa.espaco.http.RequestMetreologiaAndLocation;
import pt.tpsi.festa.reports.GuestReport;
import pt.tpsi.festa.reports.ProductReport;


public class Main {

	public static void main(String[] args) {
		
		
		RequestMetreologiaAndLocation request = new RequestMetreologiaAndLocation();
		request.pesquisar("Cnema Santarem");
		for (int i = 0; i < request.getLocationListBase().size(); i++) {
			System.out.println(request.getLocationListBase().get(i).getNameLocation());

		}
		
		// ProductReport
		ProductReport productReport = new ProductReport();
		
		// Adiciona alguns produtos à lista de compras
		productReport.getComesEBebes().adicionar("Cerveja", 0, 12, false);
		productReport.getComesEBebes().adicionar("Tremoço", 0, 21, false);
		productReport.getComesEBebes().adicionar("Amendoim", 0, 5, false);
		
		// Cria o Report
		productReport.productReportData("Feira da Agricultura", "06/03/2023 09:00", request.getLocationListBase().get(0).getNameLocation());
		
		// Compila o report
		productReport.compiler();
		
		// Em vez de exportar ele mostra o report sem criar ficheiros		
		productReport.reportViewer();
		
		// GuestReport
		GuestReport guestReport = new GuestReport();

		// Adiciona alguns convidados a partir da lista de contactos
		guestReport.getConvidados().convidar(0, guestReport.getConvidados().getListaConvidados(), "Marreco");
		guestReport.getConvidados().convidar(1, guestReport.getConvidados().getListaConvidados(), "Maneta");
		guestReport.getConvidados().convidar(2, guestReport.getConvidados().getListaConvidados(), "Anão");
		guestReport.compileShoppingList();
		
		// Cria o report
		guestReport.guestReportData("Feira da Agricultura", "06/03/2023 09:00", request.getLocationListBase().get(0).getNameLocation());
		
		// Compila o report
		guestReport.compiler();
		
		// Em vez de exportar ele mostra o report sem criar ficheiros
		guestReport.reportViewer();
		
		guestReport.compiler();
		
	}
}

