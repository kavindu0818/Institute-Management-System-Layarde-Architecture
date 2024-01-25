package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.CfdDto;
import lk.ijse.dto.CoursePaymentJoinDto;
import lk.ijse.dto.SetPaymentDto;

import java.sql.SQLException;
import java.util.List;

public interface Course_PaymentBO extends SuperBO {

    List<CoursePaymentJoinDto> getAllPaymentBO(String cusID, String date) throws SQLException, ClassNotFoundException;
    List<CfdDto> getStudentAllPaymentBO(String id2) throws SQLException, ClassNotFoundException;
    boolean setPaymentDetails(SetPaymentDto dto) throws SQLException;
    boolean updatePayment(double a,String id) throws SQLException, ClassNotFoundException;


        int generateNextCourseFeeIdBO() throws SQLException;
}
