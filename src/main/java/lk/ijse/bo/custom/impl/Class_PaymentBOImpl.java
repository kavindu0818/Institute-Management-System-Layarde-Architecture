package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.Class_PaymentBO;
import lk.ijse.dao.custom.Class_PaymentDAO;
import lk.ijse.dao.custom.impl.Class_PaymentDAOImpl;
import lk.ijse.dto.ClassPaymentDto;
import lk.ijse.dto.Class_paymentDto;

import java.sql.SQLException;
import java.util.List;

public class Class_PaymentBOImpl implements Class_PaymentBO {

    Class_PaymentDAO classPaymentDAO = new Class_PaymentDAOImpl();

    public boolean stuPaymentSaveBO(String num, String classId, String stuId, String name, String month, String stuFullId, double amount) throws SQLException, ClassNotFoundException {
       return classPaymentDAO.stuPaymentSave(num,classId,stuId,name,month,stuFullId,amount);
    }

    public int generateNextOrderIdBO() throws SQLException {
        return classPaymentDAO.generateNextOrderId();
    }

    public List<ClassPaymentDto> getAllClassPaymentBO(String clssID, String month) throws SQLException, ClassNotFoundException {
       return classPaymentDAO.getAllClassPayment(clssID,month);
    }

    public List<Class_paymentDto> getStudentAllPaymentBO(String id2) throws SQLException, ClassNotFoundException {
       return classPaymentDAO.getStudentAllPayment(id2);
    }
}
