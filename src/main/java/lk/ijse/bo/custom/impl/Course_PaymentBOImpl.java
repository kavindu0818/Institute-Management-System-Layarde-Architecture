package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.Course_PaymentBO;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.impl.Course_paymentDAOImpl;
import lk.ijse.dto.CfdDto;
import lk.ijse.dto.CoursePaymentJoinDto;

import java.sql.SQLException;
import java.util.List;

public class Course_PaymentBOImpl implements Course_PaymentBO {

    Course_paymentDAOImpl coursePaymentDAO = new Course_paymentDAOImpl();
    public List<CoursePaymentJoinDto> getAllPaymentBO(String cusID, String date) throws SQLException, ClassNotFoundException {
       return coursePaymentDAO.getAllPayment(cusID,date);

    }

    public List<CfdDto> getStudentAllPaymentBO(String id2) throws SQLException, ClassNotFoundException {
       return coursePaymentDAO.getStudentAllPayment(id2);
    }
}
