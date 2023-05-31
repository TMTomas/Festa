package pt.tpsi.festa.reports;

import pt.brunojesus.report.common.Report;
import pt.brunojesus.report.common.ReportCompiler;
import pt.brunojesus.report.common.ReportData;
import pt.brunojesus.report.common.exporter.file.ReportFileExporter;
import pt.brunojesus.report.common.exporter.file.ReportFileHtmlExporter;
import pt.brunojesus.report.common.exporter.file.ReportFilePdfExporter;
import pt.brunojesus.report.common.exporter.file.ReportFileXmlExporter;

public abstract class ReportExporter {

	// 1 ATRIBUTOS
	protected Report report;
	protected final ReportCompiler compiler;
	protected final ReportFileExporter exporterHtml;
	protected final ReportFileExporter exporterPdf;
	protected final ReportFileExporter exporterXml;
	protected ReportData reportData;

	// 2 ACESSORES

	public Report getReport() {
		return report;
	}

	public ReportCompiler getCompiler() {
		return compiler;
	}

	public ReportFileExporter getExporterHtml() {
		return exporterHtml;
	}

	public ReportFileExporter getExporterPdf() {
		return exporterPdf;
	}

	public ReportFileExporter getExporterXml() {
		return exporterXml;
	}
	
	// 3 CONSTRUTORES
	
	public ReportExporter() {
		this.compiler = new ReportCompiler();
		this.exporterHtml = new ReportFileHtmlExporter();
		this.exporterPdf = new ReportFilePdfExporter();
		this.exporterXml = new ReportFileXmlExporter();

	}

	public ReportExporter(Report report, ReportCompiler compiler, ReportFileExporter exporterHtml,
			ReportFileExporter exporterPdf, ReportFileExporter exporterXml) {
		super();
		this.report = report;
		this.compiler = compiler;
		this.exporterHtml = exporterHtml;
		this.exporterPdf = exporterPdf;
		this.exporterXml = exporterXml;
	}
	
	public ReportExporter(ReportExporter reportExporter) {
		this(reportExporter.getReport(), reportExporter.getCompiler(), reportExporter.getExporterHtml(), reportExporter.getExporterPdf(), reportExporter.getExporterXml());
	}
	
	// 4 COMPORTAMENTOS

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

	// 5 METODOS COMPLEMENTARES
	public boolean equals(ReportExporter reportExporter) {

		if (reportExporter == reportExporter)
			return false;
		else
			return report.equals(reportExporter.getReport());
	}

	
	@Override
	public String toString() {
		return "ReportExporter [report=" + report + ", compiler=" + compiler + ", exporterHtml=" + exporterHtml
				+ ", exporterPdf=" + exporterPdf + ", exporterXml=" + exporterXml + "]";
	}
	
	
	
}
