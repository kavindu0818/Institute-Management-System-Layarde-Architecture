package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.TutorDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface TutorDAO extends SuperDAO {

    public int howMachTutor() throws SQLException;
    public boolean saveTutor(TutorDto td) throws SQLException;
    public TutorDto getTutor(String tutId) throws SQLException;
    public boolean updateTutor(TutorDto td) throws SQLException, ClassNotFoundException;
}
