package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.QuaryDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.ClassPaymentDto;
import lk.ijse.dto.EmployeeAttendanceJoin;
import lk.ijse.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuaryDAOimpl implements QuaryDAO {

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

    public List<Cfd> getStudentAllPayment(String id2) throws SQLException, ClassNotFoundException {


        ResultSet resultSet = SQLUtil.execute("SELECT course_details.cus_name, course_payment.payment, course_payment.Date" +
                " FROM course_payment" +
                " INNER JOIN course_details ON course_payment.cusDfull_id = course_details.cusDfull_id" +
                " WHERE course_payment.stu_id = ?",id2);//pstm.executeQuery();

        ArrayList<Cfd> dtoList = new ArrayList<>();
        while(resultSet.next()) {
            dtoList.add(
                    new Cfd(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3)


                    )
            );
        }
        return dtoList;
    }

    public ArrayList<CourseAttendanceJoin> getAllCourseAttendance(String courseID, String date) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT course_details.stu_id, course_details.stu_name,course_attendance.date, course_attendance.time, course_attendance.cusfull_id"
                + " FROM course_attendance " +
                "INNER JOIN course_details ON course_attendance.cusfull_id = course_details.cusDfull_id " +
                "WHERE cus_id = ? AND date =?",courseID,date); //pstm.executeQuery();

        ArrayList<CourseAttendanceJoin> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new CourseAttendanceJoin(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getDate(3),
                            resultSet.getString(4),
                            resultSet.getString(5)

                    )
            );
        }
        return dtoList;


    }

    public ArrayList<AttendanceJoin> getAllAttndance() throws SQLException, ClassNotFoundException {

        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());

        ResultSet resultSet =SQLUtil.execute("SELECT course_attendance.cusfull_id, course_attendance.date, course_attendance.time, " +
                "course_details.cus_id, course_details.stu_name, course_details.stu_id " +
                "FROM course_attendance " +
                "INNER JOIN course_details ON course_attendance.cusfull_id = course_details.cusDfull_id " +
                "WHERE date = ?",sqldate); //pstm.executeQuery();

        ArrayList<AttendanceJoin> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new AttendanceJoin(
                            resultSet.getString(1),
                            resultSet.getDate(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
        return dtoList;
    }

    public ArrayList<CourseAttendanceStuDetailsJoin> getStudentAllAttendnce(String id1) throws SQLException, ClassNotFoundException {

        ResultSet resultSet =SQLUtil.execute("SELECT course_attendance.date,  course_details.cus_name, course_attendance.time" +
                " FROM course_details " +
                "INNER JOIN  course_attendance ON course_details.cusDfull_id = course_attendance.cusfull_id " +
                "WHERE stu_id = ?",id1); //pstm.executeQuery();

        ArrayList<CourseAttendanceStuDetailsJoin> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new CourseAttendanceStuDetailsJoin(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3)

                    )
            );
        }
        return dtoList;

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

    public List<CoursePaymentJoin> getAllPayment(String cusID, String date) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT course_payment.stu_id,course_details.stu_name,course_payment.Date,course_payment.payment\n" +
                "FROM course_details INNER JOIN course_payment ON course_payment.cusDfull_id= course_details.cusDfull_id WHERE cus_id = ? AND Date=?",cusID,date);// pstm.executeQuery();

        ArrayList<CoursePaymentJoin> dtoList = new ArrayList<>();
        while(resultSet.next()) {
            dtoList.add(
                    new CoursePaymentJoin(
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
