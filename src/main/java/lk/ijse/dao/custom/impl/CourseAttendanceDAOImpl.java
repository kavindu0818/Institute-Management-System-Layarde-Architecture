package lk.ijse.dao.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.CourseAttendanceDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.entity.AttendanceJoin;
import lk.ijse.entity.CourseAttendanceJoin;
import lk.ijse.entity.CourseAttendanceStuDetailsJoin;
import lk.ijse.entity.StudentfullDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseAttendanceDAOImpl implements CourseAttendanceDAO {

    @Override
    public boolean saveAttendnceDetails(String aId, String num1) throws SQLException, ClassNotFoundException {

        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        java.sql.Timestamp sqltime = new java.sql.Timestamp(date.getTime());

        String sTime = String.valueOf(sqltime);
        String sDate= String.valueOf(sqldate);


        return SQLUtil.execute("INSERT INTO course_attendance VALUES(?, ?, ?, ?)",num1,aId,sDate,sTime);
    }

    @Override
    public int generateNextOrderId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT attendanceID FROM course_attendance ORDER BY attendanceID DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            return splitOrderId(Integer.parseInt(resultSet.getString(1)));
        }
        return splitOrderId(0001);
    }


@Override
    public int splitOrderId(int id) {
        if (id == 0) {
            return 1;
        }
        return ++id;


    }


        @Override
    public int howMachCourseStudent() throws SQLException, ClassNotFoundException {

        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());

        ResultSet resultSet =SQLUtil.execute("SELECT count(attendanceID) FROM course_attendance WHERE date=?", sqldate); //pstm.executeQuery();

        int a = 0;

        if (resultSet.next()){
            return resultSet.getInt(1);

        }
        return 0;

    }


    @Override
    public boolean save(CourseAttendanceJoin dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public CourseAttendanceJoin search(String id) throws SQLException, ClassNotFoundException {
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
    public boolean update(CourseAttendanceJoin dto) throws SQLException, ClassNotFoundException {
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
    public CourseAttendanceJoin getClassMailValue(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}





