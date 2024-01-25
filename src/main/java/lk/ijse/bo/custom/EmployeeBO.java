package lk.ijse.bo.custom;

import javafx.scene.image.Image;
import lk.ijse.bo.SuperBO;
import lk.ijse.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {

    public EmployeeDto loardEmpValuesDetails(String aId) throws SQLException, ClassNotFoundException;

    public boolean saveEmployeeBO(EmployeeDto emp) throws SQLException, ClassNotFoundException;

    public EmployeeDto allEmployeeDetailsBO(String empId) throws SQLException, ClassNotFoundException;

    public List<EmployeeDto> getAllEmployeeBO() throws SQLException, ClassNotFoundException;

    public int howMachEmployeeBO() throws SQLException, ClassNotFoundException;
    public boolean updateEmployeeBO(EmployeeDto emp) throws SQLException, ClassNotFoundException;

    public EmployeeDto searchEmployeeBO(String empId) throws SQLException, ClassNotFoundException;

    byte[] imagenToByte(Image image);

    Image convertBytesToJavaFXImageBO(byte[] image);
}
