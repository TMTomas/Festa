package pt.tpsi.festa;

import pt.tpsi.festa.reports.ProductReport;

public class Main {

	public static void main(String[] args) {
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

}
