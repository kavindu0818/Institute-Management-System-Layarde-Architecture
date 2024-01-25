package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.DaySheduleDto;
import lk.ijse.entity.DayShedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface DaySheduleDAO extends CrudDAO<DayShedule> {

    boolean saveValues(DayShedule day) throws SQLException, ClassNotFoundException;
    List<DayShedule> getAllShedul() throws SQLException, ClassNotFoundException;
}
