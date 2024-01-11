package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.Course_PaymentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CourseAttendanceDAO;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.impl.Course_paymentDAOImpl;
import lk.ijse.dto.CfdDto;
import lk.ijse.dto.CoursePaymentJoinDto;
import lk.ijse.entity.Cfd;
import lk.ijse.entity.CoursePaymentJoin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Course_PaymentBOImpl implements Course_PaymentBO {

    Course_PaymentDAO coursePaymentDAO = (Course_PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE_PAYMENT);

    public List<CoursePaymentJoinDto> getAllPaymentBO(String cusID, String date) throws SQLException, ClassNotFoundException {

        List<CoursePaymentJoin> coursePaymentJoins = coursePaymentDAO.getAllPayment(cusID,date);
        ArrayList<CoursePaymentJoinDto> coursePaymentJoinDtos = new ArrayList<>();

        for (CoursePaymentJoin coursePaymentJoin: coursePaymentJoins){
            coursePaymentJoinDtos.add(new CoursePaymentJoinDto(coursePaymentJoin.getStuID(),coursePaymentJoin.getStuName(),coursePaymentJoin.getDate(),coursePaymentJoin.getAmount()));
        }

       return coursePaymentJoinDtos;

    }

    public List<CfdDto> getStudentAllPaymentBO(String id2) throws SQLException, ClassNotFoundException {

        List<Cfd> cfds = coursePaymentDAO.getStudentAllPayment(id2);
        ArrayList<CfdDto> cfdDtos = new ArrayList<>();

        for(Cfd cfd : cfds){
            cfdDtos.add(new CfdDto(cfd.getSub(),cfd.getAmount(),cfd.getDay()));

        }

       return cfdDtos;
    }

    @Override
    public int generateNextCourseFeeIdBO() throws SQLException {
        return coursePaymentDAO.generateNextCourseFeeId();
    }
}
