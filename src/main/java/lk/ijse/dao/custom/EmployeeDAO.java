package lk.ijse.dao.custom;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.EmployeeDto;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeDAO extends CrudDAO<EmployeeDto> {

   // Image convertBytesToJavaFXImage(byte[] imageData);
   // public byte[] imagenToByte(Image imgId);
  //  public boolean save(EmployeeDto emp) throws SQLException;
   // public EmployeeDto searchEmployee(String empId) throws SQLException;
   // public boolean update(EmployeeDto emp) throws SQLException;
    public EmployeeDto allEmployeeDetails(String empId) throws SQLException;
    public List<EmployeeDto> getAll() throws SQLException;

    public EmployeeDto loardEmpValues(String aId) throws SQLException;

   // public int howMachEmployee() throws SQLException;
}
