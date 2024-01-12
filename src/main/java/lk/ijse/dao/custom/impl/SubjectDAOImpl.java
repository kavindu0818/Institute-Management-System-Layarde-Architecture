package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.SubjectDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.SubjectDto;
import lk.ijse.entity.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {

    public boolean subSave(SubjectDto sub) throws SQLException, ClassNotFoundException {

       return SQLUtil.execute( "INSERT INTO subject VALUES(?,?)",sub.getSub_id(),sub.getSubjectName());
    }

    public List<Subject> getSubject() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT *FROM subject");//pstm.executeQuery();


        ArrayList<Subject> dtoList = new ArrayList<>();
        // ClassDto dto = null;

        while(resultSet.next()) {
            dtoList.add(
                    new Subject(
                            resultSet.getString(1),
                            resultSet.getString(2)


                    )
            );
        }
        return dtoList;
    }
}
