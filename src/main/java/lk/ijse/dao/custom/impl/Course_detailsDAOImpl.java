package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.Course_DetailsDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.Course_detailsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static lk.ijse.Controller.Payment.CourseFeeFormController.ORDER_ID_PREFIX;

public class Course_detailsDAOImpl implements Course_DetailsDAO {
    public boolean upateAmount(double amont, String studentId) throws SQLException, ClassNotFoundException {
//        System.out.println(amont + studentId);
//        Connection connection = DbConnection.getInstance().getConnection();
//        String bsql = "UPDATE course_details SET paidCou_fee = (paidCou_fee - ?) WHERE cusDfull_id = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(bsql);
//        preparedStatement.setDouble(1, amont);
//        preparedStatement.setString(2, studentId);
        ;

        return SQLUtil.execute("UPDATE course_details SET paidCou_fee = (paidCou_fee - ?) WHERE cusDfull_id = ?",amont,studentId);

    }

    public Course_detailsDto getAllValuesCd(String a) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM course_details WHERE stu_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, a);
        ResultSet resultSet =SQLUtil.execute("SELECT * FROM course_details WHERE stu_id = ?",a); //pstm.executeQuery();

        Course_detailsDto dto = null;
        if (resultSet.next()) {
            String cusDfull = resultSet.getString(1);
            String cusdId = resultSet.getString(2);
            String stuId = resultSet.getString(3);
            String stuName = resultSet.getString(4);
            String cusName = resultSet.getString(5);
            double paidCusFee = resultSet.getDouble(6);

            dto = new Course_detailsDto(cusDfull, cusdId, stuId, stuName, cusName, paidCusFee);
        }
        return dto;

    }

    public List<Course_detailsDto> getAllCourseValue(String sd) throws SQLException, ClassNotFoundException {
//        System.out.println(sd);
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT *FROM course_details WHERE cus_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, sd);
        ResultSet resultSet =SQLUtil.execute("SELECT *FROM course_details WHERE cus_id = ?",sd); //pstm.executeQuery();
        System.out.println(resultSet.toString());

        ArrayList<Course_detailsDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {

            dtoList.add(
                    new Course_detailsDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getDouble(6)
                    )
            );
        }
        System.out.println(dtoList.toString());
        return dtoList;

    }


    public boolean saveCourseDetails(String paymentID,String courseId,String stuId,String stuName, String courseName, Double amount) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//    String sql = "INSERT INTO course_details VALUES(?,?,?,?,?,?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1,paymentID );
//        pstm.setString(2, courseId);
//        pstm.setString(3, stuId);
//        pstm.setString(4, stuName);
//        pstm.setString(5, courseName);
//        pstm.setDouble(6, amount);
//
//        boolean isSaved = pstm.executeUpdate() > 0;

        return SQLUtil.execute("INSERT INTO course_details VALUES(?,?,?,?,?,?)",paymentID,courseId,stuId,stuName,courseName,amount);
    }


    public List<Course_detailsDto> getCourseDetailsID(String a) throws SQLException, ClassNotFoundException {
//            Connection connection = DbConnection.getInstance().getConnection();
//
//            String sql = "SELECT * FROM course_details WHERE stu_id = ?";
//            PreparedStatement pstm = connection.prepareStatement(sql);
//            pstm.setString(1, a);
            ResultSet resultSet =SQLUtil.execute("SELECT * FROM course_details WHERE stu_id = ?",a); //pstm.executeQuery();

        ArrayList<Course_detailsDto> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new Course_detailsDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getDouble(6)

                    )
            );
        }
        return dtoList;
    }

    public Course_detailsDto courseName(String cf) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM course_details WHERE cusDfull_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, cf);
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM course_details WHERE cusDfull_id = ?",cf); //pstm.executeQuery();

        Course_detailsDto dto = null;
        if (resultSet.next()) {
            String cusDfull = resultSet.getString(1);
            String cusdId = resultSet.getString(2);
            String stuId = resultSet.getString(3);
            String stuName = resultSet.getString(4);
            String cusName = resultSet.getString(5);
            double paidCusFee = resultSet.getDouble(6);

            dto = new Course_detailsDto(cusDfull, cusdId, stuId, stuName, cusName, paidCusFee);
        }
        return dto;


    }

    public Course_detailsDto getAllDetails(String id, String cusID) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM course_details WHERE stu_id = ? AND cus_id=? ";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, id);
//        pstm.setString(2, cusID);
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM course_details WHERE stu_id = ? AND cus_id=? ",id,cusID);//pstm.executeQuery();

        Course_detailsDto dto = null;
        if (resultSet.next()) {
            String cusDfull = resultSet.getString(1);
            String cusdId = resultSet.getString(2);
            String stuId = resultSet.getString(3);
            String stuName = resultSet.getString(4);
            String cusName = resultSet.getString(5);
            double paidCusFee = resultSet.getDouble(6);

            dto = new Course_detailsDto(cusDfull, cusdId, stuId, stuName, cusName, paidCusFee);
        }
        return dto;



    }

    public Course_detailsDto getsendMailValue(String csId) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM course_details WHERE cusDfull_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, csId);

        ResultSet resultSet =SQLUtil.execute("SELECT * FROM course_details WHERE cusDfull_id = ?",csId); //pstm.executeQuery();

        Course_detailsDto dto = null;
        if (resultSet.next()) {
            String cusDfull = resultSet.getString(1);
            String cusdId = resultSet.getString(2);
            String stuId = resultSet.getString(3);
            String stuName = resultSet.getString(4);
            String cusName = resultSet.getString(5);
            double paidCusFee = resultSet.getDouble(6);

            dto = new Course_detailsDto(cusDfull, cusdId, stuId, stuName, cusName, paidCusFee);
        }
        return dto;

    }
}

