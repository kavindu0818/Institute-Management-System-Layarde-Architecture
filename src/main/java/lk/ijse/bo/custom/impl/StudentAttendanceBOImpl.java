package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.StudentAttendanceBO;
import lk.ijse.dao.custom.impl.Stu_AttendanceDAOImpl;
import lk.ijse.dto.Class_DetailsDto;
import lk.ijse.dto.StudentAttendance;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class StudentAttendanceBOImpl implements StudentAttendanceBO {

    Stu_AttendanceDAOImpl stu_attendanceDAO = new Stu_AttendanceDAOImpl();
    public List<StudentAttendance> getClassStudentDetails(String classID, LocalDate classDate) throws SQLException, ClassNotFoundException {
       return stu_attendanceDAO.getClassStudent(classID,classDate);
    }

    public List<StudentAttendance> getAllStudentAttendance() throws SQLException, ClassNotFoundException {
        return stu_attendanceDAO.getAllStudent();
    }

    public boolean saveAttendnceDetailsStudent(Class_DetailsDto dtoList) throws SQLException, ClassNotFoundException {
       return stu_attendanceDAO.saveAttendnceDetails(dtoList);
    }

    public int howMachStudentBO() throws SQLException, ClassNotFoundException {
       return stu_attendanceDAO.howMachStudent();
    }

    public List<StudentAttendance> getStudentAllAttendnceBO(String id1) throws SQLException, ClassNotFoundException {
       return stu_attendanceDAO.getStudentAllAttendnce(id1);
    }
}
