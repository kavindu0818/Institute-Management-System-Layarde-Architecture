package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.Class_DetailsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ClassDetailsDAO extends SuperDAO {

    Class_DetailsDto loardValues(String aId) throws SQLException, ClassNotFoundException;

    List<Class_DetailsDto> getFullId(String sID) throws SQLException, ClassNotFoundException;

    boolean saveClassDetails(Class_DetailsDto ad) throws SQLException, ClassNotFoundException;

    boolean saveValue(String attendance, String stuId, String classID, String stuName) throws SQLException;

    Class_DetailsDto getsendMailValue(String atId) throws SQLException, ClassNotFoundException;



}
