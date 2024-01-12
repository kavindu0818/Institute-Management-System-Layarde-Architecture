package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.EmlpoyeeAttendanceDAO;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.EmpAttendnaceDto;
import lk.ijse.dto.EmployeeAttendanceJoin;
import lk.ijse.entity.EmpAttendnace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAttendanceDAOImpl implements EmlpoyeeAttendanceDAO {
    public boolean saveEmpAttendance(String num, String empAttendanceID, String empId) throws SQLException, ClassNotFoundException {
        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        java.sql.Timestamp sqltime = new java.sql.Timestamp(date.getTime());

        String sDate = String.valueOf(sqldate);
        String sTime = String.valueOf(sqltime);


        return SQLUtil.execute( "INSERT INTO employee_attendance VALUES(?, ?, ?, ?,?)",num,empAttendanceID,empId,sDate,sTime);

    }
    public int generateNextOrderId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT attendnceID FROM employee_attendance ORDER BY attendnceID DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return splitOrderId(Integer.parseInt(resultSet.getString(1)));
        }
        return splitOrderId(0001);
    }

    private static int splitOrderId(int id) {
        if (id ==0){
            return 1;
        }
        return++id;
    }

    public List<EmployeeAttendanceJoin> getAllEmployeeAttndance() throws SQLException, ClassNotFoundException {
        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());

        ResultSet resultSet =SQLUtil.execute( "SELECT employee_attendance.emp_id,employee.name\n" +
                "FROM employee INNER JOIN employee_attendance ON employee.emp_id=Employee_attendance.emp_id WHERE Date = ?",sqldate
);

        ArrayList<EmployeeAttendanceJoin> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new EmployeeAttendanceJoin(
                            resultSet.getString(1),
                            resultSet.getString(2)

                    )
            );
        }
        return dtoList;
    }

    public int howMachEmployeeAttendance() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());


        String sql ="select count(attendnceID) from employee_attendance WHERE Date = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setDate(1,sqldate);
        ResultSet resultSet = pstm.executeQuery();

        int a = 0;

        if (resultSet.next()){
            return resultSet.getInt(1);

        }
        return 0;
    }

    public List<EmpAttendnace> getAllEmployeeAttendance(String id) throws SQLException, ClassNotFoundException {


        ResultSet resultSet = SQLUtil.execute("SELECT *FROM employee_attendance WHERE emp_id=?",id);//pstm.executeQuery();
        ArrayList<EmpAttendnace> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new EmpAttendnace(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDate(4),
                            resultSet.getString(5)

                    )
            );
        }
        return dtoList;

    }
}
