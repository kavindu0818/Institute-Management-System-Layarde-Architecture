package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.DaySheduleBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.DaySheduleDAO;
import lk.ijse.dao.custom.impl.DaySheduleDAOImpl;
import lk.ijse.dto.DaySheduleDto;
import lk.ijse.entity.DayShedule;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaySheduleBoImpl implements DaySheduleBO {

    DaySheduleDAO daySheduleDAO =  (DaySheduleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.DAYSHEDULE);

    @Override
    public List<DaySheduleDto> getAllShedulBO() throws SQLException, ClassNotFoundException {
       List<DayShedule> dayShedules = daySheduleDAO.getAllShedul();
        ArrayList<DaySheduleDto> daySheduleDtos = new ArrayList<>();

        for (DayShedule dayShedule: dayShedules){
            daySheduleDtos.add(new DaySheduleDto(dayShedule.getClassName(),dayShedule.getDate(),dayShedule.getStime(),dayShedule.getETime()));
        }

        return daySheduleDtos;
    }

    @Override
    public boolean saveValuesBO(DaySheduleDto day) throws SQLException, ClassNotFoundException {
       DayShedule dayShedule = new DayShedule(day.getClassName(),day.getDate(),day.getStime(),day.getETime());

        return daySheduleDAO.saveValues(dayShedule);
    }
}
