package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.CourseBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CourseDAO;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.impl.CourseDAOImpl;
import lk.ijse.dto.CourseDto;

import java.sql.SQLException;
import java.util.List;

public class CourseBoImpl implements CourseBO {


    CourseDAO courseDAO = (CourseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE);

    public List<CourseDto> getAllcourseDetails() throws SQLException, ClassNotFoundException {
        return courseDAO.getAllcourse();
    }

    public List<CourseDto> getAllcourseIDBO() throws SQLException, ClassNotFoundException {
       return courseDAO.getAllcourseID();
    }

    public List<CourseDto> getCourseIDBO() throws SQLException, ClassNotFoundException {
         return courseDAO.getCourseID();
    }

    public boolean saveCourseDetailsBO(String courseID, String courseName, String courseFeee, String courseDuration, String date) throws SQLException, ClassNotFoundException {
        return courseDAO.saveCourseDetails(courseID,courseName,courseFeee,courseDuration,date);
    }
}
