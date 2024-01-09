package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.InstituteDetailsBO;
import lk.ijse.dao.custom.impl.InstituteDetailsDAOImpl;
import lk.ijse.dto.InstitutMangementDto;

import java.sql.SQLException;

public class InstituteDetailsBOImpl implements InstituteDetailsBO {

    InstituteDetailsDAOImpl instituteDetailsDAO = new InstituteDetailsDAOImpl();
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
