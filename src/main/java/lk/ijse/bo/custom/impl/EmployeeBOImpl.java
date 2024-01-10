package lk.ijse.bo.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    ;
    public EmployeeDto loardEmpValuesDetails(String aId) throws SQLException {
        return employeeDAO.loardEmpValues(aId);
    }

    public boolean saveEmployeeBO(EmployeeDto emp) throws SQLException, ClassNotFoundException {
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

    public boolean updateEmployeeBO(EmployeeDto emp) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(emp);
    }

    public EmployeeDto searchEmployeeBO(String empId) throws SQLException, ClassNotFoundException {
       return employeeDAO.search(empId);
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
