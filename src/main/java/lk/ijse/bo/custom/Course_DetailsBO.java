package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.Course_detailsDto;

import java.sql.SQLException;
import java.util.List;

public interface Course_DetailsBO extends SuperBO {

    boolean saveCourseDetailsStudent(String paymentID, String courseId, String stuId, String stuName, String courseName, Double amount) throws SQLException, ClassNotFoundException;
    Course_detailsDto getsendMailValueAll(String csId) throws SQLException, ClassNotFoundException;
    List<Course_detailsDto> getAllCourseValueBO(String cd) throws SQLException, ClassNotFoundException;
    Course_detailsDto courseNameBO(String cf) throws SQLException, ClassNotFoundException;
    Course_detailsDto getAllDetailsBO(String id, String cusID) throws SQLException, ClassNotFoundException;

}
