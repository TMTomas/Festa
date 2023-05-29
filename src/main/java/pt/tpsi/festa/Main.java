package pt.tpsi.festa;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import pt.brunojesus.report.common.Report;
import pt.brunojesus.report.common.ReportCompiler;
import pt.brunojesus.report.common.ReportData;
import pt.brunojesus.report.common.ReportViewer;
import pt.brunojesus.report.guestlist.model.Guest;
import pt.brunojesus.report.guestlist.model.GuestReportData;
import pt.brunojesus.report.productlist.model.Product;
import pt.brunojesus.report.productlist.model.ProductReportData;
import pt.tpsi.festa.comesebebes.model.ComesEBebes;

public class Main {

	public static void main(String[] args) {
		ComesEBebes comesEBebes = new ComesEBebes();

		comesEBebes.adicionar("batata frita", 0, 7, false);
		comesEBebes.adicionar("morangos", 0, 5, false);
		comesEBebes.adicionar("cornetto", 0, 5, false);
		comesEBebes.adicionar("pastilha gorila", 0, 5, false);
		comesEBebes.adicionar("nuggets", 0, 3, false);

		List<Product> list = new ArrayList<>();
		for (int i = 0; i < comesEBebes.getCarrinho().getListaDeCompras().size(); i++) {
			list.add(new Product().setId(String.valueOf(i + 1))
					.setName(comesEBebes.getCarrinho().getListaDeCompras().get(i).getNome())
					.setQuantity(comesEBebes.getCarrinho().getListaDeCompras().get(i).getQuantidade())
					.setPrice(comesEBebes.getCarrinho().getListaDeCompras().get(i).getPreco()));
		}

		ReportData productReportData = new ProductReportData()

				.setName("Software Engineering Party").setDate(new Date()).setAddress("ESGTS\nIPSantarem")
				.setCurrency("€").setProducts(list);

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
//	                );
		final ReportCompiler compiler = new ReportCompiler();
		Report productReport = compiler.apply(productReportData);
//		  Report guestReport = compiler.apply(guestReportData);
//		  
		final ReportViewer viewer = new ReportViewer();
		viewer.accept(productReport);
//		  viewer.accept(guestReport);
	}

}
