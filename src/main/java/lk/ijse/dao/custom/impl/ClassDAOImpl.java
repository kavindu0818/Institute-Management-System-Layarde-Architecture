package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.ClassDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.ClassDto;
import lk.ijse.entity.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAOImpl implements ClassDAO {

    public List<Class> getAllClass() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT *FROM class ");//pstm.executeQuery();


        ArrayList<Class> dtoList = new ArrayList<>();
       // ClassDto dto = null;

        while(resultSet.next()) {
            dtoList.add(
                    new Class(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3)

                    )
            );
        }
        return dtoList;
    }


    public List<ClassDto> getAllStudent() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT *FROM class ";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();


        ArrayList<ClassDto> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new ClassDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3)

                    )
            );
        }
        return dtoList;
    }

    public boolean saveCoursesClass(String courseID, String courseName, String tutor) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO class VALUES(?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,courseID);
        pstm.setString(2,courseName);
        pstm.setString(3,tutor);


        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

    public boolean saveCoursesClass(Class cd) throws SQLException, ClassNotFoundException {


            return SQLUtil.execute("INSERT INTO class VALUES(?,?,?)",cd.getClass_id(),cd.getTut_id(),cd.getClassName());
        }


    public boolean classSave(Class cms) throws SQLException, ClassNotFoundException {


        return SQLUtil.execute("INSERT INTO class VALUES(?,?,?)",cms.getClass_id(), cms.getTut_id(), cms.getClassName());
    }
}
