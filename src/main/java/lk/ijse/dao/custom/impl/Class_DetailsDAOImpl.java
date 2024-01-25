package lk.ijse.dao.custom.impl;


import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.ClassDetailsDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.Class_DetailsDto;
import lk.ijse.entity.Class_Details;
import lk.ijse.entity.StudentfullDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Class_DetailsDAOImpl implements ClassDetailsDAO {


    @Override
    public Class_Details loardValues(String aId) throws SQLException, ClassNotFoundException {


        ResultSet resultSet = SQLUtil.execute("SELECT * FROM  class_Details WHERE full_id = ?",aId);
        Class_Details dto = null;

        if(resultSet.next()) {
            String fullId = resultSet.getString(1);
            String stuId = resultSet.getString(2);
            String classId = resultSet.getString(3);
            String stuName = resultSet.getString(4);

            dto = new Class_Details(fullId,stuId,classId,stuName);
        }
        return dto;

    }

    @Override
    public List<Class_Details> getFullId(String sID) throws SQLException, ClassNotFoundException {


        ResultSet resultSet = SQLUtil.execute("SELECT * FROM  class_Details WHERE stu_id = ?",sID);//pstm.executeQuery();
        ArrayList<Class_Details> dtoList = new ArrayList<>();
        // ClassDto dto = null;

        while(resultSet.next()) {
            dtoList.add(
                    new Class_Details(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)

                    )
            );
        }
        return dtoList;

    }

    @Override
    public boolean saveClassDetails(Class_Details ad) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO class_details VALUES(?, ?, ?, ?)", ad.getFull_id(),ad.getStu_id(),ad.getClass_id(),ad.getStu_name());

    }

    @Override
    public boolean saveValue(String attendance, String stuId, String classID, String stuName) throws SQLException {
        return false;
    }

    @Override
    public Class_DetailsDto getsendMailValue(String atId) throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public boolean save(Class_Details dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Class_Details search(String id) throws SQLException, ClassNotFoundException {
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
    public boolean update(Class_Details dto) throws SQLException, ClassNotFoundException {
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
    public Class_Details getClassMailValue(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
