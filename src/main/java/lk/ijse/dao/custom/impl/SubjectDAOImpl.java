package lk.ijse.dao.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.SubjectDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.SubjectDto;
import lk.ijse.entity.StudentfullDetails;
import lk.ijse.entity.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {

    @Override
    public boolean subSave(SubjectDto sub) throws SQLException, ClassNotFoundException {

       return SQLUtil.execute( "INSERT INTO subject VALUES(?,?)",sub.getSub_id(),sub.getSubjectName());
    }

    @Override
    public List<Subject> getSubject() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT *FROM subject");//pstm.executeQuery();


        ArrayList<Subject> dtoList = new ArrayList<>();
        // ClassDto dto = null;

        while(resultSet.next()) {
            dtoList.add(
                    new Subject(
                            resultSet.getString(1),
                            resultSet.getString(2)


                    )
            );
        }
        return dtoList;
    }

    @Override
    public boolean save(Subject dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Subject search(String id) throws SQLException, ClassNotFoundException {
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
    public boolean update(Subject dto) throws SQLException, ClassNotFoundException {
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
    public Subject getClassMailValue(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
