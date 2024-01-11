package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.CourseAttendanceDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.entity.AttendanceJoin;
import lk.ijse.entity.CourseAttendanceJoin;
import lk.ijse.entity.CourseAttendanceStuDetailsJoin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseAttendanceDAOImpl implements CourseAttendanceDAO {
    public ArrayList<CourseAttendanceJoin> getAllCourseAttendance(String courseID, String date) throws SQLException, ClassNotFoundException {

//        Connection connection = DbConnection.getInstance().getConnection();
//
//
//        String sql = "SELECT course_details.stu_id, course_details.stu_name,course_attendance.date, course_attendance.time, course_attendance.cusfull_id"
//               + " FROM course_attendance " +
//                "INNER JOIN course_details ON course_attendance.cusfull_id = course_details.cusDfull_id " +
//                "WHERE cus_id = ? AND date =?";
//
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, courseID);
//        pstm.setString(2, date);
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

    public boolean saveAttendnceDetails(String aId, String num1) throws SQLException, ClassNotFoundException {
        //Connection connection = DbConnection.getInstance().getConnection();

        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        java.sql.Timestamp sqltime = new java.sql.Timestamp(date.getTime());

        String sTime = String.valueOf(sqltime);
        String sDate= String.valueOf(sqldate);

//        String sql = "INSERT INTO course_attendance VALUES(?, ?, ?, ?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1, num1 );
//        pstm.setString(2, aId);
//        pstm.setString(3, String.valueOf(sqldate));
//        pstm.setString(4, String.valueOf(sqltime));
//
//
//        boolean isSaved = pstm.executeUpdate() > 0;

        return SQLUtil.execute("INSERT INTO course_attendance VALUES(?, ?, ?, ?)",num1,aId,sDate,sTime);
    }

    public int generateNextOrderId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT attendanceID FROM course_attendance ORDER BY attendanceID DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            return splitOrderId(Integer.parseInt(resultSet.getString(1)));
        }
        return splitOrderId(0001);
    }



    public int splitOrderId(int id) {
        if (id == 0) {
            return 1;
        }
        return ++id;


    }

    public ArrayList<AttendanceJoin> getAllAttndance() throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());



//        String sql = "SELECT course_attendance.cusfull_id, course_attendance.date, course_attendance.time, " +
//                "course_details.cus_id, course_details.stu_name, course_details.stu_id " +
//                "FROM course_attendance " +
//                "INNER JOIN course_details ON course_attendance.cusfull_id = course_details.cusDfull_id " +
//                "WHERE date = ?";

//           PreparedStatement pstm = connection.prepareStatement(sql);
//            pstm.setDate(1, sqldate);
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

    public int howMachCourseStudent() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());


        String sql ="select count(attendanceID) from course_attendance WHERE date=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setDate(1,sqldate);
        ResultSet resultSet = pstm.executeQuery();

        int a = 0;

        if (resultSet.next()){
            return resultSet.getInt(1);

        }
        return 0;

    }


    public ArrayList<CourseAttendanceStuDetailsJoin> getStudentAllAttendnce(String id1) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT course_attendance.date,  course_details.cus_name, course_attendance.time" +
//                " FROM course_details " +
//                "INNER JOIN  course_attendance ON course_details.cusDfull_id = course_attendance.cusfull_id " +
//                "WHERE stu_id = ?";
//
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, id1);
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
}





