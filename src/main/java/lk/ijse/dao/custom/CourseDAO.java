package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.CourseDto;
import lk.ijse.entity.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CourseDAO extends SuperDAO {

    public boolean saveCourseDetails(String courseID, String courseName, String courseFeee, String courseDuration, String date) throws SQLException, ClassNotFoundException;
    public List<Course> getAllcourse() throws SQLException, ClassNotFoundException;
    public List<Course> getCourseID() throws SQLException, ClassNotFoundException;
    public List<Course> getAllcourseID() throws SQLException, ClassNotFoundException;
}
