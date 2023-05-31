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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import pt.brunojesus.report.common.ReportCompiler;
import pt.brunojesus.report.common.ReportData;
import pt.brunojesus.report.productlist.model.Product;
import pt.brunojesus.report.productlist.model.ProductReportData;
import pt.tpsi.festa.comesebebes.model.Carrinho;
import pt.tpsi.festa.comesebebes.model.ComesEBebes;

public class ProductReport extends ReportExporter{

	// ATRIBUTOS
	
	protected ComesEBebes comesEBebes;
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
	
	/**
	 * Método que "compila" a lista de compras, resume-se em usar a "List<Product> list" e preenchê-la com a ListaDeCompras da classe {@link Carrinho.java} para ser poder usada no productReportData.
	 * 
	 * @return list
	 */
	
	public List<Product> compileShoppingList() {

		for (int i = 0; i < comesEBebes.getCarrinho().getListaDeCompras().size(); i++) {
			list.add(new Product().setId(String.valueOf(i))
				.setName(comesEBebes.getCarrinho().getListaDeCompras().get(i).getNome())
				.setQuantity(comesEBebes.getCarrinho().getListaDeCompras().get(i).getQuantidade())
				.setPrice(comesEBebes.getCarrinho().getListaDeCompras().get(i).getPreco()));
			}
		return list;

	}
	/**
	 * Atribui valores ao reportData
	 *  
	 * @param partyName	Nome da festa
	 * @param date	Data da festa (MM/DD/AAAA HH:mm)
	 * @param address Morada da festa
	 * @return 
	 */
	public ReportData productReportData(String partyName, String date, String address) {
		 reportData = new ProductReportData()
                .setName(partyName)
                .setDate(new Date(date))
                .setAddress(address)
                .setCurrency("€")
                .setProducts(list);
		return reportData;
		
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


	@Override
	public String toString() {
		return "ProductReport [comesEBebes=" + comesEBebes + ", list=" + list + ", report=" + report + ", compiler="
				+ compiler + ", exporterHtml=" + exporterHtml + ", exporterPdf=" + exporterPdf + ", exporterXml="
				+ exporterXml + ", viewer=" + viewer + ", reportData=" + reportData + "]";
	}
	

}
