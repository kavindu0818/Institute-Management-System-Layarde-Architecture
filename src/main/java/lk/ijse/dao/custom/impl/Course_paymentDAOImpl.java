package lk.ijse.dao.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.CfdDto;
import lk.ijse.dto.CoursePaymentJoinDto;
import lk.ijse.entity.Cfd;
import lk.ijse.entity.CoursePaymentJoin;
import lk.ijse.entity.StudentfullDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Course_paymentDAOImpl implements Course_PaymentDAO {
   @Override
    public  boolean savePayment(String payId, double amount, String cusDfull, String stuID) throws SQLException, ClassNotFoundException {

        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        java.sql.Timestamp sqltime = new java.sql.Timestamp(date.getTime());

        String sTime = String.valueOf(sqltime);
        String sDate = String.valueOf(sqldate);

        return SQLUtil.execute("INSERT INTO course_payment VALUES(?, ?,?,?,?,?)",payId,amount,sDate,sTime,cusDfull,stuID);
    }

    @Override
    public int generateNextCourseFeeId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT coursePayment_Id FROM course_payment ORDER BY coursePayment_Id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            return splitOrderId(Integer.parseInt(resultSet.getString(1)));
        }
        return splitOrderId(0);
    }

  @Override
    public int splitOrderId(int id) {
        if (id == 0) {
            return 1;
        }
        return ++id;

    }

    @Override
    public boolean save(CoursePaymentJoin dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public CoursePaymentJoin search(String id) throws SQLException, ClassNotFoundException {
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
    public boolean update(CoursePaymentJoin dto) throws SQLException, ClassNotFoundException {
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
    public CoursePaymentJoin getClassMailValue(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}

