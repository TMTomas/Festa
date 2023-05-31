/**
 * 
 * @author António Ferraz, Daniel Duarte, Nuno Dias, Tiago Tomás
 * 
 * A classe abstrata ReportExporter representa um exportador de relatórios.
 * Possui métodos para compilar um relatório e exportá-lo para HTML, PDF e XML
 * Também implementa métodos de acesso e verificação de igualdade.
 * 
 */
package pt.tpsi.festa.reports;

import pt.brunojesus.report.common.Report;
import pt.brunojesus.report.common.ReportCompiler;
import pt.brunojesus.report.common.ReportData;
import pt.brunojesus.report.common.ReportViewer;
import pt.brunojesus.report.common.exporter.file.ReportFileExporter;
import pt.brunojesus.report.common.exporter.file.ReportFileHtmlExporter;
import pt.brunojesus.report.common.exporter.file.ReportFilePdfExporter;
import pt.brunojesus.report.common.exporter.file.ReportFileXmlExporter;

public  class ReportExporter {

	// 1 ATRIBUTOS
	protected Report report;
	protected final ReportCompiler compiler;
	protected final ReportFileExporter exporterHtml;
	protected final ReportFileExporter exporterPdf;
	protected final ReportFileExporter exporterXml;
	protected final ReportViewer viewer;
	protected ReportData reportData;
	

	// 2 ACESSORES
	
    /**
     * Obtém o relatório atualmente armazenado.
     *
     * @return o relatório atual
     */
	
    public Report getReport() {
        return report;
    }

    /**
     * Obtém o compilador de relatórios.
     *
     * @return o compilador de relatórios
     */
	
    public ReportCompiler getCompiler() {
        return compiler;
    }

    /**
     * Obtém o exportador de arquivos HTML.
     *
     * @return o exportador de arquivos HTML
     */
	
    public ReportFileExporter getExporterHtml() {
        return exporterHtml;
    }

    /**
     * Obtém o exportador de arquivos PDF.
     *
     * @return o exportador de arquivos PDF
     */
	
    public ReportFileExporter getExporterPdf() {
        return exporterPdf;
    }

    /**
     * Obtém o exportador de arquivos XML.
     *
     * @return o exportador de arquivos XML
     */
	
    public ReportFileExporter getExporterXml() {
        return exporterXml;
    }
    
    /**
     * Obtém o viewer.
     *
     * @return viewer
     */
    
    public ReportViewer getViewer() {
  		return viewer;
  	}
    
    // 3 CONSTRUTORES

	/**
     * Construtor padrão da classe ReportExporter.
     * Inicializa os objetos compiler, exporterHtml, exporterPdf e exporterXml.
     */
	
    public ReportExporter() {
        this.compiler = new ReportCompiler();
        this.exporterHtml = new ReportFileHtmlExporter();
        this.exporterPdf = new ReportFilePdfExporter();
        this.exporterXml = new ReportFileXmlExporter();
        this.viewer = new ReportViewer();
    }

    /**
     * Construtor da classe ReportExporter.
     *
     * @param report         o relatório a ser exportado
     * @param compiler       o compilador de relatórios
     * @param exporterHtml   o exportador de arquivos HTML
     * @param exporterPdf    o exportador de arquivos PDF
     * @param exporterXml    o exportador de arquivos XML
     */
	
    public ReportExporter(Report report, ReportCompiler compiler, ReportFileExporter exporterHtml,
                          ReportFileExporter exporterPdf, ReportFileExporter exporterXml, ReportViewer viewer) {
        this.report = report;
        this.compiler = compiler;
        this.exporterHtml = exporterHtml;
        this.exporterPdf = exporterPdf;
        this.exporterXml = exporterXml;
        this.viewer = viewer;
    }

    /**
     * Construtor de cópia da classe ReportExporter.
     *
     * @param reportExporter o ReportExporter a ser copiado
     */
	
    public ReportExporter(ReportExporter reportExporter) {
        this(reportExporter.getReport(), reportExporter.getCompiler(), reportExporter.getExporterHtml(),
                reportExporter.getExporterPdf(), reportExporter.getExporterXml(), reportExporter.getViewer());
    }

    // 4 COMPORTAMENTOS

    /**
     * Compila um relatório com base nos dados fornecidos.
     *
     * @param reportData os dados do relatório a serem compilados
     */
	
    public void compiler() {
        report = compiler.apply(reportData);
    }

    /**
     * Exporta o relatório atual para um arquivo HTML.
     *
     * @param fileName o nome do arquivo HTML a ser exportado
     */
	
    public void exportHtml(String fileName) {
        exporterHtml.accept(report, fileName);
    }

    /**
     * Exporta o relatório atual para um arquivo PDF.
     *
     * @param fileName o nome do arquivo PDF a ser exportado
     */
	
    public void exportPdf(String fileName) {
        exporterPdf.accept(report, fileName);
    }

    /**
     * Exporta o relatório atual para um arquivo XML.
     *
     * @param fileName o nome do arquivo XML a ser exportado
     */
	
    public void exportXml(String fileName) {
        exporterXml.accept(report, fileName);
    }
    
    /**
     * Mostra o relatório sem criar um ficheiro
     */
    
    public void reportViewer() {
    	viewer.accept(report);
    }
    

    // 5 METODOS COMPLEMENTARES
    
    /**
     * Verifica se o objeto ReportExporter é igual a outro objeto.
     *
     * @param reportExporter o outro objeto a ser comparado
     * @return true se os objetos forem iguais, false caso contrário
     */
    
    public boolean equals(ReportExporter reportExporter) {
        if (reportExporter == reportExporter)
            return false;
        else
            return report.equals(reportExporter.getReport());
    }

    /**
     * Retorna uma representação em string do objeto ReportExporter.
     *
     * @return uma representação em string do objeto ReportExporter
     */
	
    @Override
    public String toString() {
        return "ReportExporter [report=" + report + ", compiler=" + compiler + ", exporterHtml=" + exporterHtml
                + ", exporterPdf=" + exporterPdf + ", exporterXml=" + exporterXml + "]";
    }
}

