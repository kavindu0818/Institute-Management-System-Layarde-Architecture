package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.dto.ClassDto;
import lk.ijse.entity.Class;

import java.sql.SQLException;
import java.util.List;

public interface ClassDAO extends SuperDAO {

    List<Class> getAllClass() throws SQLException, ClassNotFoundException;
    List<ClassDto> getAllStudent() throws SQLException;
    boolean saveCoursesClass(String courseID, String courseName, String tutor) throws SQLException;
    boolean saveCoursesClass(Class cd) throws SQLException, ClassNotFoundException;
    boolean classSave(Class cms) throws SQLException, ClassNotFoundException;
}
