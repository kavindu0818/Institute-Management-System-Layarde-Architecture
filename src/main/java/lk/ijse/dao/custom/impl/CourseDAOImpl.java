package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.CourseDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.CourseDto;
import lk.ijse.entity.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    public boolean saveCourseDetails(String courseID, String courseName, String courseFeee, String courseDuration, String date) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "INSERT INTO course VALUES(?,?,?,?,?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, courseID);
//        pstm.setString(2, courseName);
//        pstm.setString(3, courseFeee);
//        pstm.setString(4, date);
//        pstm.setString(5, courseDuration);
//
//        boolean isSaved = pstm.executeUpdate() > 0;

        return SQLUtil.execute( "INSERT INTO course VALUES(?,?,?,?,?)",courseID,courseName,courseFeee,date,courseDuration);
    }

    public List<Course> getAllcourse() throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT *FROM course ";
//        PreparedStatement pstm = connection.prepareStatement(sql);
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

    public List<Course> getCourseID() throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT *FROM course ";
//        PreparedStatement pstm = connection.prepareStatement(sql);
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

    public List<Course> getAllcourseID() throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT *FROM course ";
//        PreparedStatement pstm = connection.prepareStatement(sql);
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

}


