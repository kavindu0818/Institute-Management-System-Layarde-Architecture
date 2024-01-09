package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.DaySheduleDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.DaySheduleDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaySheduleDAOImpl implements DaySheduleDAO {
    public boolean saveValues(DaySheduleDto day) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "INSERT INTO dayshedule VALUES(?,?,?,?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1,day.getClassName());
//        pstm.setString(2,day.getDate());
//        pstm.setString(3,day.getStime());
//        pstm.setString(4,day.getETime());
//
//
//        boolean isSaved = pstm.executeUpdate() > 0;

        return SQLUtil.execute("INSERT INTO dayshedule VALUES(?,?,?,?)",day.getClassName(),day.getDate(),day.getStime(),day.getETime());
    }

    public List<DaySheduleDto> getAllShedul() throws SQLException, ClassNotFoundException {
       // Connection connection = DbConnection.getInstance().getConnection();
        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        java.sql.Timestamp sqltime = new java.sql.Timestamp(date.getTime());

        String sDate = String.valueOf(sqldate);

//        String sql = "SELECT * FROM dayshedule WHERE Date = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, String.valueOf(sqldate));
        ResultSet resultSet = SQLUtil.execute( "SELECT * FROM dayshedule WHERE Date = ?",sDate); //pstm.executeQuery();

        ArrayList<DaySheduleDto> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new DaySheduleDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)

                    )
            );
        }
        return dtoList;


    }
}
