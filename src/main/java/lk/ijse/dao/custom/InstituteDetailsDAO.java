package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.InstitutMangementDto;
import lk.ijse.entity.InstitutMangement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface InstituteDetailsDAO extends SuperDAO {

    public boolean saveDetails(InstitutMangementDto details) throws SQLException;

    public InstitutMangement allDetails() throws SQLException;

    public boolean updateSaveDetails(InstitutMangement ui) throws SQLException;

    public InstitutMangement setAllDetails() throws SQLException;
}
