package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.dto.ClassPaymentDto;
import lk.ijse.dto.Class_paymentDto;
import lk.ijse.entity.ClassPayment;
import lk.ijse.entity.Class_payment;

import java.sql.SQLException;
import java.util.List;

public interface Class_PaymentDAO extends CrudDAO<Class_payment> {

     int generateNextOrderId() throws SQLException;
     int splitOrderId(int id);
    List<Class_paymentDto> getClassStudent(String classId, String month) throws SQLException, ClassNotFoundException;
    boolean stuPaymentSave(String num,String classId, String stuId, String name, String month, String stuFullId, double amount) throws SQLException, ClassNotFoundException;
    List<Class_payment> getStudentAllPayment(String iD) throws SQLException, ClassNotFoundException;
    List<ClassPaymentDto> readyClassFessDetails(String classId, String month) throws SQLException;
    List<ClassPayment> getAllClassPayment(String clssID, String month) throws SQLException, ClassNotFoundException;

}
