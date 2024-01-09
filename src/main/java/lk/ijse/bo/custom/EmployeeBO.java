package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {

    public EmployeeDto loardEmpValuesDetails(String aId) throws SQLException;

    public boolean saveEmployeeBO(EmployeeDto emp) throws SQLException;

    public EmployeeDto allEmployeeDetailsBO(String empId) throws SQLException;

    public List<EmployeeDto> getAllEmployeeBO() throws SQLException ;

    public int howMachEmployeeBO() throws SQLException;
    public boolean updateEmployeeBO(EmployeeDto emp) throws SQLException;

    public EmployeeDto searchEmployeeBO(String empId) throws SQLException;
}
