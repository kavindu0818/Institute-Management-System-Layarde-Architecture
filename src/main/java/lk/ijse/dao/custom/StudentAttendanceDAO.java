package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.Class_DetailsDto;
import lk.ijse.dto.StudentAttendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface StudentAttendanceDAO extends CrudDAO<StudentAttendance> {

    public boolean saveAttendnceDetails(Class_DetailsDto dtoList) throws SQLException, ClassNotFoundException;
    public List<StudentAttendance> getAllStudent() throws SQLException, ClassNotFoundException;
    public List<StudentAttendance> getClassStudent(String clId, LocalDate classDate) throws SQLException, ClassNotFoundException;
    public List<StudentAttendance> getStudentAllAttendnce(String iD) throws SQLException, ClassNotFoundException;
    public int howMachStudent() throws SQLException, ClassNotFoundException;
}
