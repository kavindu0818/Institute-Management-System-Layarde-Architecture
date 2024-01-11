package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.CourseDto;

import java.sql.SQLException;
import java.util.List;

public interface CourseBO extends SuperBO {

     List<CourseDto> getAllcourseDetails() throws SQLException, ClassNotFoundException;

     List<CourseDto> getAllcourseIDBO() throws SQLException, ClassNotFoundException;

     List<CourseDto> getCourseIDBO() throws SQLException, ClassNotFoundException;

     boolean saveCourseDetailsBO(String courseID, String courseName, String courseFeee, String courseDuration, String date) throws SQLException, ClassNotFoundException;

}