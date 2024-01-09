package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.SubjectDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SubjectDAO extends SuperDAO {

    public boolean subSave(SubjectDto sub) throws SQLException, ClassNotFoundException;

    public List<SubjectDto> getSubject() throws SQLException, ClassNotFoundException;
}
