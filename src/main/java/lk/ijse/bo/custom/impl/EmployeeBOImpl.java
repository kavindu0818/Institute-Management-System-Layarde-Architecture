package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
    public EmployeeDto loardEmpValuesDetails(String aId) throws SQLException {
        return employeeDAO.loardEmpValues(aId);
    }

    public boolean saveEmployeeBO(EmployeeDto emp) throws SQLException {
       return employeeDAO.save(emp);
    }

    public EmployeeDto allEmployeeDetailsBO(String empId) throws SQLException {
       return employeeDAO.allEmployeeDetails(empId);
    }

    public List<EmployeeDto> getAllEmployeeBO() throws SQLException {
       return employeeDAO.getAll();
    }

    public int howMachEmployeeBO() throws SQLException {
       return employeeDAO.howMach();
    }

    public boolean updateEmployeeBO(EmployeeDto emp) throws SQLException {
        return employeeDAO.update(emp);
    }

    public EmployeeDto searchEmployeeBO(String empId) throws SQLException {
       return employeeDAO.search(empId);
    }
}
