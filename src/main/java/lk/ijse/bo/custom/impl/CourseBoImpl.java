package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.CourseBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CourseDAO;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.impl.CourseDAOImpl;
import lk.ijse.dto.CourseDto;
import lk.ijse.entity.Course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseBoImpl implements CourseBO {


    CourseDAO courseDAO = (CourseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE);

    public List<CourseDto> getAllcourseDetails() throws SQLException, ClassNotFoundException {
       List<Course> courses = courseDAO.getAllcourse();
        ArrayList<CourseDto> courseDtos = new ArrayList<>();

        for (Course course: courses){
            courseDtos.add(new CourseDto(course.getCusId(),course.getCusName(),course.getCusFee(),course.getCourseStartDay(),course.getCourseDuration()));
        }

        return courseDtos;
    }

    public List<CourseDto> getAllcourseIDBO() throws SQLException, ClassNotFoundException {
        List<Course> courses = courseDAO.getAllcourseID();;
        ArrayList<CourseDto> courseDtos = new ArrayList<>();

        for (Course course: courses){
            courseDtos.add(new CourseDto(course.getCusId(),course.getCusName(),course.getCusFee(),course.getCourseStartDay(),course.getCourseDuration()));
        }

        return courseDtos;

    }

    public List<CourseDto> getCourseIDBO() throws SQLException, ClassNotFoundException {
        List<Course> courses = courseDAO.getCourseID();
        ArrayList<CourseDto> courseDtos = new ArrayList<>();

        for (Course course: courses){
            courseDtos.add(new CourseDto(course.getCusId(),course.getCusName(),course.getCusFee(),course.getCourseStartDay(),course.getCourseDuration()));
        }

        return courseDtos;

    }

    public boolean saveCourseDetailsBO(String courseID, String courseName, String courseFeee, String courseDuration, String date) throws SQLException, ClassNotFoundException {
        return courseDAO.saveCourseDetails(courseID,courseName,courseFeee,courseDuration,date);
    }

}
