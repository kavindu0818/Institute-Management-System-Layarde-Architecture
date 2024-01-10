package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.Class_DetailsBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ClassDetailsDAO;
import lk.ijse.dao.custom.Class_PaymentDAO;
import lk.ijse.dao.custom.impl.Class_DetailsDAOImpl;
import lk.ijse.dto.Class_DetailsDto;

import java.sql.SQLException;
import java.util.List;

public class Class_DetailsBOImpl implements Class_DetailsBO {

    ClassDetailsDAO classDetailsDAO = (ClassDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CLASS_DETAILS);


    public boolean saveClassDetailsStudemt(Class_DetailsDto ad) throws SQLException, ClassNotFoundException {
        return classDetailsDAO.saveClassDetails(ad);
    }

    public Class_DetailsDto loardValuesAll(String aId) throws SQLException, ClassNotFoundException {
        return classDetailsDAO.loardValues(aId);
    }

    public Class_DetailsDto getsendMailValueAll(String atId) throws SQLException, ClassNotFoundException {
        return classDetailsDAO.getsendMailValue(atId);
    }

    public List<Class_DetailsDto> getFullIdBO(String sID) throws SQLException, ClassNotFoundException {
       return classDetailsDAO.getFullId(sID);
    }
}
