package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.DaySheduleDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface DaySheduleDAO extends SuperDAO {

    boolean saveValues(DaySheduleDto day) throws SQLException, ClassNotFoundException;
    List<DaySheduleDto> getAllShedul() throws SQLException, ClassNotFoundException;
}
