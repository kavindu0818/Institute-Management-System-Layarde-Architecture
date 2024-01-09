package lk.ijse.Controller.DashBoard;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.Tm.DayShedulTm;
import lk.ijse.bo.custom.impl.*;
import lk.ijse.dao.custom.impl.*;
import lk.ijse.dto.DaySheduleDto;
import lk.ijse.dto.InstitutMangementDto;
import lk.ijse.dto.NoticeDto;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DashboardOriginalController {
    public Label lblStudentCount;
    public Label lblTutorCont;
    public Label lbltutorCount2;
    public Label lblTime;
    public Label lblDate;
    public AnchorPane DashboardOriganl;
    public AnchorPane Twonc;
    public TableView tblShedulView;
    public TableColumn colClass;
    public TableColumn colStartTime;
    public TableColumn colEndTime;
    public Label lblsetGmail;
    public Label lblSetFb;
    public Label lblSetContact;
    public Label lblHall;


    public Label lblAllAttendance;
    public TextArea txtNoticeField;
    // String ld = lblDate.getText();
    // String dl = lblDate.getText();
    private StudentDetailsDAOImpl sm = new StudentDetailsDAOImpl();

    StudentDetailsBOImpl studentDetailsBO = new StudentDetailsBOImpl();
    TutorBOImpl tutorBO = new TutorBOImpl();
    InstituteDetailsBOImpl instituteDetailsBO = new InstituteDetailsBOImpl();
    DaySheduleBoImpl daySheduleBo = new DaySheduleBoImpl();
    StudentAttendanceBOImpl studentAttendanceBO = new StudentAttendanceBOImpl();
    Course_AttendanceBOImpl courseAttendanceBO = new Course_AttendanceBOImpl();

    NoticeBoImpl noticeBo = new NoticeBoImpl();

    public void initialize() {
        setLableStu();
        setLabletutor();
        Time();
        date();
        getShedulValue();
        shedulTable();
        setLabContact();
        allAttendance();
        notice();

    }


    public void shedulTable() {
        colClass.setCellValueFactory(new PropertyValueFactory<>("className"));
        colStartTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        colEndTime.setCellValueFactory(new PropertyValueFactory<>("endTime"));

    }

    public void setLableStu() {
        var model = new StudentDetailsDAOImpl();

        try {
            int count = studentDetailsBO.howMachStudentBO();
            System.out.println(count);

            lblStudentCount.setText(String.valueOf(count));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setLabletutor() {
        var model = new TutorDAOImpl();

        try {
            int count = tutorBO.howMachTutorBO();

            lbltutorCount2.setText(String.valueOf(count));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Time() {

        Timeline time = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    lblTime.setText(LocalDateTime.now().format(formatter));
                }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void date() {

        Timeline time = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    lblDate.setText(LocalDateTime.now().format(formatter));
                }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void setLabContact() {
        var model = new InstituteDetailsDAOImpl();

        try {
            InstitutMangementDto imd = instituteDetailsBO.setAllDetailsBO();

            lblsetGmail.setText(imd.getGmail());
            lblSetContact.setText(imd.getContact());
            lblSetFb.setText(imd.getFb());
            lblHall.setText(imd.getHall());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /* public void getShedulValue() {
         var smt = new DaySheduleModel();

         ObservableList<DayShedulTm> obList = FXCollections.observableArrayList();

         try {
             List<DaySheduleDto> dtoList = smt.getAllShedul();

             for (DaySheduleDto dto : dtoList) {
                 String date = dto.getDate();

                 if (date.equals(lblDate.getText())) {
                     obList.add(
                             new DayShedulTm(
                                     dto.getClassName(),
                                     dto.getStime(),
                                     dto.getETime()
                             )
                     );
                 }
             }

             // Move these lines outside of the loop
             tblShedulView.setItems(obList);
             tblShedulView.refresh();

         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }*/
    public void getShedulValue() {
        var smt = new DaySheduleDAOImpl();

        ObservableList<DayShedulTm> obList = FXCollections.observableArrayList();

        try {
            List<DaySheduleDto> dtoList = daySheduleBo.getAllShedulBO();

            for (DaySheduleDto dto : dtoList) {
                obList.add(new DayShedulTm(
                                dto.getClassName(),
                                dto.getStime(),
                                dto.getETime()
                        )
                );
            }


            tblShedulView.setItems(obList);
            tblShedulView.refresh();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void allAttendance() {

        int clsA = 0;
        int cosA = 0;


        var model = new Stu_AttendanceDAOImpl();

        try {
            int count = studentAttendanceBO.howMachStudentBO();

            clsA = count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        var Cmodel = new CourseAttendanceDAOImpl();

        try {
            int count = courseAttendanceBO.howMachCourseStudentBO();

            cosA = count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int allA = cosA + clsA;
        lblAllAttendance.setText(String.valueOf(allA));
    }

    private void notice() {
        var nm = new NoticeDAOImpl();
        try {
            List<NoticeDto> dtoList = noticeBo.getAllNoticeBO();

            for (NoticeDto dto : dtoList) {
                txtNoticeField.setText(dto.getNote());

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

