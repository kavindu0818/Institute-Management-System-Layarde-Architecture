package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.Course_detailsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Course_DetailsDAO extends SuperDAO {

     boolean upateAmount(double amont, String studentId) throws SQLException, ClassNotFoundException;
     Course_detailsDto getAllValuesCd(String a) throws SQLException, ClassNotFoundException;
     List<Course_detailsDto> getAllCourseValue(String sd) throws SQLException, ClassNotFoundException;
     boolean saveCourseDetails(String paymentID,String courseId,String stuId,String stuName, String courseName, Double amount) throws SQLException, ClassNotFoundException;
     List<Course_detailsDto> getCourseDetailsID(String a) throws SQLException, ClassNotFoundException;

     Course_detailsDto courseName(String cf) throws SQLException, ClassNotFoundException;
     Course_detailsDto getAllDetails(String id, String cusID) throws SQLException, ClassNotFoundException;
}
