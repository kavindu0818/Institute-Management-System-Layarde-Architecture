package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.AttendanceJoinDto;
import lk.ijse.dto.CourseAttendanceJoinDto;
import lk.ijse.dto.CourseAttendanceStuDetailsJoinDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CourseAttendanceDAO extends SuperDAO {

     List<CourseAttendanceJoinDto> getAllCourseAttendance(String courseID, String date) throws SQLException, ClassNotFoundException;
     boolean saveAttendnceDetails(String aId, String num1) throws SQLException, ClassNotFoundException;
     int generateNextOrderId() throws SQLException;
     int splitOrderId(int id);
     List<AttendanceJoinDto>getAllAttndance() throws SQLException, ClassNotFoundException;
     int howMachCourseStudent() throws SQLException;
     List<CourseAttendanceStuDetailsJoinDto> getStudentAllAttendnce(String id1) throws SQLException, ClassNotFoundException;
}
