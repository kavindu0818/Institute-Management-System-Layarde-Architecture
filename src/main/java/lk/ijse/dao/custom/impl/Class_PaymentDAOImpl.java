package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.Class_PaymentDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.ClassPaymentDto;
import lk.ijse.dto.Class_paymentDto;
import lk.ijse.entity.ClassPayment;
import lk.ijse.entity.Class_payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Class_PaymentDAOImpl implements Class_PaymentDAO {

    public int generateNextOrderId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT payment_Id FROM class_payment ORDER BY payment_Id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return splitOrderId(Integer.parseInt(resultSet.getString(1)));
        }
        return splitOrderId(0001);
    }

    public int splitOrderId(int id) {
        if (id ==0){
            return 1;
        }
        return++id;
}

    public List<Class_paymentDto> getClassStudent(String classId, String month) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM class_payment WHERE class_Id= ? AND paymentMonth = ?",classId,month); //pstm.executeQuery();

        ArrayList<Class_paymentDto> dList = new ArrayList<>();
        while (resultSet.next()) {
            dList.add(
                    new Class_paymentDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getDate(6),
                            resultSet.getString(7),
                            resultSet.getDouble(8)
                    )
            );
        }


        return dList;
        }

    public boolean stuPaymentSave(String num,String classId, String stuId, String name, String month, String stuFullId, double amount) throws SQLException, ClassNotFoundException {

        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        java.sql.Timestamp sqltime = new java.sql.Timestamp(date.getTime());

        String sdate = String.valueOf(sqldate);


        return SQLUtil.execute("INSERT INTO class_payment VALUES(?, ?, ?, ?,?,?,?,?)",num,classId,stuId,name,month,sdate,stuFullId,amount);
    }

    public List<Class_payment> getStudentAllPayment(String iD) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM class_payment WHERE stu_id = ?",iD);//pstm.executeQuery();

        ArrayList<Class_payment> dtoList = new ArrayList<>();
        while(resultSet.next()) {
            dtoList.add(
                    new Class_payment(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getDate(6),

                            resultSet.getString(7),
                            resultSet.getDouble(8)
                    )
            );
        }


            return dtoList;

    }

    public List<ClassPaymentDto> readyClassFessDetails(String classId, String month) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT class_payment.stu_Id,class_payment.name,class_payment.date,class_payment.amount FROM class_payment INNER JOIN class_details ON class_payment.full_id = class_details.ful_id  WHERE class_id= ? AND paymentMonth =?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,classId);
        pstm.setString(2,month);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<ClassPaymentDto> dtoList = new ArrayList<>();
        while(resultSet.next()) {
            System.out.println("aaaaaaaaaaaaaaaa");
            dtoList.add(
                    new ClassPaymentDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDouble(4)

                    )
            );
        }

        return dtoList;

    }

    public List<ClassPayment> getAllClassPayment(String clssID, String month) throws SQLException, ClassNotFoundException {


            ResultSet resultSet =SQLUtil.execute("SELECT class_payment.stu_Id,class_payment.name,class_payment.date,class_payment.amount FROM class_payment INNER JOIN class_details ON class_payment.full_id = class_details.ful_id  WHERE class_id= ? AND paymentMonth =?",clssID,month
);
                ArrayList<ClassPayment> dtoList = new ArrayList<>();
                while (resultSet.next()) {
                    dtoList.add(new ClassPayment(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDouble(4)

                    ));
                }
                return dtoList;
            }
        }




