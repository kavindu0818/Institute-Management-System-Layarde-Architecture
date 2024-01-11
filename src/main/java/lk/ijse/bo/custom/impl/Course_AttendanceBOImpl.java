package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.Course_AttendanceBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CourseAttendanceDAO;
import lk.ijse.dao.custom.impl.CourseAttendanceDAOImpl;
import lk.ijse.dto.AttendanceJoinDto;
import lk.ijse.dto.ClassDto;
import lk.ijse.dto.CourseAttendanceJoinDto;
import lk.ijse.dto.CourseAttendanceStuDetailsJoinDto;
import lk.ijse.entity.*;
import lk.ijse.entity.Class;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course_AttendanceBOImpl implements Course_AttendanceBO {

   CourseAttendanceDAO courseAttendanceDAO = (CourseAttendanceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSEATTENDANCE);

    public List<AttendanceJoinDto> getAllAttndanceCourse() throws SQLException, ClassNotFoundException {
        
        ArrayList<AttendanceJoinDto> attendanceJoinDtos = new ArrayList<>();
        ArrayList<AttendanceJoin> attendanceJoins =  courseAttendanceDAO.getAllAttndance();
        for (AttendanceJoin attendanceJoin : attendanceJoins){
            attendanceJoinDtos.add(new AttendanceJoinDto(attendanceJoin.getAttendanceID(),attendanceJoin.getDate(),attendanceJoin.getTime(),attendanceJoin.getCusID(),attendanceJoin.getStuName(),attendanceJoin.getStuID()));

        }
        
       return attendanceJoinDtos;
        
    }

    public boolean saveAttendnceDetailsBo(String aId, String num1) throws SQLException, ClassNotFoundException {
        return courseAttendanceDAO.saveAttendnceDetails(aId,num1);
    }

    public int howMachCourseStudentBo() throws SQLException {
        return courseAttendanceDAO.howMachCourseStudent();
    }

    public List<CourseAttendanceJoinDto> getAllCourseAttendanceBO(String courseID, String date) throws SQLException, ClassNotFoundException {

        ArrayList<CourseAttendanceJoinDto> courseAttendanceJoinDtos = new ArrayList<>();
        ArrayList<CourseAttendanceJoin> courseAttendances =  courseAttendanceDAO.getAllCourseAttendance(courseID,date);
        for (CourseAttendanceJoin courseAttendanceJoin : courseAttendances){
            courseAttendanceJoinDtos.add(new CourseAttendanceJoinDto(courseAttendanceJoin.getStuID(),courseAttendanceJoin.getStuName(),courseAttendanceJoin.getDate(),courseAttendanceJoin.getTime(),courseAttendanceJoin.getAttendnceID()));

        }


        return courseAttendanceJoinDtos;
    }

    public int howMachCourseStudentBO() throws SQLException {
       return courseAttendanceDAO.howMachCourseStudent();
    }

    public List<CourseAttendanceStuDetailsJoinDto> getStudentAllAttendnceBO(String id1) throws SQLException, ClassNotFoundException {


        ArrayList<CourseAttendanceStuDetailsJoinDto> courseAttendanceStuDetailsJoinDtos = new ArrayList<>();
        ArrayList<CourseAttendanceStuDetailsJoin> courseAttendanceStuDetailsJoins =  courseAttendanceDAO.getStudentAllAttendnce(id1);
        for (CourseAttendanceStuDetailsJoin courseAttendanceStuDetailsJoin : courseAttendanceStuDetailsJoins){
            courseAttendanceStuDetailsJoinDtos.add(new CourseAttendanceStuDetailsJoinDto(courseAttendanceStuDetailsJoin.getDate(),courseAttendanceStuDetailsJoin.getSub(),courseAttendanceStuDetailsJoin.getTime()));

        }
        return courseAttendanceStuDetailsJoinDtos;
    }

    @Override
    public int generateNextOrderIdBO() throws SQLException {
        return courseAttendanceDAO.generateNextOrderId();
    }
}
