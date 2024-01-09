package lk.ijse.dao.custom.impl;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.UserDto;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    public boolean setUserDetails(UserDto ud) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "INSERT INTO user VALUES(?, ?, ?,?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1, ud.getUserID());
//        pstm.setString(2, ud.getPassword());
//        pstm.setString(3, ud.getUserName());

        byte[] imageSr = ud.getImage();
       // pstm.setBytes(4, imageSr);

        return SQLUtil.execute("INSERT INTO user VALUES(?, ?, ?,?)",ud.getUserID(),ud.getPassword(),ud.getUserName(),imageSr);
    }

    public UserDto selectUserValue() throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = " SELECT *FROM user ";
//        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = SQLUtil.execute("SELECT *FROM user"); //pstm.executeQuery();

        UserDto dto = null;

        if (resultSet.next()) {
            String userID = resultSet.getString(1);
            String password = resultSet.getString(2);
            String userName = resultSet.getString(3);
            byte[] imageBytes = resultSet.getBytes(4);


            dto = new UserDto(userID,password, userName, imageBytes);
        }
        return dto;
    }

    public UserDto getUserValue(String pw) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = " SELECT *FROM user WHERE userID=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1,pw);
        ResultSet resultSet =SQLUtil.execute("SELECT *FROM user WHERE userID=?",pw); //pstm.executeQuery();

        UserDto dto = null;

        if (resultSet.next()) {
            String userID = resultSet.getString(1);
            String password = resultSet.getString(2);
            String userName= resultSet.getString(3);
            byte[] imageBytes = resultSet.getBytes(4);


            dto = new UserDto(userID,password,userName,imageBytes);
        }
        return dto;

    }
    public  Image convertBytesToJavaFXImage(byte[] imageData) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
            BufferedImage bufferedImage = ImageIO.read(bis);
            return SwingFXUtils.toFXImage(bufferedImage, null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateUser(UserDto up) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//
//        String sql ="UPDATE User SET userName=?, image=?, password=? WHERE userID=?";
//
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//
//        pstm.setString(1,up.getUserName());

        byte[] imageSr = up.getImage();
//        pstm.setBytes(2, imageSr);
//
//        pstm.setString(3, up.getPassword());
//        pstm.setString(4, up.getUserID());

        return SQLUtil.execute("UPDATE User SET userName=?, image=?, password=? WHERE userID=?",up.getUserName(),imageSr,up.getPassword(),up.getUserID());//pstm.executeUpdate() > 0;

    }



    public UserDto getUserValueUser(String us) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = " SELECT *FROM user WHERE password=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1,us);
        ResultSet resultSet =SQLUtil.execute("SELECT *FROM user WHERE password=?",us);

        UserDto dto = null;

        if (resultSet.next()) {
            String userID = resultSet.getString(1);
            String password = resultSet.getString(2);
            String userName= resultSet.getString(3);
            byte[] imageBytes = resultSet.getBytes(4);


            dto = new UserDto(userID,password,userName,imageBytes);
        }
        return dto;

    }
}
