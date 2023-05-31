package pt.tpsi.festa.reports;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.function.Consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import pt.brunojesus.report.common.Report;
import pt.brunojesus.report.common.ReportCompiler;
import pt.brunojesus.report.common.ReportData;
import pt.brunojesus.report.common.ReportViewer;
import pt.brunojesus.report.common.exporter.file.ReportFileExporter;

@ExtendWith(MockitoExtension.class)
class ReportExporterTest {
	
	private ReportExporter subject;
	
	@Mock
	protected Report report;
	
	@Mock
	protected ReportCompiler compiler;
	
	@Mock
	protected ReportFileExporter exporterHtml;
	
	@Mock
	protected ReportFileExporter exporterPdf;
	
	@Mock
	protected ReportFileExporter exporterXml;
	
	@Mock
	protected ReportViewer viewer;
	
	@BeforeEach
	public void setUp() {
		subject = new ReportExporter(report, compiler, exporterHtml, exporterPdf, exporterXml, viewer) {};
	}

	@Test
	void testExportTest() {
		
		final ReportData reportData = mock(ReportData.class);
		
		subject.compiler();
		
		Mockito.verify(compiler, Mockito.times(1)).apply(reportData)	;
	}

}