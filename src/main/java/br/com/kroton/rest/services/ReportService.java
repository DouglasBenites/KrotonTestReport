package br.com.kroton.rest.services;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.com.kroton.dao.generic.ReportDAO;
import br.com.kroton.jpa.ReportBean;
import br.com.kroton.jpa.ReportInfoGeralBean;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

@SuppressWarnings("deprecation")
@Path("report")
public class ReportService {

	@GET @Produces(MediaType.APPLICATION_JSON) 
	public Response getAll() {
		List<ReportBean> dataReport = new ReportDAO().getDataReport(null);
		GenericEntity<List<ReportBean>> list = new GenericEntity<List<ReportBean>>(dataReport) {};
		return Response.ok(list).build();
	}
	
	@GET @Produces(MediaType.APPLICATION_JSON) 
	@Path("infoGeral")
	public Response getInfoGerAll() {
		List<ReportInfoGeralBean> dataReport = new ReportDAO().infoGerais();
		GenericEntity<List<ReportInfoGeralBean>> list = new GenericEntity<List<ReportInfoGeralBean>>(dataReport) {};
		return Response.ok(list).build();
	}
	
	@GET
	@Path("pdf")
	@Produces("application/pdf")
	public Response getPdf() throws JRException, IOException {
	    
	    InputStream is = getClass().getResourceAsStream("../reports/report.jrxml");
	    Image gto = new ImageIcon(getClass().getResource("../reports/logo.jpg")).getImage();
	    
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("logo", gto);
	    
	    List<ReportBean> dataReport = new ReportDAO().getDataReport(null);

		
	    JasperReport jrxmlPath = JasperCompileManager.compileReport(is);
	    JasperPrint printReport = JasperFillManager.fillReport(jrxmlPath, params, new JRBeanCollectionDataSource(dataReport, false));
	    
	    File file = File.createTempFile("report", ".pdf");
		JasperExportManager.exportReportToPdfFile(printReport, file.getAbsolutePath());

		ResponseBuilder response = Response.ok((Object) file);
	    
	    response.header("Content-Disposition",
	    		"attachment; filename=\"report.pdf\"");
	    
	    return response.build();
	}
	
	@GET
	@Path("xls")
	@Produces("application/vnd.ms-excel")
	public Response getXls() throws JRException, IOException {
	    InputStream is = getClass().getResourceAsStream("../reports/report.jrxml");
	    Image gto = new ImageIcon(getClass().getResource("../reports/logo.jpg")).getImage();
	    
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("logo", gto);
	    
	    List<ReportBean> dataReport = new ReportDAO().getDataReport(null);

		
	    JasperReport jrxmlPath = JasperCompileManager.compileReport(is);
	    JasperPrint printReport = JasperFillManager.fillReport(jrxmlPath, params, new JRBeanCollectionDataSource(dataReport, false));
	    
	    File file = File.createTempFile("report", ".pdf");
	    JRXlsExporter exporter = new JRXlsExporter();
	    exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, printReport);
	    exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
        exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
        exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
        exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
	    exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, file.getAbsolutePath() );

	    exporter.exportReport();
	    
	    ResponseBuilder response = Response.ok((Object) file);
	    
	    response.header("Content-Disposition",
	    		"attachment; filename=\"report.xls\"");
	    
	    return response.build();
	}
}
