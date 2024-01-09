package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.EmpAttendnaceDto;
import lk.ijse.dto.EmployeeAttendanceJoin;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeAttendanceBO extends SuperBO {

    public List<EmployeeAttendanceJoin> getAllEmployeeAttndanceAll() throws SQLException, ClassNotFoundException;
    public boolean saveEmpAttendanceBo(String num, String empAttendanceID, String empId) throws SQLException, ClassNotFoundException;
    public List<EmpAttendnaceDto> getAllEmployeeAttendanceBO(String id) throws SQLException, ClassNotFoundException;

}
