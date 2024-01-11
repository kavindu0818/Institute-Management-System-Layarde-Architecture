package lk.ijse.dao.custom.impl;


import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.ClassDetailsDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.Class_DetailsDto;
import lk.ijse.entity.Class_Details;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Class_DetailsDAOImpl implements ClassDetailsDAO {


    public Class_Details loardValues(String aId) throws SQLException, ClassNotFoundException {

//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM  class_Details WHERE full_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, aId);

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM  class_Details WHERE full_id = ?",aId);
        Class_Details dto = null;

        if(resultSet.next()) {
            String fullId = resultSet.getString(1);
            String stuId = resultSet.getString(2);
            String classId = resultSet.getString(3);
            String stuName = resultSet.getString(4);

            dto = new Class_Details(fullId,stuId,classId,stuName);
        }
        return dto;

    }

    public List<Class_Details> getFullId(String sID) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM  class_Details WHERE stu_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, sID);

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM  class_Details WHERE stu_id = ?",sID);//pstm.executeQuery();
        ArrayList<Class_Details> dtoList = new ArrayList<>();
        // ClassDto dto = null;

        while(resultSet.next()) {
            dtoList.add(
                    new Class_Details(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)

                    )
            );
        }
        return dtoList;

    }

    public boolean saveClassDetails(Class_Details ad) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO class_details VALUES(?, ?, ?, ?)",ad.getFull_id(),ad.getStu_id(),ad.getClass_id(),ad.getStu_name());

//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "INSERT INTO class_details VALUES(?, ?, ?, ?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1, ad.getFull_id());
//
//        pstm.setString(2, ad.getStu_id());
//        pstm.setString(3, ad.getClass_id());
//        pstm.setString(4, ad.getStu_name());
//
//
//        boolean isSaved = pstm.executeUpdate() > 0;
//
//        return isSaved;
    }

    public boolean saveValue(String attendance, String stuId, String classID, String stuName) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO class_details VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, attendance);
        pstm.setString(2, stuId);
        pstm.setString(3, classID);
        pstm.setString(4,stuName);


        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

    public Class_DetailsDto getsendMailValue(String atId) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM  class_Details WHERE full_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, atId);

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM  class_Details WHERE full_id = ?",atId);

        Class_DetailsDto dto = null;

        if(resultSet.next()) {
            String fullId = resultSet.getString(1);
            String stuId = resultSet.getString(2);
            String clasID = resultSet.getString(3);
            String name = resultSet.getString(4);

            dto = new Class_DetailsDto(fullId,stuId,clasID,name);

    }
        return dto;

}
}
