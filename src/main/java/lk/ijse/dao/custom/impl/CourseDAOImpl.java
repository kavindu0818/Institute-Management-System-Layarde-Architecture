package lk.ijse.dao.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.CourseDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.CourseDto;
import lk.ijse.entity.Course;
import lk.ijse.entity.StudentfullDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public boolean saveCourseDetails(String courseID, String courseName, String courseFeee, String courseDuration, String date) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute( "INSERT INTO course VALUES(?,?,?,?,?)",courseID,courseName,courseFeee,date,courseDuration);
    }

    @Override
    public List<Course> getAllcourse() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT *FROM course "); //pstm.executeQuery();


        ArrayList<Course> dtoList = new ArrayList<>();
        // ClassDto dto = null;

        while (resultSet.next()) {
            dtoList.add(
                    new Course(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5)


                    )
            );
        }
        return dtoList;
    }

    @Override
    public List<Course> getCourseID() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT *FROM course ");//pstm.executeQuery();


        ArrayList<Course> dtoList = new ArrayList<>();
        // ClassDto dto = null;

        while (resultSet.next()) {
            dtoList.add(
                    new Course(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5)


                    )
            );
        }
        return dtoList;
    }

    @Override
    public List<Course> getAllcourseID() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT *FROM course "); //pstm.executeQuery();


        ArrayList<Course> dtoList = new ArrayList<>();
        // ClassDto dto = null;

        while (resultSet.next()) {
            dtoList.add(
                    new Course(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5)


                    )
            );
        }
        return dtoList;
    }

    @Override
    public boolean save(Course dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Course search(String id) throws SQLException, ClassNotFoundException {
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
    public boolean update(Course dto) throws SQLException, ClassNotFoundException {
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
    public Course getClassMailValue(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}


