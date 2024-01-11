package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.InstituteDetailsBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.InstituteDetailsDAO;
import lk.ijse.dao.custom.impl.InstituteDetailsDAOImpl;
import lk.ijse.dto.InstitutMangementDto;
import lk.ijse.entity.InstitutMangement;

import java.sql.SQLException;

public class InstituteDetailsBOImpl implements InstituteDetailsBO {

    InstituteDetailsDAO instituteDetailsDAO = (InstituteDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.INSTITUTE_DETAILS);

    public InstitutMangementDto setAllDetailsBO() throws SQLException {
        InstitutMangement institutMangement =  instituteDetailsDAO.setAllDetails();
        InstitutMangementDto institutMangementDto = new InstitutMangementDto(institutMangement.getGmail(),institutMangement.getContact(),institutMangement.getFb(),institutMangement.getHall());
        return institutMangementDto;

    }

    public InstitutMangementDto allDetailsBO() throws SQLException {
      InstitutMangement institutMangement = instituteDetailsDAO.allDetails();
      InstitutMangementDto institutMangementDto = new InstitutMangementDto(institutMangement.getGmail(),institutMangement.getContact(),institutMangement.getFb(),institutMangement.getHall());
       return institutMangementDto;
    }

    public boolean updateSaveDetailsBO(InstitutMangementDto ui) throws SQLException {
        InstitutMangement institutMangement = new InstitutMangement(ui.getGmail(),ui.getContact(),ui.getFb(),ui.getHall());
        return instituteDetailsDAO.updateSaveDetails(institutMangement);
    }
}
