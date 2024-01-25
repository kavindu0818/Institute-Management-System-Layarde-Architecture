package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ReportBO;
import lk.ijse.db.DbConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;

public class ReportBOImpl implements ReportBO {

   // String location = null;

    public void reprt(String address) throws JRException, SQLException {
        InputStream resourceAsStream = getClass().getResourceAsStream(address);
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(load);

        JasperPrint jasperPrint =
                JasperFillManager.fillReport(
                        jasperReport, //compiled report
                        null,
                        DbConnection.getInstance().getConnection() //database connection
                );

        JasperViewer.viewReport(jasperPrint, false);
    }

    @Override
    public void employeeReport(String empReport) throws JRException, SQLException {
        reprt(empReport);
    }

    @Override
    public void studentReport(String stuReport) throws JRException, SQLException {
        reprt(stuReport);
    }
}
