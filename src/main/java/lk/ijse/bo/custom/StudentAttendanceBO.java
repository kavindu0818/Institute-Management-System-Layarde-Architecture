package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.Class_DetailsDto;
import lk.ijse.dto.StudentAttendance;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface StudentAttendanceBO extends SuperBO {

     List<StudentAttendance> getClassStudentDetails(String classID, LocalDate classDate) throws SQLException, ClassNotFoundException;
     List<StudentAttendance> getAllStudentAttendance() throws SQLException, ClassNotFoundException;
    boolean saveAttendnceDetailsStudent(Class_DetailsDto dtoList) throws SQLException, ClassNotFoundException;
    int howMachStudentBO() throws SQLException, ClassNotFoundException;
    List<StudentAttendance> getStudentAllAttendnceBO(String id1) throws SQLException, ClassNotFoundException;

}
