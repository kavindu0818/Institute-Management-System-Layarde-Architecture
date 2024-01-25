package lk.ijse.bo.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dao.custom.impl.UserDAOImpl;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;

import java.sql.SQLException;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public UserDto selectUserValueBo() throws SQLException, ClassNotFoundException {
        User user = userDAO.selectUserValue();
        UserDto userDto = new UserDto(user.getUserID(),user.getPassword(),user.getUserName(),user.getImage());

        return userDto;
    }

    @Override
   public UserDto getUserValueUserBO(String us) throws SQLException, ClassNotFoundException {
       User user =userDAO.getUserValueUser(us);
       UserDto userDto = new UserDto(user.getUserID(),user.getPassword(),user.getUserName(),user.getImage());

       return userDto;
    }

    @Override
   public Image convertBytesToJavaFXImageBO(byte[] image){
        return userDAO.convertBytesToJavaFXImage(image);
    }
}
