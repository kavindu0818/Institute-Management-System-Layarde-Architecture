package lk.ijse.Controller.StudentDetails;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lk.ijse.Tm.*;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.*;
import lk.ijse.bo.custom.impl.*;
import lk.ijse.dao.custom.Class_PaymentDAO;
import lk.ijse.dao.custom.StudentDetailsDAO;
import lk.ijse.dao.custom.impl.*;
import lk.ijse.dto.*;

import java.sql.SQLException;
import java.util.List;

public class StudentDetailsFormController {
    public TextField txtSearchStudentID;
    public TableView tblStudenDetails;
    public TableColumn colSDstuID;
    public TableColumn colSDregID;
    public TableColumn colSDstuName;
    public TableColumn colSDstuGmail;
    public TableColumn colSDstuContact;
    public TableColumn colSDstuAddress;
    public TableView tblPerantDetails;
    public TableColumn colPDperName;
    public TableColumn colPDperGmail;
    public TableColumn colPDperContact;
    public TableView tblAttendanceDetails;
    public TableColumn colADdate;
    public TableColumn colADsubject;
    public TableColumn colADtime;
    public TableView tblPaymentDetails;
    public TableColumn colPeyDmonth;
    public TableColumn colPaysubject;
    public TableColumn colPayDay;
    public ImageView imageViewStudent;
    public TableColumn coCourselPaysubject1;
    public TableColumn colCourseSubmonth1;
    public TableView tblCoursePaymentDetails1;
    public TableColumn colCoursetime1;
    public TableColumn colCoursesubject1;
    public TableColumn colCourseDdate1;
    public TableView tblCourseAttendanceDetails;
    public TableColumn colCoursePayDay1;

    private StudentDetailsDAOImpl stu = new StudentDetailsDAOImpl();
    private Stu_AttendanceDAOImpl stuAttendanceModel = new Stu_AttendanceDAOImpl();
    private Class_PaymentDAO classPaymentModel = new Class_PaymentDAOImpl();
    private StudentDetailsDAO up = new StudentDetailsDAOImpl();
    private Course_paymentDAOImpl cfm = new Course_paymentDAOImpl();
    private CourseAttendanceDAOImpl cam = new CourseAttendanceDAOImpl();

    StudentDetailsBO studentDetailsBO =(StudentDetailsBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.STUDENT_DETAILS);
    StudentAttendanceBO studentAttendanceBO =(StudentAttendanceBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.STU_ATTENDANCE);
    Class_PaymentBO classPaymentBO =(Class_PaymentBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CLASS_PAYMENT);
    Course_PaymentBO coursePaymentBO = (Course_PaymentBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.COURSE_PAYMENT);
    Course_AttendanceBO courseAttendanceBO = (Course_AttendanceBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.COURSEATTENDANCE);


    ObservableList<StudentDetailsTm> obList = FXCollections.observableArrayList();
    ObservableList<ParentDetails> obList2 = FXCollections.observableArrayList();
    ObservableList<PaymentDetailsTm> obList4 = FXCollections.observableArrayList();
    ObservableList<AttendanceDetailsTm> obList3 = FXCollections.observableArrayList();
    ObservableList<CourseStuAttenDetails> obList5 = FXCollections.observableArrayList();
    ObservableList<CourseFeeStuDetailsTm> obList6 = FXCollections.observableArrayList();



    public void initialize(){
        colSDstuID.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        colSDregID.setCellValueFactory(new PropertyValueFactory<>("regId"));
        colSDstuName.setCellValueFactory(new PropertyValueFactory<>("stuName"));
        colSDstuGmail.setCellValueFactory(new PropertyValueFactory<>("gmail"));
        colSDstuContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colSDstuAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        setParentTableValue();
        setAttendanceTableValue();
        setPaymentTableValue();
        setCosAttenTableValue();
        setCosPayTableValue();

    }

    public void setParentTableValue(){
        colPDperName.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        colPDperGmail.setCellValueFactory(new PropertyValueFactory<>("Pgmail"));
        colPDperContact.setCellValueFactory(new PropertyValueFactory<>("Pcontact"));

    }
    public void setAttendanceTableValue(){
        colADdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colADsubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        colADtime.setCellValueFactory(new PropertyValueFactory<>("time"));
    }

    public void setPaymentTableValue(){
        colPeyDmonth.setCellValueFactory(new PropertyValueFactory<>("subject"));
        colPaysubject.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colPayDay.setCellValueFactory(new PropertyValueFactory<>("day"));

    }

    public void setCosAttenTableValue(){
        colCourseDdate1.setCellValueFactory(new PropertyValueFactory<>("date"));
        colCoursesubject1.setCellValueFactory(new PropertyValueFactory<>("sub"));
        colCoursetime1.setCellValueFactory(new PropertyValueFactory<>("time"));

    }

    public void setCosPayTableValue(){
        colCourseSubmonth1.setCellValueFactory(new PropertyValueFactory<>("sub"));
        coCourselPaysubject1.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colCoursePayDay1.setCellValueFactory(new PropertyValueFactory<>("day"));

    }

    public void btnSearchStudent(ActionEvent actionEvent) {

        String iD = txtSearchStudentID.getText();



        try {
            List<StudentfullDetailsDto> dtoList = studentDetailsBO.getClassStudentBO(iD);
            for (StudentfullDetailsDto dto : dtoList) {
                obList.add(
                        new StudentDetailsTm(
                                dto.getStu_id(),
                                dto.getReg_id(),
                                dto.getName(),
                                dto.getStudent_gmail(),
                                dto.getStudent_contactNo(),
                                dto.getAddress()
                        )
                );
                tblStudenDetails.setItems(obList);
                tblStudenDetails.refresh();


            }


            for (StudentfullDetailsDto dto : dtoList) {
                obList2.add(
                        new ParentDetails(
                                dto.getPerant_Name(),
                                dto.getPerant_Gmail(),
                                dto.getPerant_contactNo()

                        )
                );
                tblPerantDetails.setItems(obList2);
                tblPerantDetails.refresh();

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        setAttendance();
        setCorseAttendance();
        setCoursePayment();
    }

        public void setAttendance() {
            String id1 = txtSearchStudentID.getText();

            try {
                List<StudentAttendance> dtoList1 = studentAttendanceBO.getStudentAllAttendnceBO(id1);
                for (StudentAttendance dto : dtoList1) {
                    obList3.add(
                            new AttendanceDetailsTm(
                                    dto.getDate(),
                                    dto.getClass_id(),
                                    dto.getTime()
                            )
                    );
                    tblAttendanceDetails.setItems(obList3);
                    tblAttendanceDetails.refresh();

                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            setPayment();
        }
  public void setPayment() {

      String id2 = txtSearchStudentID.getText();

     // ObservableList<PaymentDetailsTm> obList4 = FXCollections.observableArrayList();
      //obList4.clear();

    try {
        List<Class_paymentDto> dtoList2 = classPaymentBO.getStudentAllPaymentBO(id2);
        if ( dtoList2.isEmpty()) {
            obList4.clear();
        }

        for (Class_paymentDto dto : dtoList2) {
            obList4.add(
                    new PaymentDetailsTm(
                            dto.getClass_Id(),
                            dto.getAmount(),
                            dto.getDate()
                    )
            );


            tblPaymentDetails.setItems(obList4);
            tblPaymentDetails.refresh();

        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
      setImage();
}

    public void setCorseAttendance() {
        String id1 = txtSearchStudentID.getText();

        try {
            List<CourseAttendanceStuDetailsJoinDto> dtoList1 = courseAttendanceBO.getStudentAllAttendnceBO(id1);
            for (CourseAttendanceStuDetailsJoinDto dto : dtoList1) {
                obList5.add(
                        new CourseStuAttenDetails(
                                dto.getDate(),
                                dto.getSub(),
                                dto.getTime()
                        )
                );
                tblCourseAttendanceDetails.setItems(obList5);
                tblCourseAttendanceDetails.refresh();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void setCoursePayment() {

        String id2 = txtSearchStudentID.getText();

        // ObservableList<PaymentDetailsTm> obList4 = FXCollections.observableArrayList();
        //obList4.clear();

        try {
            List<CfdDto> dtoList2 = coursePaymentBO.getStudentAllPaymentBO(id2);


            for (CfdDto dto : dtoList2) {
                obList6.add(
                        new CourseFeeStuDetailsTm(
                                dto.getSub(),
                                dto.getAmount(),
                                dto.getDay()
                        )
                );


                tblCoursePaymentDetails1.setItems(obList6);
                tblCoursePaymentDetails1.refresh();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        setImage();
    }



    public void setImage(){
    String id4 = txtSearchStudentID.getText();

    try{
            StudentfullDetailsDto studentDto = up.search(id4);
            if (studentDto != null) {

                Image fxImage = studentDetailsBO.convertBytesToJavaFXImageBO(studentDto.getImage());
                imageViewStudent.setImage(fxImage);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }

    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtSearchStudentID.clear();
        obList.clear();
        obList2.clear();
        obList3.clear();
        obList4.clear();
        obList5.clear();
        obList6.clear();

    }
}

