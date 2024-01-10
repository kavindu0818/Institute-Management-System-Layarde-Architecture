package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.InstituteDetailsBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.InstituteDetailsDAO;
import lk.ijse.dao.custom.impl.InstituteDetailsDAOImpl;
import lk.ijse.dto.InstitutMangementDto;

import java.sql.SQLException;

public class InstituteDetailsBOImpl implements InstituteDetailsBO {

    InstituteDetailsDAO instituteDetailsDAO = (InstituteDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.INSTITUTE_DETAILS);

    public InstitutMangementDto setAllDetailsBO() throws SQLException {
       return instituteDetailsDAO.setAllDetails();
    }

    public InstitutMangementDto allDetailsBO() throws SQLException {
       return instituteDetailsDAO.allDetails();
    }

    public boolean updateSaveDetailsBO(InstitutMangementDto ui) throws SQLException {
        return instituteDetailsDAO.updateSaveDetails(ui);
    }
}
