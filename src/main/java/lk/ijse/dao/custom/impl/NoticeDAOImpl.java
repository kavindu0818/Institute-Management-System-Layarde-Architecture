package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.NoticeDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.NoticeDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeDAOImpl implements NoticeDAO {
    public boolean setNotice(NoticeDto nd) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql= "INSERT INTO notice VALUES(?,?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//        preparedStatement.setString(1,nd.getNote());
//        preparedStatement.setDate(2, nd.getDate());

        Date date = Date.valueOf(nd.getDate());

        return SQLUtil.execute("INSERT INTO notice VALUES(?,?)",nd.getNote(),date); //preparedStatement.executeUpdate() > 0;
    }

    public List<NoticeDto> getAllNotice() throws SQLException, ClassNotFoundException {
       // Connection connection = DbConnection.getInstance().getConnection();
        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        java.sql.Timestamp sqltime = new java.sql.Timestamp(date.getTime());

        String da = String.valueOf(sqldate);

//        String sql = "SELECT * FROM notice WHERE date = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, String.valueOf(sqldate));
        ResultSet resultSet = SQLUtil.execute( "SELECT * FROM notice WHERE date = ?",da); //pstm.executeQuery();

        ArrayList<NoticeDto> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new NoticeDto(
                            resultSet.getString(1),
                            resultSet.getString(2)


                    )
            );
        }
        return dtoList;

    }
}
