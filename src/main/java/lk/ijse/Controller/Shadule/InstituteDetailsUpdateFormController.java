package lk.ijse.Controller.Shadule;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.bo.custom.impl.InstituteDetailsBOImpl;
import lk.ijse.dto.InstitutMangementDto;
import lk.ijse.dao.custom.impl.InstituteDetailsDAOImpl;

import java.sql.SQLException;

public class InstituteDetailsUpdateFormController {

    public JFXTextField txtGmail;
    public JFXTextField txtContact;
    public JFXTextField txtfb;
    public JFXTextField txtHall;

    private InstituteDetailsDAOImpl ins = new InstituteDetailsDAOImpl();

    InstituteDetailsBOImpl instituteDetailsBO = new InstituteDetailsBOImpl();

    public void initialize(){
        setText();
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
        }
    }

    public void btnUpdateSubmitOkOnAction(ActionEvent actionEvent) {
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
        }


    }

    public void isClear(){
        txtGmail.clear();
        txtContact.clear();
        txtfb.clear();
        txtHall.clear();

    }
}
