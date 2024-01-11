package lk.ijse.dao.custom;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.Course_detailsDto;
import lk.ijse.entity.Course_details;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Course_DetailsDAO extends SuperDAO {

     boolean upateAmount(double amont, String studentId) throws SQLException, ClassNotFoundException;

     Course_details getAllValuesCd(String a) throws SQLException, ClassNotFoundException;

     List<Course_details> getAllCourseValue(String sd) throws SQLException, ClassNotFoundException;

     boolean saveCourseDetails(String paymentID, String courseId, String stuId, String stuName, String courseName, Double amount) throws SQLException, ClassNotFoundException;

     List<Course_details> getCourseDetailsID(String a) throws SQLException, ClassNotFoundException;

     Course_details courseName(String cf) throws SQLException, ClassNotFoundException;

     Course_details getAllDetails(String id, String cusID) throws SQLException, ClassNotFoundException;

     Course_details getsendMailValue(String csId) throws SQLException, ClassNotFoundException;

}
