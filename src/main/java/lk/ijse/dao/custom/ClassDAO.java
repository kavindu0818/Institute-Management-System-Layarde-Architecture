package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.ClassDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ClassDAO extends SuperDAO {

    List<ClassDto> getAllClass() throws SQLException, ClassNotFoundException;
    List<ClassDto> getAllStudent() throws SQLException;
    boolean saveCoursesClass(String courseID, String courseName, String tutor) throws SQLException;
    boolean saveCoursesClass(ClassDto cd) throws SQLException, ClassNotFoundException;
    boolean classSave(ClassDto cms) throws SQLException, ClassNotFoundException;
}
