package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.ClassPaymentDto;
import lk.ijse.dto.Class_paymentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Class_PaymentDAO extends SuperDAO {

     int generateNextOrderId() throws SQLException;
     int splitOrderId(int id);
    List<Class_paymentDto> getClassStudent(String classId, String month) throws SQLException, ClassNotFoundException;
    boolean stuPaymentSave(String num,String classId, String stuId, String name, String month, String stuFullId, double amount) throws SQLException, ClassNotFoundException;
    List<Class_paymentDto> getStudentAllPayment(String iD) throws SQLException, ClassNotFoundException;
    List<ClassPaymentDto> readyClassFessDetails(String classId, String month) throws SQLException;
    List<ClassPaymentDto> getAllClassPayment(String clssID, String month) throws SQLException, ClassNotFoundException;

}
