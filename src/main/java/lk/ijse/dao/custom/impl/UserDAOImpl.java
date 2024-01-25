package lk.ijse.dao.custom.impl;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.StudentfullDetails;
import lk.ijse.entity.User;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean setUserDetails(UserDto ud) throws SQLException, ClassNotFoundException {

        byte[] imageSr = ud.getImage();
       // pstm.setBytes(4, imageSr);

        return SQLUtil.execute("INSERT INTO user VALUES(?, ?, ?,?)",ud.getUserID(),ud.getPassword(),ud.getUserName(),imageSr);
    }

    @Override
    public User selectUserValue() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT *FROM user"); //pstm.executeQuery();

        User dto = null;

        if (resultSet.next()) {
            String userID = resultSet.getString(1);
            String password = resultSet.getString(2);
            String userName = resultSet.getString(3);
            byte[] imageBytes = resultSet.getBytes(4);


            dto = new User(userID,password, userName, imageBytes);
        }
        return dto;
    }

    @Override
    public UserDto getUserValue(String pw) throws SQLException, ClassNotFoundException {

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

    @Override
    public boolean save(User dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public User search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public byte[] imagenToByte(Image imgId) {
        return new byte[0];
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

    @Override
    public boolean update(User dto) throws SQLException, ClassNotFoundException {
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
    public User getClassMailValue(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    public boolean updateUser(UserDto up) throws SQLException, ClassNotFoundException {

        byte[] imageSr = up.getImage();

        return SQLUtil.execute("UPDATE User SET userName=?, image=?, password=? WHERE userID=?",up.getUserName(),imageSr,up.getPassword(),up.getUserID());//pstm.executeUpdate() > 0;

    }



    public User getUserValueUser(String us) throws SQLException, ClassNotFoundException {

        ResultSet resultSet =SQLUtil.execute("SELECT *FROM user WHERE password=?",us);

        User dto = null;

        if (resultSet.next()) {
            String userID = resultSet.getString(1);
            String password = resultSet.getString(2);
            String userName= resultSet.getString(3);
            byte[] imageBytes = resultSet.getBytes(4);


            dto = new User(userID,password,userName,imageBytes);
        }
        return dto;

    }
}
