package lk.ijse.bo;

import lk.ijse.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBOFactory(){
        return (boFactory==null)?boFactory=new BOFactory():boFactory;
    }
    public enum BOTypes{
        CLASS_DETAILS,CLASS_PAYMENT,CLASS,COURSE_DETAILS,COURSE_PAYMENT,COURSEATTENDANCE,COURSE,
        DAYSHEDULE,EMPLOYEEATTENDANCE,EMPLOYEE,INSTITUTE_DETAILS,NOTICE,STU_ATTENDANCE,STUDENT_DETAILS,
        SUBJECT,TUTOR,USER    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CLASS_DETAILS:
                return new Class_DetailsBOImpl();
            case CLASS_PAYMENT:
                return new Class_PaymentBOImpl();
            case CLASS:
                return new ClassBOImpl();
            case COURSE_DETAILS:
                return new Course_DetailsBOImpl();
            case COURSE_PAYMENT:
                return new Course_PaymentBOImpl();
            case COURSEATTENDANCE:
                return new Course_AttendanceBOImpl();
            case COURSE:
                return new CourseBoImpl();
            case DAYSHEDULE:
                return new DaySheduleBoImpl();
            case EMPLOYEEATTENDANCE:
                return new EmployeeAttendanceBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case INSTITUTE_DETAILS:
                return new InstituteDetailsBOImpl();
            case NOTICE:
                return new NoticeBoImpl();
            case STU_ATTENDANCE:
                return new StudentAttendanceBOImpl();
            case STUDENT_DETAILS:
                return new StudentDetailsBOImpl();
            case SUBJECT:
                return new SubjectBOImpl();
            case TUTOR:
                return new TutorBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }

}
