package lk.ijse.Controller.Payment;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.Controller.Gmail.GmailMain;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.*;
import lk.ijse.bo.custom.impl.ClassBOImpl;
import lk.ijse.bo.custom.impl.Class_DetailsBOImpl;
import lk.ijse.bo.custom.impl.Class_PaymentBOImpl;
import lk.ijse.bo.custom.impl.StudentDetailsBOImpl;
import lk.ijse.dao.custom.impl.ClassDAOImpl;
import lk.ijse.dao.custom.impl.Class_DetailsDAOImpl;
import lk.ijse.dao.custom.impl.Class_PaymentDAOImpl;
import lk.ijse.dao.custom.impl.StudentDetailsDAOImpl;
import lk.ijse.dto.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static net.sf.jasperreports.engine.JasperPrintManager.printReport;

public class ClassFeeFormController {
    public AnchorPane ClassFeeAnc;
    public TextField txtSearchStudentID;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentID;
    public JFXComboBox cmbMonth;
    public JFXTextField txtAmount;
    public JFXComboBox cmbClass;
    public Label lblDate;
    public TextArea txtFieldClassID;
    public JFXComboBox cmbClassName;
    public TextArea txtFieldClassName;
    public JFXComboBox txtStudentFullID;


    Class_DetailsBO classDetailsBO = (Class_DetailsBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CLASS_DETAILS);
    Class_PaymentBO classPaymentBO = (Class_PaymentBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CLASS_PAYMENT);
    StudentDetailsBO studentDetailsBO = (StudentDetailsBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.STUDENT_DETAILS);
    ClassBO classBO = (ClassBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CLASS);

    private String num;

    public String togmail;
    public String name;
    public String amount;
    public String Gmonth;
    public String date;
    public String toStugmail;
    public String className;
    public String fromGmail ="kavindumaduranga184@gmail.com";

    private static String filePath="D:\\mail";

    private GmailMain gm = new GmailMain();

    public void initialize(){
        setData();
        setClassIDcmb();
        // setLblDate();
        setDateAndTime();
        generateNextOrderId();
    }

    public void PayOnAction(ActionEvent actionEvent) {
        String stuId = txtSearchStudentID.getText();
        String name = txtStudentName.getText();
        String stuFullId  = (String) txtStudentFullID.getValue();
        String classId = txtFieldClassID.getText();
        String className = txtFieldClassName.getText();
        String month = (String) cmbMonth.getValue();
        double amount = Double.parseDouble(txtAmount.getText());

       // var cp = new Class_paymentDto(classId,stuId,name,month,stuFullId,amount);

        try {
            boolean isSaved = classPaymentBO.stuPaymentSaveBO(num,classId,stuId,name,month,stuFullId,amount);
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Payment Save").show();
                 sendMail(stuId);
                  printReport();


            }else {
                new Alert(Alert.AlertType.WARNING,"Not Sucsesus Payment").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public void sendMail(String Id) throws SQLException, ClassNotFoundException {

        StudentfullDetailsDto mail = studentDetailsBO.searchBO(Id);


        if (mail != null){
            togmail = mail.getPerant_Gmail();
            toStugmail =mail.getStudent_gmail();
            name = mail.getName();
        }

       amount = txtAmount.getText();
        Gmonth = (String) cmbMonth.getValue();
        className = txtFieldClassName.getText();

        date = lblDate.getText();
            String text ="Your student has rs for " + className +" today "+amount +" was paid as class fees on " + date;
            String text2 ="Your Payment Sucsesfull";
            String topic = "Pay Class Fees";
            gm.addGmailDEtails(fromGmail,togmail,topic,text);
            gm.addGmailDEtails(fromGmail,toStugmail,topic,text2);

    }


    private void printReport() throws  JRException {
        HashMap map = new HashMap();
        map.put("stuID", txtSearchStudentID.getText());
        map.put("stuName", txtStudentName.getText());
        map.put("ClassID", cmbClass.getValue());
        map.put("className", cmbClassName.getValue());
        map.put("month", cmbMonth.getValue());
        map.put("amount", Double.parseDouble(txtAmount.getText()));

       // InputStream resourceAsStream = getClass().getResourceAsStream("D:\\Institute Management System\\Institute_Management_System\\src\\main\\resources\\Report\\ClassFessReport.jrxml");
        InputStream resourceAsStream = getClass().getResourceAsStream("/Report/ClassFessReport.jrxml");

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

       JasperExportManager.exportReportToPdfFile(jasperPrint, filePath + "\\Receipt " + false+".pdf");

       GmailMain.sendOrderConformMailFile(togmail,subject,new File(filePath + "\\Receipt " +false+".pdf"));
    }


    private void generateNextOrderId() {
        try {
            int orderID = classPaymentBO.generateNextOrderIdBO();
            num="00"+orderID;
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void setData() {

        ArrayList<String> list = new ArrayList<>();
        list.add("January");
        list.add("February");
        list.add("March");
        list.add("April");
        list.add("May");
        list.add("June");
        list.add("July");
        list.add("Augest");
        list.add("September");
        list.add("Octomber");
        list.add("November");
        list.add("December");
        ObservableList<String> dataSet = FXCollections.observableArrayList(list);
        cmbMonth.setItems(dataSet);
    }



    private void setDateAndTime() {
        Timeline time = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    lblDate.setText(LocalDateTime.now().format(formatter));
                }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void setClassIDcmb() {
        var model = new ClassDAOImpl();

        try {
            List<ClassDto> dtoList = classBO.getAllClassBO();

            for (ClassDto classDto : dtoList) {
                cmbClass.getItems().add(classDto.getClass_id());
                cmbClassName.getItems().add(classDto.getClassName());
            }
            cmbClass.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    txtFieldClassID.appendText(newValue + "\n"); // Append the selected item to the TextArea
                }
            });
            cmbClassName.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    txtFieldClassName.appendText(newValue + "\n"); // Append the selected item to the TextArea
                }
            });

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void StudentIDOnAction(ActionEvent actionEvent) {
        String sID = txtSearchStudentID.getText();

        try {
            List<Class_DetailsDto> dtoList = classDetailsBO.getFullIdBO(sID);

            for (Class_DetailsDto classDto : dtoList) {
                txtStudentFullID.getItems().add(classDto.getFull_id());
                txtStudentName.setText(classDto.getStu_name());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


