package lk.ijse.dao.custom.impl;


import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.TutorDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.TutorDto;
import lk.ijse.entity.StudentfullDetails;
import lk.ijse.entity.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TutorDAOImpl implements TutorDAO {

    @Override
    public int howMachTutor() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute( "SELECT count(tut_id) FROM tutor");//pstm.executeQuery();

        int a = 0;

        if (resultSet.next()) {
            return resultSet.getInt(1);

        }
        return 0;

    }

    @Override
    public boolean saveTutor(Tutor td) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO tutor VALUES(?,?,?)",td.getTut_id(),td.getTutorName(),td.getSub_id());

    }

    @Override
    public Tutor getTutor(String tutId) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT *FROM tutor WHERE tut_id=?", tutId);

        Tutor doList = null;

        if (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String sub = resultSet.getString(3);

            doList = new Tutor(id, name, sub);
        }
        return doList;
    }

    @Override
    public boolean updateTutor(Tutor td) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE tutor SET tutorName=?,sub_id=?  WHERE tut_id=?",td.getTutorName(),td.getSub_id(),td.getTut_id()); //pstm.executeUpdate() > 0;

    }

    @Override
    public boolean save(Tutor dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Tutor search(String id) throws SQLException, ClassNotFoundException {
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
    public boolean update(Tutor dto) throws SQLException, ClassNotFoundException {
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
    public Tutor getClassMailValue(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}

