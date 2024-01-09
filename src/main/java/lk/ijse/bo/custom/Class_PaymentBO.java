package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.ClassPaymentDto;
import lk.ijse.dto.Class_paymentDto;

import java.sql.SQLException;
import java.util.List;

public interface Class_PaymentBO extends SuperBO {

    boolean stuPaymentSaveBO(String num, String classId, String stuId, String name, String month, String stuFullId, double amount) throws SQLException, ClassNotFoundException;


    int generateNextOrderIdBO() throws SQLException;

    List<ClassPaymentDto> getAllClassPaymentBO(String clssID, String month) throws SQLException, ClassNotFoundException;


    List<Class_paymentDto> getStudentAllPaymentBO(String id2) throws SQLException, ClassNotFoundException;

}
