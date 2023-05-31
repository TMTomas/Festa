package pt.tpsi.festa.reports;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pt.brunojesus.report.common.Report;
import pt.brunojesus.report.common.ReportCompiler;
import pt.brunojesus.report.common.ReportData;
import pt.brunojesus.report.common.ReportViewer;
import pt.brunojesus.report.common.exporter.file.ReportFileExporter;
import pt.brunojesus.report.common.exporter.file.ReportFileHtmlExporter;
import pt.brunojesus.report.productlist.model.Product;
import pt.brunojesus.report.productlist.model.ProductReportData;
import pt.tpsi.festa.comesebebes.model.ComesEBebes;
import pt.tpsi.festa.espaco.http.RequestMetreologiaAndLocation;

public class ProductReport extends ReportExporter{

	// ATRIBUTOS
	
	protected ComesEBebes comesEBebes;
	protected final ReportCompiler compiler;
	protected List<Product> list;
	
	// ACESSORES

	public ComesEBebes getComesEBebes() {
		return comesEBebes;
	}


	public ReportCompiler getCompiler() {
		return compiler;
	}


	public List<Product> getList() {
		return list;
	}
	
	// CONSTRUTORES

	public ProductReport() {
		super();
		comesEBebes = new ComesEBebes();
		list = new ArrayList<>();
		compiler = new ReportCompiler();
	}

	public ProductReport(ComesEBebes comesEBebes, ReportCompiler compiler, List<Product> list) {
		super();
		this.comesEBebes = comesEBebes;
		this.compiler = compiler;
		this.list = list;
	}
	
	public ProductReport(ProductReport productReport) {
		this(productReport.getComesEBebes(), productReport.getCompiler(), productReport.getList());
	}
	// COMPORTAMENTOS
	
	public List<Product> compileCarrinho() {

		for (int i = 0; i < comesEBebes.getCarrinho().getListaDeCompras().size(); i++) {
			list.add(new Product().setId(String.valueOf(i))
				.setName(comesEBebes.getCarrinho().getListaDeCompras().get(i).getNome())
				.setQuantity(comesEBebes.getCarrinho().getListaDeCompras().get(i).getQuantidade())
				.setPrice(comesEBebes.getCarrinho().getListaDeCompras().get(i).getPreco()));
			}
		return list;

	}
	
	public void productReportData(String partyName, String date, String address) {
		 reportData = new ProductReportData()
                .setName(partyName)
                .setDate(new Date(date))
                .setAddress(address)
                .setCurrency("€")
                .setProducts(list);
		
	}
	public void compiler() {
		report = compiler.apply(reportData);
	}

	public void exportHtml(String fileName) {

		exporterHtml.accept(report, fileName);
	}

	public void exportPdf(String fileName) {

		exporterPdf.accept(report, fileName);
	}

	public void exportXml(String fileName) {

		exporterXml.accept(report, fileName);
	}
	
	public void reportViewer() {
    	viewer.accept(report);
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
