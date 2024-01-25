package lk.ijse.dao;

import lk.ijse.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){
    }
    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }
    public enum DAOTypes{

        CLASS_DETAILS,CLASS_PAYMENT,CLASS,COURSE_DETAILS,COURSE_PAYMENT,COURSEATTENDANCE,COURSE,
        DAYSHEDULE,EMPLOYEEATTENDANCE,EMPLOYEE,INSTITUTE_DETAILS,NOTICE,STU_ATTENDANCE,STUDENT_DETAILS,
        SUBJECT,TUTOR,USER,QUARY
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CLASS_DETAILS:
                return new Class_DetailsDAOImpl();
            case CLASS_PAYMENT:
                return new Class_PaymentDAOImpl();
            case CLASS:
                return new ClassDAOImpl();
            case COURSE_DETAILS:
                return new Course_detailsDAOImpl();
            case COURSE_PAYMENT:
                return new Course_paymentDAOImpl();
            case COURSEATTENDANCE:
                return new CourseAttendanceDAOImpl();
            case COURSE:
                return new CourseDAOImpl();
            case DAYSHEDULE:
                return new DaySheduleDAOImpl();
            case EMPLOYEEATTENDANCE:
                return new EmployeeAttendanceDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case INSTITUTE_DETAILS:
                return new InstituteDetailsDAOImpl();
            case NOTICE:
                return new NoticeDAOImpl();
            case STU_ATTENDANCE:
                return new Stu_AttendanceDAOImpl();
            case STUDENT_DETAILS:
                return new StudentDetailsDAOImpl();
            case SUBJECT:
                return new SubjectDAOImpl();
            case TUTOR:
                return new TutorDAOImpl();
            case USER:
                return new UserDAOImpl();
            case QUARY:
                return new QuaryDAOimpl();
            default:
                return null;
        }
    }
}
