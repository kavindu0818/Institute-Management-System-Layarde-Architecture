package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.InstitutMangementDto;

import java.sql.SQLException;

public interface InstituteDetailsBO extends SuperBO {

    InstitutMangementDto setAllDetailsBO() throws SQLException;

    InstitutMangementDto allDetailsBO() throws SQLException;

    boolean updateSaveDetailsBO(InstitutMangementDto ui) throws SQLException;
}
