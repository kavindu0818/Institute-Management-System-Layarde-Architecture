package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.TutorDto;
import lk.ijse.entity.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface TutorDAO extends SuperDAO {

    public int howMachTutor() throws SQLException;
    public boolean saveTutor(Tutor td) throws SQLException, ClassNotFoundException;
    public Tutor getTutor(String tutId) throws SQLException, ClassNotFoundException;
    public boolean updateTutor(Tutor td) throws SQLException, ClassNotFoundException;
}
