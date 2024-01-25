package lk.ijse.dao.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.Course_DetailsDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.Course_detailsDto;
import lk.ijse.entity.Course_details;
import lk.ijse.entity.StudentfullDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static lk.ijse.Controller.Payment.CourseFeeFormController.ORDER_ID_PREFIX;

public class Course_detailsDAOImpl implements Course_DetailsDAO {

    @Override
    public boolean upateAmount(double amont, String studentId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE course_details SET paidCou_fee = (paidCou_fee - ?) WHERE cusDfull_id = ?",amont,studentId);

    }

    @Override
    public Course_details getAllValuesCd(String a) throws SQLException, ClassNotFoundException {

        ResultSet resultSet =SQLUtil.execute("SELECT * FROM course_details WHERE stu_id = ?",a); //pstm.executeQuery();

        Course_details dto = null;
        if (resultSet.next()) {
            String cusDfull = resultSet.getString(1);
            String cusdId = resultSet.getString(2);
            String stuId = resultSet.getString(3);
            String stuName = resultSet.getString(4);
            String cusName = resultSet.getString(5);
            double paidCusFee = resultSet.getDouble(6);

            dto = new Course_details(cusDfull, cusdId, stuId, stuName, cusName, paidCusFee);
        }
        return dto;

    }

    @Override
    public List<Course_details> getAllCourseValue(String sd) throws SQLException, ClassNotFoundException {

        ResultSet resultSet =SQLUtil.execute("SELECT *FROM course_details WHERE cus_id = ?",sd); //pstm.executeQuery();
        System.out.println(resultSet.toString());

        ArrayList<Course_details> dtoList = new ArrayList<>();

        while (resultSet.next()) {

            dtoList.add(
                    new Course_details(
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


    @Override
    public boolean saveCourseDetails(String paymentID,String courseId,String stuId,String stuName, String courseName, Double amount) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO course_details VALUES(?,?,?,?,?,?)",paymentID,courseId,stuId,stuName,courseName,amount);
    }


    @Override
    public List<Course_details> getCourseDetailsID(String a) throws SQLException, ClassNotFoundException {

            ResultSet resultSet =SQLUtil.execute("SELECT * FROM course_details WHERE stu_id = ?",a); //pstm.executeQuery();

        ArrayList<Course_details> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new Course_details(
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

    @Override
    public Course_details courseName(String cf) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM course_details WHERE cusDfull_id = ?",cf); //pstm.executeQuery();

        Course_details dto = null;
        if (resultSet.next()) {
            String cusDfull = resultSet.getString(1);
            String cusdId = resultSet.getString(2);
            String stuId = resultSet.getString(3);
            String stuName = resultSet.getString(4);
            String cusName = resultSet.getString(5);
            double paidCusFee = resultSet.getDouble(6);

            dto = new Course_details(cusDfull, cusdId, stuId, stuName, cusName, paidCusFee);
        }
        return dto;


    }

    @Override
    public Course_details getAllDetails(String id, String cusID) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM course_details WHERE stu_id = ? AND cus_id=? ",id,cusID);//pstm.executeQuery();

        Course_details dto = null;
        if (resultSet.next()) {
            String cusDfull = resultSet.getString(1);
            String cusdId = resultSet.getString(2);
            String stuId = resultSet.getString(3);
            String stuName = resultSet.getString(4);
            String cusName = resultSet.getString(5);
            double paidCusFee = resultSet.getDouble(6);

            dto = new Course_details(cusDfull, cusdId, stuId, stuName, cusName, paidCusFee);
        }
        return dto;



    }

    @Override
    public Course_details getsendMailValue(String csId) throws SQLException, ClassNotFoundException {


        ResultSet resultSet =SQLUtil.execute("SELECT * FROM course_details WHERE cusDfull_id = ?",csId); //pstm.executeQuery();

        Course_details dto = null;
        if (resultSet.next()) {
            String cusDfull = resultSet.getString(1);
            String cusdId = resultSet.getString(2);
            String stuId = resultSet.getString(3);
            String stuName = resultSet.getString(4);
            String cusName = resultSet.getString(5);
            double paidCusFee = resultSet.getDouble(6);

            dto = new Course_details(cusDfull, cusdId, stuId, stuName, cusName, paidCusFee);
        }
        return dto;

    }

    @Override
    public boolean save(Course_details dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Course_details search(String id) throws SQLException, ClassNotFoundException {
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
    public boolean update(Course_details dto) throws SQLException, ClassNotFoundException {
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
    public Course_details getClassMailValue(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}

