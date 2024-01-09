package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.DaySheduleBO;
import lk.ijse.dao.custom.impl.DaySheduleDAOImpl;
import lk.ijse.dto.DaySheduleDto;

import java.sql.SQLException;
import java.util.List;

public class DaySheduleBoImpl implements DaySheduleBO {

    DaySheduleDAOImpl daySheduleDAO = new DaySheduleDAOImpl();
    public List<DaySheduleDto> getAllShedulBO() throws SQLException, ClassNotFoundException {
       return daySheduleDAO.getAllShedul();
    }

    public boolean saveValuesBO(DaySheduleDto day) throws SQLException, ClassNotFoundException {
       return daySheduleDAO.saveValues(day);
    }
}
