package lk.ijse.dao.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.DaySheduleDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.DaySheduleDto;
import lk.ijse.entity.DayShedule;
import lk.ijse.entity.StudentfullDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaySheduleDAOImpl implements DaySheduleDAO {

    @Override
    public boolean saveValues(DayShedule day) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO dayshedule VALUES(?,?,?,?)",day.getClassName(),day.getDate(),day.getStime(),day.getETime());
    }

    public List<DayShedule> getAllShedul() throws SQLException, ClassNotFoundException {
        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        java.sql.Timestamp sqltime = new java.sql.Timestamp(date.getTime());

        String sDate = String.valueOf(sqldate);

        ResultSet resultSet = SQLUtil.execute( "SELECT * FROM dayshedule WHERE Date = ?",sDate); //pstm.executeQuery();

        ArrayList<DayShedule> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new DayShedule(
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
    public boolean save(DayShedule dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public DayShedule search(String id) throws SQLException, ClassNotFoundException {
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
    public boolean update(DayShedule dto) throws SQLException, ClassNotFoundException {
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
    public DayShedule getClassMailValue(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
