package lk.ijse.bo.custom;

import javafx.scene.image.Image;
import lk.ijse.bo.SuperBO;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;

public interface UserBO extends SuperBO {
    UserDto selectUserValueBo() throws SQLException, ClassNotFoundException;

    UserDto getUserValueUserBO(String us) throws SQLException, ClassNotFoundException;

    Image convertBytesToJavaFXImageBO(byte[] image);
}
