package forestalreportes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author BJ
 */
public class generarReporte {
 public void generar(List<arbolProcesado> listaArboles){
   //public void generar(){
     //List<arbolProcesado> listaPrueba = new ArrayList<arbolProcesado>();
     //int uno=1;
     //int dos=2;
     //arbolProcesado ap=new arbolProcesado("1", "xx","xx", "xx", "xx", "xx", "xx", "xx", "C:\\software\\fotos\\"+uno+".jpg", "C:\\software\\fotos\\"+dos+".jpg");
     //listaPrueba.add(ap);
            try
            {
                JasperReport reporte = JasperCompileManager.compileReport(
          "C:\\software\\forestalReports\\form1.jrxml");
    

                    
                //JasperReport reporte = (JasperReport) JRLoader.loadObject("C:\\Software\\report1.jasper");
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(listaArboles));
                //JRExporter exporter = new JRPdfExporter();
                JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\software\\forestalReports\\resultado.pdf");
      //Para visualizar el pdf directamente desde java
                        JasperViewer.viewReport(jasperPrint, false);                

//exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                //exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reporteEnPdf.pdf"));
               //exporter.exportReport();
            }
            catch(JRException e)
            {
                e.printStackTrace();
            } 
 
 }   
 
 
}
