package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.CfdDto;
import lk.ijse.dto.CoursePaymentJoinDto;
import lk.ijse.entity.Cfd;
import lk.ijse.entity.CoursePaymentJoin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Course_PaymentDAO extends CrudDAO<CoursePaymentJoin> {

     boolean savePayment(String payId, double amount, String cusDfull, String stuID) throws SQLException, ClassNotFoundException;
     int generateNextCourseFeeId() throws SQLException;
     int splitOrderId(int id);
   //  List<CoursePaymentJoin> getAllPayment(String cusID, String date) throws SQLException, ClassNotFoundException;
     //List<Cfd> getStudentAllPayment(String id2) throws SQLException, ClassNotFoundException;
}
