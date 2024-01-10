package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AttendanceJoinDto;
import lk.ijse.dto.CourseAttendanceJoinDto;
import lk.ijse.dto.CourseAttendanceStuDetailsJoinDto;

import java.sql.SQLException;
import java.util.List;

public interface Course_AttendanceBO extends SuperBO {

     List<AttendanceJoinDto> getAllAttndanceCourse() throws SQLException, ClassNotFoundException;
     boolean saveAttendnceDetailsBo(String aId, String num1) throws SQLException, ClassNotFoundException;
     int howMachCourseStudentBo() throws SQLException;
     List<CourseAttendanceJoinDto> getAllCourseAttendanceBO(String courseID, String date) throws SQLException, ClassNotFoundException;
     int howMachCourseStudentBO() throws SQLException;
     List<CourseAttendanceStuDetailsJoinDto> getStudentAllAttendnceBO(String id1) throws SQLException, ClassNotFoundException;

    int generateNextOrderIdBO() throws SQLException;
}
