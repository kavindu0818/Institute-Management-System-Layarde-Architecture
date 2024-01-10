package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.Course_DetailsBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CourseAttendanceDAO;
import lk.ijse.dao.custom.Course_DetailsDAO;
import lk.ijse.dao.custom.impl.Course_detailsDAOImpl;
import lk.ijse.dto.Course_detailsDto;

import java.sql.SQLException;
import java.util.List;

public class Course_DetailsBOImpl implements Course_DetailsBO {

    Course_DetailsDAO courseDetailsDAO = (Course_DetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE_DETAILS);

    public boolean saveCourseDetailsStudent(String paymentID, String courseId, String stuId, String stuName, String courseName, Double amount) throws SQLException, ClassNotFoundException {

        return courseDetailsDAO.saveCourseDetails(paymentID,courseId,stuId,stuName,courseName,amount);
    }

    public Course_detailsDto getsendMailValueAll(String csId) throws SQLException, ClassNotFoundException {
        return courseDetailsDAO.getsendMailValue(csId);
    }

    public List<Course_detailsDto> getAllCourseValueBO(String cd) throws SQLException, ClassNotFoundException {
       return courseDetailsDAO.getAllCourseValue(cd);
    }

    public Course_detailsDto courseNameBO(String cf) throws SQLException, ClassNotFoundException {
       return courseDetailsDAO.courseName(cf);
    }

    public Course_detailsDto getAllDetailsBO(String id, String cusID) throws SQLException, ClassNotFoundException {
       return courseDetailsDAO.getAllDetails(id,cusID);
    }

    @Override
    public Course_detailsDto getAllValuesCdBO(String a) throws SQLException, ClassNotFoundException {
        return courseDetailsDAO.getAllValuesCd(a);
    }
}
