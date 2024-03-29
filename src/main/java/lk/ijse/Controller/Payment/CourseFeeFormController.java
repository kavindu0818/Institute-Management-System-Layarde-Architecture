package lk.ijse.Controller.Payment;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import lk.ijse.Controller.Gmail.GmailMain;
import lk.ijse.Tm.CourseDetailsTm;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.*;
import lk.ijse.bo.custom.impl.Course_DetailsBOImpl;
import lk.ijse.dao.custom.impl.CourseDAOImpl;
import lk.ijse.dao.custom.impl.Course_detailsDAOImpl;
import lk.ijse.dao.custom.impl.Course_paymentDAOImpl;
import lk.ijse.dao.custom.impl.StudentDetailsDAOImpl;
import lk.ijse.dto.*;
import lk.ijse.dao.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

public class CourseFeeFormController {
    public TextField StuNameCourse;
    public TextField courseDfullid;
    public TextField txtAmountCourse;
    public TextField CoursePayStuIDSarch;
    public TextField stuiDCursePayment;
    public TextField txtPaymentId;
    public Label lblDateAndTime;
    public ComboBox cmbCourseDetailsID;
    public ComboBox cmbCourse;

    CourseFeeDetailsFormController courseFeeDetailsFormController;

    private ObservableList<CourseDetailsTm> obList = null;
    private Course_detailsDAOImpl courseDetailsModel = new Course_detailsDAOImpl();
    public static final String ORDER_ID_PREFIX = "P";
    private static final int ORDER_ID_LENGTH = 3;



    String num;
    public String togmail;
    public String name;
    public String amount;
    public String Gmonth;
    public String date;
    public String toStugmail;
    public String className;
    public String fromGmail ="kavindumaduranga184@gmail.com";
    private GmailMain gm = new GmailMain();

    Course_DetailsBO courseDetailsBO = (Course_DetailsBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.COURSE_DETAILS);
     StudentDetailsBO studentDetailsBO = (StudentDetailsBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.STUDENT_DETAILS);
     Course_PaymentBO coursePaymentBO = (Course_PaymentBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.COURSE_PAYMENT);
     CourseBO courseBO = (CourseBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.COURSE);


    public void initialize(){
        generateNextOrderId();
        setDateAndTime();
        setComboBoxValue();
    }


    public void PaymentSubmitOnAction(ActionEvent actionEvent) {
        double amount = Double.parseDouble(txtAmountCourse.getText());
        String cusDfull = (String) cmbCourseDetailsID.getValue();
        String stuId = stuiDCursePayment.getText();
        System.out.println(num);

        SetPaymentDto setPaymentDto = new SetPaymentDto(num,amount, cusDfull,stuId);
        try {
            boolean isSuccess = coursePaymentBO.setPaymentDetails(setPaymentDto);
            if (isSuccess) {
                new Alert(Alert.AlertType.CONFIRMATION, "Payment Change Success!").show();
                sendMail(stuiDCursePayment.getText());
                printReport();
              //  clearField();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    private void printReport() throws JRException {
        HashMap map = new HashMap();
        map.put("StuID", CoursePayStuIDSarch.getText());
        map.put("stuName", StuNameCourse.getText());
        map.put("Course", cmbCourse.getValue());
        map.put("Amount",  Double.parseDouble(txtAmountCourse.getText()));


        // InputStream resourceAsStream = getClass().getResourceAsStream("D:\\Institute Management System\\Institute_Management_System\\src\\main\\resources\\Report\\ClassFessReport.jrxml");
        InputStream resourceAsStream = getClass().getResourceAsStream("/Report/Corse Payment Bill.jrxml");

        String subject="Payment Successful";

        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(load);

        JasperPrint jasperPrint =
                JasperFillManager.fillReport(
                        jasperReport, //compiled report
                        map,
                        new JREmptyDataSource() //database connection
                );

        JasperViewer.viewReport(jasperPrint, false);

        // JasperExportManager.exportReportToPdfFile(jasperPrint, filePath + "\\Receipt " + false+".pdf");

        // GmailMain.sendOrderConformMailFile(toStugmail,subject,new File(filePath + "\\Receipt " +false+".pdf"));
    }
    public void setComboBoxValue(){
        var course = new CourseDAOImpl();
        try {
            List<CourseDto> dtoList = courseBO.getCourseIDBO();

            for (CourseDto dto : dtoList) {
                cmbCourse.getItems().add(dto.getCusId());
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public void sendMail(String Id) throws SQLException, ClassNotFoundException {

        String cf = (String) cmbCourseDetailsID.getValue();
        StudentfullDetailsDto mail = studentDetailsBO.searchBO(Id);
        Course_detailsDto cMail = courseDetailsBO.courseNameBO(cf);

//        System.out.println(togmail);
//        System.out.println(toStugmail);

        if (mail != null){
            togmail = mail.getPerant_Gmail();
            toStugmail =mail.getStudent_gmail();
            name = mail.getName();
            //payDate = mail.
        }

        if(cMail !=null){
            className = cMail.getCusName();
        }

        amount = txtAmountCourse.getText();

       date = lblDateAndTime.getText();
        String text ="Your student has rs for " + className +" today "+amount +" was paid as Course fees on " + date;
        String text2 ="Your Payment Sucsesfull";
        String topic = "Pay Class Fees";
        gm.addGmailDEtails(fromGmail,togmail,topic,text);
        gm.addGmailDEtails(fromGmail,toStugmail,topic,text2);

    }

    private void setDateAndTime() {
        Timeline time = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    lblDateAndTime.setText(LocalDateTime.now().format(formatter));
                }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }


  /*private void generateNextOrderId() {
       try {
           int orderID = cpm.generateNextOrderId();
           num = ORDER_ID_PREFIX + String.format("%0" + ORDER_ID_LENGTH + "d", orderID);
       } catch (SQLException e) {
           new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
       }
   }*/

    private void generateNextOrderId() {
        try {
            int orderID = coursePaymentBO.generateNextCourseFeeIdBO();
            num="00"+orderID;
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    public void txtCourseStuIdSearchIdOnAction(ActionEvent actionEvent) {
        String a = CoursePayStuIDSarch.getText();
        try {
            Course_detailsDto dtop = courseDetailsBO.getAllValuesCdBO(a);
            if (dtop != null) {
                stuiDCursePayment.setText(dtop.getStuId());
                StuNameCourse.setText(dtop.getStuName());


            } else {
                new Alert(Alert.AlertType.INFORMATION, "student not found").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            List<Course_detailsDto> dtoList = courseDetailsBO.getCourseDetailsIDBO(a);

            for (Course_detailsDto courseDetailsDto : dtoList) {
                cmbCourseDetailsID.getItems().add(courseDetailsDto.getCusDfull());
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void clearField(){
          txtAmountCourse.clear();
          StuNameCourse.clear();
          CoursePayStuIDSarch.clear();
          stuiDCursePayment.clear();
          txtPaymentId.clear();

    }
}
