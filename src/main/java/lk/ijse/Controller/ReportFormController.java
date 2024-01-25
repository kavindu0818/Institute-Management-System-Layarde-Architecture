package lk.ijse.Controller;

import javafx.event.ActionEvent;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.bo.custom.ReportBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.NoticeDAO;
import lk.ijse.db.DbConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;

public class ReportFormController {

    ReportBO reportBO = (ReportBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.REPORT);

    public void btnEmployeeDetailsOnAction(ActionEvent actionEvent) throws SQLException, JRException {
        String empReport = "/Report/Employee_Details.jrxml";
        reportBO.employeeReport(empReport);

    }

    public void btnStudentDDetailsOnAction(ActionEvent actionEvent) throws JRException, SQLException {
        String stuReport = "/Report/StudentDetails.jrxml";
        reportBO.studentReport(stuReport);

    }
}
