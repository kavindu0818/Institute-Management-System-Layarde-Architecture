package lk.ijse.dao.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.EmlpoyeeAttendanceDAO;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.EmpAttendnaceDto;
import lk.ijse.dto.EmployeeAttendanceJoin;
import lk.ijse.entity.EmpAttendnace;
import lk.ijse.entity.StudentfullDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAttendanceDAOImpl implements EmlpoyeeAttendanceDAO {

    @Override
    public boolean saveEmpAttendance(String num, String empAttendanceID, String empId) throws SQLException, ClassNotFoundException {
        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        java.sql.Timestamp sqltime = new java.sql.Timestamp(date.getTime());

        String sDate = String.valueOf(sqldate);
        String sTime = String.valueOf(sqltime);


        return SQLUtil.execute( "INSERT INTO employee_attendance VALUES(?, ?, ?, ?,?)", num,empAttendanceID,empId,sDate,sTime);

    }

    @Override
    public int generateNextOrderId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT attendnceID FROM employee_attendance ORDER BY attendnceID DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return splitOrderId(Integer.parseInt(resultSet.getString(1)));
        }
        return splitOrderId(0001);
    }


    private static int splitOrderId(int id) {
        if (id ==0){
            return 1;
        }
        return++id;
    }


    @Override
    public int howMachEmployeeAttendance() throws SQLException, ClassNotFoundException {
       // Connection connection = DbConnection.getInstance().getConnection();

        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());

        ResultSet resultSet = SQLUtil.execute("SELECT count(attendnceID) FROM employee_attendance WHERE Date = ?", sqldate);//pstm.executeQuery();

        int a = 0;

        if (resultSet.next()){
            return resultSet.getInt(1);

        }
        return 0;
    }

    @Override
    public List<EmpAttendnace> getAllEmployeeAttendance(String id) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT *FROM employee_attendance WHERE emp_id=?",id);//pstm.executeQuery();
        ArrayList<EmpAttendnace> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new EmpAttendnace(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDate(4),
                            resultSet.getString(5)

                    )
            );
        }
        return dtoList;

    }

    @Override
    public boolean save(EmployeeAttendanceJoin dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public EmployeeAttendanceJoin search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public byte[] imagenToByte(Image imgId) {
        return new byte[0];
    }

    @Override
    public Image convertBytesToJavaFXImage(byte[] imageData) {
        return null;
    }

    @Override
    public boolean update(EmployeeAttendanceJoin dto) throws SQLException, ClassNotFoundException {
        return false;
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
    public int howMach() throws SQLException {
        return 0;
    }

    @Override
    public EmployeeAttendanceJoin getClassMailValue(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
