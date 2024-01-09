package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.Course_AttendanceBO;
import lk.ijse.dao.custom.impl.CourseAttendanceDAOImpl;
import lk.ijse.dto.AttendanceJoinDto;
import lk.ijse.dto.CourseAttendanceJoinDto;
import lk.ijse.dto.CourseAttendanceStuDetailsJoinDto;

import java.sql.SQLException;
import java.util.List;

public class Course_AttendanceBOImpl implements Course_AttendanceBO {

    CourseAttendanceDAOImpl courseAttendanceDAO = new CourseAttendanceDAOImpl();
    public List<AttendanceJoinDto> getAllAttndanceCourse() throws SQLException, ClassNotFoundException {
       return courseAttendanceDAO.getAllAttndance();


    }

    public boolean saveAttendnceDetailsBo(String aId, String num1) throws SQLException, ClassNotFoundException {
        return courseAttendanceDAO.saveAttendnceDetails(aId,num1);
    }

    public int howMachCourseStudentBo() throws SQLException {
        return courseAttendanceDAO.howMachCourseStudent();
    }

    public List<CourseAttendanceJoinDto> getAllCourseAttendanceBO(String courseID, String date) throws SQLException, ClassNotFoundException {
        return courseAttendanceDAO.getAllCourseAttendance(courseID,date);
    }

    public int howMachCourseStudentBO() throws SQLException {
       return courseAttendanceDAO.howMachCourseStudent();
    }

    public List<CourseAttendanceStuDetailsJoinDto> getStudentAllAttendnceBO(String id1) throws SQLException, ClassNotFoundException {
       return courseAttendanceDAO.getStudentAllAttendnce(id1);
    }
}
