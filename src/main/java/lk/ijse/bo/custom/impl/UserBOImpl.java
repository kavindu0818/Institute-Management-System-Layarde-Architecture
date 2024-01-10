package lk.ijse.bo.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dao.custom.impl.UserDAOImpl;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public UserDto selectUserValueBo() throws SQLException, ClassNotFoundException {
       return userDAO.selectUserValue();
    }

   public UserDto getUserValueUserBO(String us) throws SQLException, ClassNotFoundException {
       return userDAO.getUserValueUser(us);
    }

   public Image convertBytesToJavaFXImageBO(byte[] image){
        return userDAO.convertBytesToJavaFXImage(image);
    }
}
