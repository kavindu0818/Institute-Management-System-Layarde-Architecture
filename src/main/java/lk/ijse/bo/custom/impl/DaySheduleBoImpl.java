package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.DaySheduleBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.DaySheduleDAO;
import lk.ijse.dao.custom.impl.DaySheduleDAOImpl;
import lk.ijse.dto.DaySheduleDto;

import java.sql.SQLException;
import java.util.List;

public class DaySheduleBoImpl implements DaySheduleBO {

    DaySheduleDAO daySheduleDAO =  (DaySheduleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.DAYSHEDULE);
    public List<DaySheduleDto> getAllShedulBO() throws SQLException, ClassNotFoundException {
       return daySheduleDAO.getAllShedul();
    }

    public boolean saveValuesBO(DaySheduleDto day) throws SQLException, ClassNotFoundException {
       return daySheduleDAO.saveValues(day);
    }
}
