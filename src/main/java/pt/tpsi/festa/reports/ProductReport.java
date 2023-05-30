package pt.tpsi.festa.reports;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pt.brunojesus.report.common.Report;
import pt.brunojesus.report.common.ReportCompiler;
import pt.brunojesus.report.common.ReportData;
import pt.brunojesus.report.common.ReportViewer;

import pt.brunojesus.report.productlist.model.Product;
import pt.brunojesus.report.productlist.model.ProductReportData;
import pt.tpsi.festa.comesebebes.model.ComesEBebes;

public class ProductReport {

	// ATRIBUTOS

	protected ComesEBebes comesEBebes;
	private List<Product> list; 

	// ACESSORES

	public ComesEBebes getComesEBebes() {
		return comesEBebes;
	}

	public List<Product> getList() {
		return list;
	}

	public void setComesEBebes(ComesEBebes comesEBebes) {
		this.comesEBebes = comesEBebes;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	// CONSTRUTORES

	public ProductReport() {
		comesEBebes = new ComesEBebes();
		list = new ArrayList<>();
	}

	public ProductReport(ComesEBebes comesEBebes, List<Product> list) {
		super();
		this.comesEBebes = comesEBebes;
		this.list = list;
	}
	
	public ProductReport(ProductReport productReport) {
		this(productReport.getComesEBebes(), productReport.getList());
	}
	
	// COMPORTAMENTOS

	public List<Product> finalizarCompra() {

		for (int i = 0; i < comesEBebes.getCarrinho().getListaDeCompras().size(); i++) {
			list.add(new Product().setId(String.valueOf(i))
					.setName(comesEBebes.getCarrinho().getListaDeCompras().get(i).getNome())
					.setQuantity(comesEBebes.getCarrinho().getListaDeCompras().get(i).getQuantidade())
					.setPrice(comesEBebes.getCarrinho().getListaDeCompras().get(i).getPreco()));
		}
		return list;
		
	}
	
	public void createPDF() {
		ReportData productReportData = new ProductReportData().setName("Software Engineering Party").setDate(new Date()).setAddress("ESGTS\nIPSantarem").setCurrency("€").setProducts(finalizarCompra());
		final ReportCompiler compiler = new ReportCompiler();
		Report productReport = compiler.apply(productReportData);
		final ReportViewer viewer = new ReportViewer();
		viewer.accept(productReport);
	}
	
	// METODOS COMPLEMENTARES


	public boolean equals(ProductReport productReport) {
		if (productReport == productReport)
			return false;
		else
		return list.equals(productReport.getList());
	}
	
	public ProductReport clone() {
		return new ProductReport(this);
	}
	
}