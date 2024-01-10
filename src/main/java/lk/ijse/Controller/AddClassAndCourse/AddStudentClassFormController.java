package lk.ijse.Controller.AddClassAndCourse;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Controller.regex.Regex;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.ClassBO;
import lk.ijse.bo.custom.Class_DetailsBO;
import lk.ijse.bo.custom.impl.ClassBOImpl;
import lk.ijse.bo.custom.impl.Class_DetailsBOImpl;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dto.ClassDto;
import lk.ijse.dto.Class_DetailsDto;
import lk.ijse.dao.custom.impl.ClassDAOImpl;
import lk.ijse.dao.custom.impl.Class_DetailsDAOImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AddStudentClassFormController {
    public JFXTextField txtStudentID;
    public JFXComboBox cmbClassID;
    public JFXComboBox cmbClassName;
    public JFXTextField txtAttenAndPay;
    public JFXTextField txtStudentName;



    ClassBO classBO = (ClassBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CLASS);
    Class_DetailsBO classDetailsBO = (Class_DetailsBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CLASS_DETAILS);

    public void initialize(){
        setClassIDcmb();
    }


    public void setClassIDcmb() {
        var model = new ClassDAOImpl();

        try {
            List<ClassDto> dtoList = classBO.getAllClassRegister();

            for (ClassDto classDto : dtoList) {
                cmbClassID.getItems().add(classDto.getClass_id());
             //   cmbClassName.getItems().add(classDto.getClassName());
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    public void AddClassStudentOnAction(ActionEvent actionEvent){
        if(isCheckValue()){
            String stuID = txtStudentID.getText();
            String classID = (String) cmbClassID.getValue();
            String stuName = txtStudentName.getText();
            String fullID = txtAttenAndPay.getText();

            var ad = new Class_DetailsDto(fullID, stuID, classID, stuName);

            try {
                boolean isSaved = classDetailsBO.saveClassDetailsStudemt(ad);
                if (isSaved) {
                    new Alert(Alert.AlertType.INFORMATION, "Add class Details").show();
                    clean();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Not Add Details").show();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


    }
    private boolean isCheckValue(){
        if (!(Regex.getCodePattern().matcher(txtStudentID.getText()).matches())) {
            new Alert(Alert.AlertType.WARNING,"Student ID Not Valid").show();
            return false;
        }
        if (!(Regex.getClassIDPattern().matcher(txtAttenAndPay.getText()).matches())) {
            new Alert(Alert.AlertType.WARNING,"Attenddance ID Not Valid").show();
            return false;
        }
        if (!(Regex.getNamePattern().matcher(txtStudentName.getText()).matches())) {
            new Alert(Alert.AlertType.WARNING,"Student Name Not Valid").show();
            return false;
        }
        return true;

    }

    public void clean(){
        txtStudentID.clear();
        txtStudentName.clear();
        txtAttenAndPay.clear();
    }


    public void btnQrGenaratorOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/QrGenarateForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("User Manage");
        stage.centerOnScreen();
        stage.show();

    }

}

