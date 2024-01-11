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

    public boolean saveTutor(Tutor td) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO tutor VALUES(?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, td.getTut_id());
        pstm.setString(2, td.getTutorName());
        pstm.setString(3, td.getSub_id());


        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;

    }

    public Tutor getTutor(String tutId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "select *from tutor WHERE tut_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, tutId);
        ResultSet resultSet = pstm.executeQuery();

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
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "UPDATE tutor SET tutorName=?,sub_id=?  WHERE tut_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, td.getTutorName());
        pstm.setString(2, td.getSub_id());
        pstm.setString(3,td.getTut_id());



        return SQLUtil.execute("UPDATE tutor SET tutorName=?,sub_id=?  WHERE tut_id=?",td.getTutorName(),td.getSub_id(),td.getTut_id()); //pstm.executeUpdate() > 0;

    }
}

