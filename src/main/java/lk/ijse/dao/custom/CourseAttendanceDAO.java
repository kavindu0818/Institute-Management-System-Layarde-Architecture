package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.AttendanceJoin;
import lk.ijse.entity.CourseAttendanceJoin;
import lk.ijse.entity.CourseAttendanceStuDetailsJoin;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CourseAttendanceDAO extends CrudDAO<CourseAttendanceJoin> {

    // ArrayList<CourseAttendanceJoin> getAllCourseAttendance(String courseID, String date) throws SQLException, ClassNotFoundException;
     boolean saveAttendnceDetails(String aId, String num1) throws SQLException, ClassNotFoundException;
     int generateNextOrderId() throws SQLException;
     int splitOrderId(int id);
   //  ArrayList<AttendanceJoin> getAllAttndance() throws SQLException, ClassNotFoundException;
     int howMachCourseStudent() throws SQLException, ClassNotFoundException;
    /// ArrayList<CourseAttendanceStuDetailsJoin> getStudentAllAttendnce(String id1) throws SQLException, ClassNotFoundException;
}
