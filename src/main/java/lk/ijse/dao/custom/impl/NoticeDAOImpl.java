package lk.ijse.dao.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.NoticeDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.NoticeDto;
import lk.ijse.entity.Notice;
import lk.ijse.entity.StudentfullDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeDAOImpl implements NoticeDAO {
   @Override
    public boolean setNotice(NoticeDto nd) throws SQLException, ClassNotFoundException {
        Date date = Date.valueOf(nd.getDate());

        return SQLUtil.execute("INSERT INTO notice VALUES(?,?)",nd.getNote(),date); //preparedStatement.executeUpdate() > 0;
    }

    @Override
    public List<Notice> getAllNotice() throws SQLException, ClassNotFoundException {
        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        java.sql.Timestamp sqltime = new java.sql.Timestamp(date.getTime());

        String da = String.valueOf(sqldate);
        ResultSet resultSet = SQLUtil.execute( "SELECT * FROM notice WHERE date = ?",da); //pstm.executeQuery();

        ArrayList<Notice> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new Notice(
                            resultSet.getString(1),
                            resultSet.getString(2)


                    )
            );
        }
        return dtoList;

    }

    @Override
    public boolean save(Notice dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Notice search(String id) throws SQLException, ClassNotFoundException {
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
    public boolean update(Notice dto) throws SQLException, ClassNotFoundException {
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
    public Notice getClassMailValue(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
