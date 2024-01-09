package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.CfdDto;
import lk.ijse.dto.CoursePaymentJoinDto;

import java.sql.SQLException;
import java.util.List;

public interface Course_PaymentBO extends SuperBO {

    List<CoursePaymentJoinDto> getAllPaymentBO(String cusID, String date) throws SQLException, ClassNotFoundException;
    List<CfdDto> getStudentAllPaymentBO(String id2) throws SQLException, ClassNotFoundException;
}
