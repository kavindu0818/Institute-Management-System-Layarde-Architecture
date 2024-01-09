package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.custom.impl.UserDAOImpl;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;

public class UserBOImpl implements UserBO {

    UserDAOImpl userDAO = new UserDAOImpl();
    public UserDto selectUserValueBo() throws SQLException, ClassNotFoundException {
       return userDAO.selectUserValue();
    }
}
