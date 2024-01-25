package lk.ijse.dao.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.InstituteDetailsDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.InstitutMangementDto;
import lk.ijse.entity.InstitutMangement;
import lk.ijse.entity.StudentfullDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InstituteDetailsDAOImpl implements InstituteDetailsDAO {
    @Override
    public boolean saveDetails(InstitutMangementDto details) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "INSERT INTO institute_details VALUES(?,?,?,?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1,details.getGmail());
//        pstm.setString(2,details.getContact());
//        pstm.setString(3,details.getFb());
//        pstm.setString(4,details.getHall());
//
//
//        boolean isSaved = pstm.executeUpdate() > 0;

        return SQLUtil.execute("INSERT INTO institute_details VALUES(?,?,?,?)", details.getGmail(),details.getContact(),details.getFb(),details.getHall());
    }

    @Override
    public InstitutMangement allDetails() throws SQLException, ClassNotFoundException {
//            Connection connection = DbConnection.getInstance().getConnection();
//
//            String sql = "SELECT * FROM  institute_details ";
//            PreparedStatement pstm = connection.prepareStatement(sql);

            ResultSet resultSet =SQLUtil.execute( "SELECT * FROM  institute_details "); //pstm.executeQuery();

            InstitutMangement dto = null;

            if (resultSet.next()) {
                String gmail = resultSet.getString(1);
                String contact= resultSet.getString(2);
                String facebook = resultSet.getString(3);
                String hall = resultSet.getString(4);

                dto = new InstitutMangement(gmail, contact, facebook, hall);
            }
            return dto;
        }

        @Override
    public boolean updateSaveDetails(InstitutMangement ui) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "UPDATE institute_details SET gmail=?, contact=?, facebook=?,hall=? WHERE details_No=1";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1, ui.getGmail());
//        pstm.setString(2, ui.getContact());
//        pstm.setString(3, ui.getFb());
//        pstm.setString(4,ui.getHall());


        return SQLUtil.execute("UPDATE institute_details SET gmail=?, contact=?, facebook=?,hall=? WHERE details_No=1", ui.getGmail(),ui.getContact(),ui.getFb(),ui.getHall()); //pstm.executeUpdate() > 0;

    }

    @Override
    public InstitutMangement setAllDetails() throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM  institute_details ";
//        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM  institute_details ");//pstm.executeQuery();

        InstitutMangement dto = null;

        if (resultSet.next()) {
            String gmail = resultSet.getString(1);
            String contact= resultSet.getString(2);
            String facebook = resultSet.getString(3);
            String hall = resultSet.getString(4);

            dto = new InstitutMangement(gmail, contact, facebook, hall);
        }
        return dto;

    }

    @Override
    public boolean save(InstitutMangement dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public InstitutMangement search(String id) throws SQLException, ClassNotFoundException {
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
    public boolean update(InstitutMangement dto) throws SQLException, ClassNotFoundException {
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
    public InstitutMangement getClassMailValue(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}

