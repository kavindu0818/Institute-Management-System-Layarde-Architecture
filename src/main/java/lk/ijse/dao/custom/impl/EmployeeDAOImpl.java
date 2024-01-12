package lk.ijse.dao.custom.impl;


import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.entity.Employee;
import lk.ijse.entity.StudentfullDetails;
import lombok.SneakyThrows;

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

public class EmployeeDAOImpl implements EmployeeDAO {

@Override
    public Image convertBytesToJavaFXImage(byte[] imageData) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
            BufferedImage bufferedImage = ImageIO.read(bis);
            return SwingFXUtils.toFXImage(bufferedImage, null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
@Override
    public byte[] imagenToByte(Image imgId) {
        BufferedImage bufferimage = SwingFXUtils.fromFXImage(imgId, null);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferimage, "jpg", output);
            ImageIO.write(bufferimage, "png", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] data = output.toByteArray();
        return data;
    }

    @Override
    public boolean save(Employee emp) throws SQLException, ClassNotFoundException {

        byte[] imageSr = emp.getImage();


        return SQLUtil.execute("INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)",emp.getEmp_id(),emp.getName(),emp.getGmail(),emp.getContactNo(),emp.getNic(),emp.getAddress(),emp.getPosition(),emp.getDate(),
                emp.getBankAccountNum(),emp.getBankBranchName(),emp.getAge(),emp.getGendar(),imageSr,emp.getEmpAttendanceID());


    }

   @Override
    public Employee search(String empId) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee WHERE emp_id = ?",empId);

        Employee dto = null;

        if (resultSet.next()) {
            String emp_id = resultSet.getString(1);
            String empName = resultSet.getString(2);
            String empGamil = resultSet.getString(3);
            String empContact = resultSet.getString(4);
            String empNic = resultSet.getString(5);
            String empAddress = resultSet.getString(6);
            String empPosition = resultSet.getString(7);
            String empDate = resultSet.getString(8);
            String empBankAccount = resultSet.getString(9);
            String empBankBranch = resultSet.getString(10);
            Integer empAge = resultSet.getInt(11);
            String empGender = resultSet.getString(12);

            byte[] imageBytes = resultSet.getBytes(13);
            String empAttenID = resultSet.getString(14);

            dto = new Employee(emp_id, empName, empGamil, empContact, empNic, empAddress, empPosition, empDate, empBankAccount, empBankBranch,empAge, empGender, imageBytes,empAttenID);
        }
        return dto;
    }

@Override
    public boolean update(Employee emp) throws SQLException, ClassNotFoundException {

            byte[] imageSr = emp.getImage();

            return SQLUtil.execute("UPDATE employee SET name = ?,gmail = ?,contactNo = ?,nic = ?,address =?,position = ?, registrationDate = ?,bankAccountNum =?,bankBranchName =?,age = ?,gendar = ?,image =?,empAttendnceId =? WHERE emp_id = ?",emp.getName(),emp.getGmail(),emp.getContactNo(),emp.getNic(),emp.getAddress(),emp.getPosition(),emp.getDate(),
                    emp.getBankAccountNum(),emp.getBankBranchName(),emp.getAge(),emp.getGendar(),imageSr,emp.getEmpAttendanceID(),emp.getEmp_id());

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<StudentfullDetails> getClassStudent(String iD) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Employee allEmployeeDetails(String empId) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee WHERE emp_id = ?",empId);

        Employee dto = null;

        if (resultSet.next()) {
            String emp_id = resultSet.getString(1);
            String empName = resultSet.getString(2);
            String empGamil = resultSet.getString(3);
            String empContact = resultSet.getString(4);
            String empNic = resultSet.getString(5);
            String empAddress = resultSet.getString(6);
            String empPosition = resultSet.getString(7);
            String empDate = resultSet.getString(8);
            String empBankAccount = resultSet.getString(9);
            String empBankBranch = resultSet.getString(10);
            Integer empAge = resultSet.getInt(11);
            String empGender = resultSet.getString(12);

            byte[] imageBytes = resultSet.getBytes(13);
            String empAttendId = resultSet.getString(14);

            // Image fxImage = convertBytesToJavaFXImage(imageBytes);


            dto = new Employee(emp_id, empName, empGamil, empContact, empNic, empAddress, empPosition, empDate, empBankAccount,  empBankBranch,empAge, empGender, imageBytes,empAttendId
            );
        }
        return dto;


    }


    public List<Employee> getAll() throws SQLException, ClassNotFoundException {


        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee");

        ArrayList<Employee> dtoList = new ArrayList<>();
        while(resultSet.next()) {
            dtoList.add(
                    new Employee(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9),
                            resultSet.getString(10),
                            resultSet.getInt(11),
                            resultSet.getString(12),
                            resultSet.getBytes(13),
                            resultSet.getString(14)
                    )
            );
        }

        return dtoList;
    }


    public Employee loardEmpValues(String aId) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee WHERE empAttendnceId  = ?",aId);

        Employee dto = null;

        if (resultSet.next()) {
            String emp_id = resultSet.getString(1);
            String empName = resultSet.getString(2);
            String empGamil = resultSet.getString(3);
            String empContact = resultSet.getString(4);
            String empNic = resultSet.getString(5);
            String empAddress = resultSet.getString(6);
            String empPosition = resultSet.getString(7);
            String empDate = resultSet.getString(8);
            String empBankAccount = resultSet.getString(9);
            String empBankBranch = resultSet.getString(10);
            Integer empAge = resultSet.getInt(11);
            String empGender = resultSet.getString(12);

            byte[] imageBytes = resultSet.getBytes(13);
            String empAttendId = resultSet.getString(14);

            // Image fxImage = convertBytesToJavaFXImage(imageBytes);

            dto = new Employee(emp_id, empName, empGamil, empContact, empNic, empAddress, empPosition, empDate, empBankAccount,  empBankBranch,empAge, empGender, imageBytes,empAttendId
            );
        }
        return dto;


    }


@Override
    public int howMach() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql ="select count(emp_id) from employee";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        int a = 0;

        if (resultSet.next()){
            return resultSet.getInt(1);

        }
        return 0;

    }

    @Override
    public Employee getClassMailValue(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}


