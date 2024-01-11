package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.EmpAttendnaceDto;
import lk.ijse.dto.EmployeeAttendanceJoin;
import lk.ijse.entity.EmpAttendnace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmlpoyeeAttendanceDAO extends SuperDAO {

     boolean saveEmpAttendance(String num, String empAttendanceID, String empId) throws SQLException, ClassNotFoundException;

     int generateNextOrderId() throws SQLException;
     List<EmployeeAttendanceJoin> getAllEmployeeAttndance() throws SQLException, ClassNotFoundException;
    int howMachEmployeeAttendance() throws SQLException;
    List<EmpAttendnace> getAllEmployeeAttendance(String id) throws SQLException, ClassNotFoundException;
}
