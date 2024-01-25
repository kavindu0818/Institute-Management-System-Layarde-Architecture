package lk.ijse.dao.custom.impl;


import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.StudentAttendanceDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.Class_DetailsDto;
import lk.ijse.dto.StudentAttendance;
import lk.ijse.entity.StudentfullDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Stu_AttendanceDAOImpl implements StudentAttendanceDAO {

@Override
    public boolean saveAttendnceDetails(Class_DetailsDto dtoList) throws SQLException, ClassNotFoundException {

        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        java.sql.Timestamp sqltime = new java.sql.Timestamp(date.getTime());

        String da = String.valueOf(sqldate);
        String time = String.valueOf(sqltime);


        return SQLUtil.execute("INSERT INTO stu_attendance VALUES(?, ?, ?, ?,?,?)",dtoList.getStu_name(),da,dtoList.getFull_id(),dtoList.getStu_id(),dtoList.getClass_id(),time);
    }

@Override
    public List<StudentAttendance> getAllStudent() throws SQLException, ClassNotFoundException {

        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        java.sql.Timestamp sqltime = new java.sql.Timestamp(date.getTime());

        String da = String.valueOf(sqldate);

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM stu_attendance WHERE date = ?",da); //pstm.executeQuery();

        ArrayList<StudentAttendance> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new StudentAttendance(
                            resultSet.getString(1),
                            resultSet.getDate(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
        return dtoList;

    }

    @Override
    public List<StudentAttendance> getClassStudent(String clId, LocalDate classDate) throws SQLException, ClassNotFoundException {


        String da = String.valueOf(classDate);
        ResultSet resultSet =SQLUtil.execute("SELECT * FROM stu_attendance WHERE class_id = ? AND date = ?",clId,da); //pstm.executeQuery();

        ArrayList<StudentAttendance> dtoList = new ArrayList<>();
        while(resultSet.next()) {
            dtoList.add(
                    new StudentAttendance(
                            resultSet.getString(1),
                            resultSet.getDate(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
            return dtoList;
    }

    @Override
    public List<StudentAttendance> getStudentAllAttendnce(String iD) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM stu_attendance WHERE stu_id =?",iD);//pstm.executeQuery();

        ArrayList<StudentAttendance> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new StudentAttendance(
                            resultSet.getString(1),
                            resultSet.getDate(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
        return dtoList;

    }

    @Override
    public int howMachStudent() throws SQLException, ClassNotFoundException {
       Connection connection = DbConnection.getInstance().getConnection();

        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());

        ResultSet resultSet = SQLUtil.execute("SELECT count(stu_id) FROM stu_attendance WHERE date=?", sqldate);//pstm.executeQuery();//SQLUtil.execute("select count(stu_id) from stu_attendance WHERE date=?",da); //pstm.executeQuery();

        int a;

        if (resultSet.next()){
            return resultSet.getInt(1);

        }
        return 0;

    }


    @Override
    public boolean save(StudentAttendance dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public StudentAttendance search(String id) throws SQLException, ClassNotFoundException {
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
    public boolean update(StudentAttendance dto) throws SQLException, ClassNotFoundException {
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
    public StudentAttendance getClassMailValue(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}

