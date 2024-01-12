package lk.ijse.dao.custom.impl;


import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.TutorDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.TutorDto;
import lk.ijse.entity.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TutorDAOImpl implements TutorDAO {

    public int howMachTutor() throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "select count(tut_id) from tutor";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        int a = 0;

        if (resultSet.next()) {
            return resultSet.getInt(1);

        }
        return 0;

    }

    public boolean saveTutor(Tutor td) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO tutor VALUES(?,?,?)",td.getTut_id(),td.getTutorName(),td.getSub_id());

    }

    public Tutor getTutor(String tutId) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT *FROM tutor WHERE tut_id=?", tutId);

        Tutor doList = null;

        if (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String sub = resultSet.getString(3);

            doList = new Tutor(id, name, sub);
        }
        return doList;
    }

    public boolean updateTutor(Tutor td) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE tutor SET tutorName=?,sub_id=?  WHERE tut_id=?",td.getTutorName(),td.getSub_id(),td.getTut_id()); //pstm.executeUpdate() > 0;

    }
}

