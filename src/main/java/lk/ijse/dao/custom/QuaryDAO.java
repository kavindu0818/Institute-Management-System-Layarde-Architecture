package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.dto.ClassPaymentDto;
import lk.ijse.dto.EmployeeAttendanceJoin;
import lk.ijse.entity.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface QuaryDAO extends SuperDAO {

    public List<ClassPaymentDto> readyClassFessDetails(String classId, String month) throws SQLException;
    public List<Cfd> getStudentAllPayment(String id2) throws SQLException, ClassNotFoundException;
    public ArrayList<CourseAttendanceJoin> getAllCourseAttendance(String courseID, String date) throws SQLException, ClassNotFoundException;
    public ArrayList<AttendanceJoin> getAllAttndance() throws SQLException, ClassNotFoundException;
    public ArrayList<CourseAttendanceStuDetailsJoin> getStudentAllAttendnce(String id1) throws SQLException, ClassNotFoundException;
    public List<EmployeeAttendanceJoin> getAllEmployeeAttndance() throws SQLException, ClassNotFoundException;
    public List<ClassPayment> getAllClassPayment(String clssID, String month) throws SQLException, ClassNotFoundException;
    public List<CoursePaymentJoin> getAllPayment(String cusID, String date) throws SQLException, ClassNotFoundException;


    }
