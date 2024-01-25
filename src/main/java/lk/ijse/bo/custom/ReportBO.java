package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import net.sf.jasperreports.engine.JRException;

import java.sql.SQLException;

public interface ReportBO extends SuperBO {

     void reprt(String address) throws JRException, SQLException;

    void employeeReport(String empReport) throws JRException, SQLException;

    void studentReport(String stuReport) throws JRException, SQLException;
}
