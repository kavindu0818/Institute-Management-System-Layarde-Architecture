package lk.ijse.Controller.Shadule;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Controller.Gmail.GmailMain;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.ClassBO;
import lk.ijse.bo.custom.InstituteDetailsBO;
import lk.ijse.bo.custom.impl.InstituteDetailsBOImpl;
import lk.ijse.dto.InstitutMangementDto;
import lk.ijse.dao.custom.impl.InstituteDetailsDAOImpl;

import java.io.IOException;
import java.sql.SQLException;

public class InstituteShaduleFormController {

    public AnchorPane AncShedul2;
    public TextField txtGmailFrom;
    public TextField txtGmailTo;
    public TextArea txtGmailMessage;
    public TextField txtGmailSubject;
    public AnchorPane AncShadule1;
    public AnchorPane AncShadule11;
    public JFXTextField txtGmail;
    public JFXTextField txtContact;
    public JFXTextField txtfb;
    public JFXTextField txtHall;
    public AnchorPane AncInstitutDetails;

    private GmailMain gmail = new GmailMain();
    InstituteDetailsBO instituteDetailsBO = (InstituteDetailsBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.INSTITUTE_DETAILS);

    public void initialize(){
        setText();

    }

    public void AddClassOnAction(ActionEvent actionEvent) throws IOException {
        AncShedul2.getChildren().clear();
        AncShedul2.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Add_ClassForm.fxml")));
    }

    public void AddCourseOnAction(ActionEvent actionEvent) throws IOException {
        AncShedul2.getChildren().clear();
        AncShedul2.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Add _CourseForm.fxml")));
    }

    public void btnSendGmailOnAction(ActionEvent actionEvent) {
        String from = txtGmailFrom.getText();
        String to = txtGmailTo.getText();
        String sub = txtGmailSubject.getText();
        String msg = txtGmailMessage.getText();

        gmail.addGmailDEtails(from,to,sub,msg);

    }

    public void AddDayShaduleClass(ActionEvent actionEvent) throws IOException {
        AncShadule1.getChildren().clear();
        AncShadule1.getChildren().add(FXMLLoader.load(getClass().getResource("/view/DaySheduleClass.fxml")));

    }

    public void AddDaySheduleCourse(ActionEvent actionEvent) throws IOException {
        AncShadule1.getChildren().clear();
        AncShadule1.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AddDaySheduleCourse.fxml ")));
    }


    public void AddSubjectOnAction(ActionEvent actionEvent) throws IOException {
        AncShedul2.getChildren().clear();
        AncShedul2.getChildren().add(FXMLLoader.load(getClass().getResource("/View/AddSubjectForm.fxml")));
    }
    public void InstituteDetailsOnAction(ActionEvent actionEvent) throws IOException {
        AncInstitutDetails.getChildren().clear();
        AncInstitutDetails.getChildren().add(FXMLLoader.load(getClass().getResource("/View/InstituteDetailsUpdateForm.fxml")));
    }
    public void InstituteDetailsSubmitOnAction(ActionEvent actionEvent) {
        String gmail = txtGmail.getText();
        String contact = txtContact.getText();
        String fb = txtfb.getText();
        String hall = txtHall.getText();

        var ui = new InstitutMangementDto(gmail,contact,fb,hall);

        try {
            boolean isSaved = instituteDetailsBO.updateSaveDetailsBO(ui);
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Details Save!").show();
                isClear();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Agin").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void setText(){
        var ud = new InstituteDetailsDAOImpl();

        try {
            InstitutMangementDto institutMangementDto = instituteDetailsBO.allDetailsBO();

            if (institutMangementDto != null) {
                txtGmail.setText(institutMangementDto.getGmail());
                txtContact.setText(institutMangementDto.getContact());
                txtfb.setText(institutMangementDto.getFb());
                txtHall.setText(institutMangementDto.getHall());

            } else {
                new Alert(Alert.AlertType.INFORMATION, "Not Details").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void isClear(){
        txtGmail.clear();
        txtContact.clear();
        txtfb.clear();
        txtHall.clear();

    }

    public void btnNoticeOnAction(ActionEvent actionEvent) throws IOException {
        AncShadule1.getChildren().clear();
        AncShadule1.getChildren().add(FXMLLoader.load(getClass().getResource("/View/NoticeForm.fxml")));
    }

}
