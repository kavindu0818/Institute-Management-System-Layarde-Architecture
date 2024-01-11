package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.StudentAttendanceBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.StudentAttendanceDAO;
import lk.ijse.dao.custom.impl.Stu_AttendanceDAOImpl;
import lk.ijse.dto.Class_DetailsDto;
import lk.ijse.dto.StudentAttendance;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentAttendanceBOImpl implements StudentAttendanceBO {

    StudentAttendanceDAO stu_attendanceDAO = (StudentAttendanceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STU_ATTENDANCE);
    public List<StudentAttendance> getClassStudentDetails(String classID, LocalDate classDate) throws SQLException, ClassNotFoundException {
      List<StudentAttendance> studentAttendances =  stu_attendanceDAO.getClassStudent(classID,classDate);
      ArrayList<StudentAttendance> studentAttendances1 = new ArrayList<>();

      for (StudentAttendance studentAttendance : studentAttendances){
          studentAttendances1.add(new StudentAttendance(studentAttendance.getName(),studentAttendance.getDate(),studentAttendance.getFull_id(),studentAttendance.getStu_id(),studentAttendance.getClass_id(),studentAttendance.getTime()));

      }
       return studentAttendances;
    }

    public List<StudentAttendance> getAllStudentAttendance() throws SQLException, ClassNotFoundException {
        List<StudentAttendance> studentAttendances =  stu_attendanceDAO.getAllStudent();
        ArrayList<StudentAttendance> studentAttendances1 = new ArrayList<>();

        for (StudentAttendance studentAttendance : studentAttendances){
            studentAttendances1.add(new StudentAttendance(studentAttendance.getName(),studentAttendance.getDate(),studentAttendance.getFull_id(),studentAttendance.getStu_id(),studentAttendance.getClass_id(),studentAttendance.getTime()));

        }
        return studentAttendances;

    }

    public boolean saveAttendnceDetailsStudent(Class_DetailsDto dtoList) throws SQLException, ClassNotFoundException {
       return stu_attendanceDAO.saveAttendnceDetails(dtoList);
    }

    public int howMachStudentBO() throws SQLException, ClassNotFoundException {
       return stu_attendanceDAO.howMachStudent();
    }

    public List<StudentAttendance> getStudentAllAttendnceBO(String id1) throws SQLException, ClassNotFoundException {
        List<StudentAttendance> studentAttendances = stu_attendanceDAO.getStudentAllAttendnce(id1);
        ArrayList<StudentAttendance> studentAttendances1 = new ArrayList<>();

        for (StudentAttendance studentAttendance : studentAttendances){
            studentAttendances1.add(new StudentAttendance(studentAttendance.getName(),studentAttendance.getDate(),studentAttendance.getFull_id(),studentAttendance.getStu_id(),studentAttendance.getClass_id(),studentAttendance.getTime()));

        }
        return studentAttendances;

    }
}
