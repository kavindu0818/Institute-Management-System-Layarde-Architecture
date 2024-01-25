package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.InstitutMangementDto;

import java.sql.SQLException;

public interface InstituteDetailsBO extends SuperBO {

    InstitutMangementDto setAllDetailsBO() throws SQLException, ClassNotFoundException;

    InstitutMangementDto allDetailsBO() throws SQLException, ClassNotFoundException;

    boolean updateSaveDetailsBO(InstitutMangementDto ui) throws SQLException, ClassNotFoundException;
}
