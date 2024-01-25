package lk.ijse.dao.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.ClassDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.ClassDto;
import lk.ijse.entity.Class;
import lk.ijse.entity.StudentfullDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAOImpl implements ClassDAO {

    @Override
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


    @Override
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

    @Override
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

    @Override
    public boolean saveCoursesClass(Class cd) throws SQLException, ClassNotFoundException {


            return SQLUtil.execute("INSERT INTO class VALUES(?,?,?)",cd.getClass_id(),cd.getTut_id(),cd.getClassName());
        }


        @Override
    public boolean classSave(Class cms) throws SQLException, ClassNotFoundException {


        return SQLUtil.execute("INSERT INTO class VALUES(?,?,?)",cms.getClass_id(), cms.getTut_id(), cms.getClassName());
    }

    @Override
    public boolean save(Class dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Class search(String id) throws SQLException, ClassNotFoundException {
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
    public boolean update(Class dto) throws SQLException, ClassNotFoundException {
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
    public Class getClassMailValue(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
