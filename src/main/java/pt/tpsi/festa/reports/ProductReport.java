/**
 * A classe ProductReport representa o relatório de produtos para a festa.
 * O relatório contém informações sobre os produtos, como nome, quantidade e preço.
 * Pode ser exportado para um arquivo PDF.
 */

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
import pt.tpsi.festa.espaco.http.RequestMetreologiaAndLocation;

public class ProductReport {

    // ATRIBUTOS

    /**
     * Representa a instância da classe ComesEBebes.
     */
	
    protected ComesEBebes comesEBebes;

    /**
     * Representa uma lista de produtos.
     */
	
    private List<Product> list;

    // ACESSORES

    /**
     * Obtém a instância da classe ComesEBebes.
     *
     * @return instância da classe ComesEBebes
     */
	
    public ComesEBebes getComesEBebes() {
        return comesEBebes;
    }

    /**
     * Obtém a lista de produtos.
     *
     * @return lista de produtos
     */
	
    public List<Product> getList() {
        return list;
    }

    /**
     * Define a instância da classe ComesEBebes.
     *
     * @param comesEBebes instância da classe ComesEBebes
     */
	
    public void setComesEBebes(ComesEBebes comesEBebes) {
        this.comesEBebes = comesEBebes;
    }

    /**
     * Define a lista de produtos.
     *
     * @param list lista de produtos
     */
	
    public void setList(List<Product> list) {
        this.list = list;
    }

    // CONSTRUTORES

    /**
     * Construtor padrão da classe ProductReport.
     * Cria uma instância de ComesEBebes e uma lista vazia de produtos.
     */
	
    public ProductReport() {
        comesEBebes = new ComesEBebes();
        list = new ArrayList<>();
    }

    /**
     * Construtor da classe ProductReport.
     *
     * @param comesEBebes instância da classe ComesEBebes
     * @param list        lista de produtos
     */
	
    public ProductReport(ComesEBebes comesEBebes, List<Product> list) {
        this.comesEBebes = new ComesEBebes();
        this.list = new ArrayList<>();
    }

    /**
     * Construtor de cópia da classe ProductReport.
     *
     * @param productReport instância da classe ProductReport
     */
	
    public ProductReport(ProductReport productReport) {
        this(productReport.getComesEBebes(), productReport.getList());
    }

    // COMPORTAMENTOS

    /**
     * Compila o carrinho de compras da festa.
     *
     * @return lista de produtos compilada
     */
	
    public List<Product> compilarCarrinho() {
        // Implementação do método
        for (int i = 0; i < comesEBebes.getCarrinho().getListaDeCompras().size(); i++) {
            list.add(new Product().setId(String.valueOf(i))
                    .setName(comesEBebes.getCarrinho().getListaDeCompras().get(i).getNome())
                    .setQuantity(comesEBebes.getCarrinho().getListaDeCompras().get(i).getQuantidade())
                    .setPrice(comesEBebes.getCarrinho().getListaDeCompras().get(i).getPreco()));
        }
        return list;
    }
    
    /**
     * Cria um arquivo PDF contendo o relatório dos produtos da festa.
     *
     * @param nomeFesta nome da festa
     * @param address   endereço da festa
     * @param date      data da festa
     */
	
    public void createPDF(String nomeFesta, String address, String date) {
        // Implementação do método
        ReportData productReportData = new ProductReportData().setName(nomeFesta)
                .setDate(new Date(date))
                .setAddress("ESGTS\nIPSantarem")
                .setCurrency("€")
                .setProducts(compilarCarrinho());
        final ReportCompiler compiler = new ReportCompiler();
        Report productReport = compiler.apply(productReportData);
        final ReportViewer viewer = new ReportViewer();
        viewer.accept(productReport);
    }
    
    /**
     * Verifica se o objeto ProductReport é igual a outro objeto.
     *
     * @param productReport outro objeto a ser comparado
     * @return true se os objetos forem iguais, false caso contrário
     */
	
    public boolean equals(ProductReport productReport) {
        // Implementação do método
        if (productReport == productReport)
            return false;
        else
            return list.equals(productReport.getList());
    }
    
    /**
     * Cria uma cópia do objeto ProductReport.
     *
     * @return cópia do objeto ProductReport
     */
	
    public ProductReport clone() {
        // Implementação do método
        return new ProductReport(this);
    }
}
