package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.CourseDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CourseDAO extends SuperDAO {

    public boolean saveCourseDetails(String courseID, String courseName, String courseFeee, String courseDuration, String date) throws SQLException, ClassNotFoundException;
    public List<CourseDto> getAllcourse() throws SQLException, ClassNotFoundException;
    public List<CourseDto> getCourseID() throws SQLException, ClassNotFoundException;
    public List<CourseDto> getAllcourseID() throws SQLException, ClassNotFoundException;
}
