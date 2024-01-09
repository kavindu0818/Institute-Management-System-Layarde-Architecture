package lk.ijse.dao.custom;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import lk.ijse.dao.SuperDAO;
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

public interface UserDAO extends SuperDAO {

    public boolean setUserDetails(UserDto ud) throws SQLException, ClassNotFoundException;
    public UserDto selectUserValue() throws SQLException, ClassNotFoundException;
    public UserDto getUserValue(String pw) throws SQLException, ClassNotFoundException;

    Image convertBytesToJavaFXImage(byte[] imageData);
    public boolean updateUser(UserDto up) throws SQLException, ClassNotFoundException;
    public UserDto getUserValueUser(String us) throws SQLException, ClassNotFoundException;
}
