package lk.ijse.bo.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    ;

    @Override
    public EmployeeDto loardEmpValuesDetails(String aId) throws SQLException, ClassNotFoundException {
        Employee employee = employeeDAO.loardEmpValues(aId);
        EmployeeDto employeeDto = new EmployeeDto(employee.getEmp_id(),employee.getName(),employee.getGmail(),employee.getContactNo(),employee.getNic(),employee.getAddress(),employee.getPosition(),employee.getDate(),employee.getBankAccountNum(),employee.getBankBranchName(),employee.getAge(),employee.getGendar(),employee.getImage(),employee.getEmpAttendanceID());
        return employeeDto;
    }

    @Override
    public boolean saveEmployeeBO(EmployeeDto employee) throws SQLException, ClassNotFoundException {
       Employee employeeEnt = new Employee(employee.getEmp_id(),employee.getName(),employee.getGmail(),employee.getContactNo(),employee.getNic(),employee.getAddress(),employee.getPosition(),employee.getDate(),employee.getBankAccountNum(),employee.getBankBranchName(),employee.getAge(),employee.getGendar(),employee.getImage(),employee.getEmpAttendanceID());

        return employeeDAO.save(employeeEnt);
    }

    @Override
    public EmployeeDto allEmployeeDetailsBO(String empId) throws SQLException, ClassNotFoundException {
        Employee employee = employeeDAO.allEmployeeDetails(empId);
        EmployeeDto employeeDto = new EmployeeDto(employee.getEmp_id(),employee.getName(),employee.getGmail(),employee.getContactNo(),employee.getNic(),employee.getAddress(),employee.getPosition(),employee.getDate(),employee.getBankAccountNum(),employee.getBankBranchName(),employee.getAge(),employee.getGendar(),employee.getImage(),employee.getEmpAttendanceID());
        return employeeDto;

    }

    @Override
    public List<EmployeeDto> getAllEmployeeBO() throws SQLException, ClassNotFoundException {
       List<Employee> employees = employeeDAO.getAll();
        ArrayList<EmployeeDto> employeeDtos = new ArrayList<>();

        for (Employee employee:employees){
            employeeDtos.add(new EmployeeDto(employee.getEmp_id(),employee.getName(),employee.getGmail(),employee.getContactNo(),employee.getNic(),employee.getAddress(),employee.getPosition(),employee.getDate(),employee.getBankAccountNum(),employee.getBankBranchName(),employee.getAge(),employee.getGendar(),employee.getImage(),employee.getEmpAttendanceID()));

        }

        return employeeDtos;
    }

    @Override
    public int howMachEmployeeBO() throws SQLException, ClassNotFoundException {
       return employeeDAO.howMach();
    }

    @Override
    public boolean updateEmployeeBO(EmployeeDto employee) throws SQLException, ClassNotFoundException {
        Employee employeeEnt = new Employee(employee.getEmp_id(),employee.getName(),employee.getGmail(),employee.getContactNo(),employee.getNic(),employee.getAddress(),employee.getPosition(),employee.getDate(),employee.getBankAccountNum(),employee.getBankBranchName(),employee.getAge(),employee.getGendar(),employee.getImage(),employee.getEmpAttendanceID());

        return employeeDAO.update(employeeEnt);
    }

    @Override
    public EmployeeDto searchEmployeeBO(String empId) throws SQLException, ClassNotFoundException {
        Employee employee = employeeDAO.search(empId);
        EmployeeDto employeeDto = new EmployeeDto(employee.getEmp_id(),employee.getName(),employee.getGmail(),employee.getContactNo(),employee.getNic(),employee.getAddress(),employee.getPosition(),employee.getDate(),employee.getBankAccountNum(),employee.getBankBranchName(),employee.getAge(),employee.getGendar(),employee.getImage(),employee.getEmpAttendanceID());
        return employeeDto;
    }

    @Override
    public byte[] imagenToByte(Image image) {
        return employeeDAO.imagenToByte(image);
    }

    @Override
    public Image convertBytesToJavaFXImageBO(byte[] image) {
        return employeeDAO.convertBytesToJavaFXImage(image);
    }
}
