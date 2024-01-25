package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.InstitutMangementDto;
import lk.ijse.entity.InstitutMangement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface InstituteDetailsDAO extends CrudDAO<InstitutMangement> {

    public boolean saveDetails(InstitutMangementDto details) throws SQLException, ClassNotFoundException;

    public InstitutMangement allDetails() throws SQLException, ClassNotFoundException;

    public boolean updateSaveDetails(InstitutMangement ui) throws SQLException, ClassNotFoundException;

    public InstitutMangement setAllDetails() throws SQLException, ClassNotFoundException;
}
