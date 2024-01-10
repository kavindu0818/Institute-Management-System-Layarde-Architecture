package lk.ijse.Controller.Employee;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.Controller.regex.Regex;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.bo.custom.SubjectBO;
import lk.ijse.bo.custom.TutorBO;
import lk.ijse.bo.custom.impl.SubjectBOImpl;
import lk.ijse.bo.custom.impl.TutorBOImpl;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dto.SubjectDto;
import lk.ijse.dto.TutorDto;
import lk.ijse.dao.custom.impl.SubjectDAOImpl;
import lk.ijse.dao.custom.impl.TutorDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class ToutorAddFormController {
    public JFXTextField txtTutorID;
    public JFXTextField txtTutorName;
    public JFXComboBox cmbSSubjectID;
    public JFXTextField txtUpdateTutorID;
    public JFXTextField txtUpTutorName;
    public JFXComboBox cmbUpSubjectID;
    public JFXTextField txtSearchTutorID;
    public JFXTextField txtUpdateSubID;


    TutorBO tutorBO =  (TutorBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.TUTOR);

    SubjectBO subjectBO =  (SubjectBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.SUBJECT);

    public void initialize() throws SQLException, ClassNotFoundException {
        setSubId();

    }

    public void btnAddTutorOnAction(ActionEvent actionEvent) {
        if (isCheckValue()) {
            String tutID = txtTutorID.getText();
            String tutName = txtTutorName.getText();
            String subID = (String) cmbSSubjectID.getValue();

            if (tutID.isEmpty()||tutName.isEmpty()||subID.isEmpty()){
                new Alert(Alert.AlertType.ERROR, "Field Not found").showAndWait();
                return;
            }

            var td = new TutorDto(tutID, tutName, subID);

            try {
                boolean isSave = tutorBO.saveTutorBO(td);

                if (isSave) {
                    new Alert(Alert.AlertType.INFORMATION, "Save Tutor").show();

                } else {
                    new Alert(Alert.AlertType.WARNING, "Tutor Not Save Try Again").show();

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private boolean isCheckValue() {
        if (!(Regex.getToutorcodePattern().matcher(txtTutorID.getText()).matches())) {
            new Alert(Alert.AlertType.WARNING,"Tutor ID Not Valid").show();
            return false;
        }
        if (!(Regex.getNamePattern().matcher(txtTutorName.getText()).matches())) {
            new Alert(Alert.AlertType.WARNING,"Tutor Name Not Valid").show();
            return false;
        }
        if (!(Regex.getSubjectCodePattern().matcher(txtUpdateSubID.getText()).matches())) {
            new Alert(Alert.AlertType.WARNING,"Subject ID Not Valid").show();
            return false;
        }
        return true;
    }

    public void btnUpddateOnAction(ActionEvent actionEvent) {
        String tId = txtUpdateTutorID.getText();
        String tName = txtUpTutorName.getText();
        String sId = txtUpdateSubID.getText();

        var td = new TutorDto(tId,tName,sId);
        try{
            boolean isSave = tutorBO.updateTutorBO(td);

            if (isSave){
                    new Alert(Alert.AlertType.INFORMATION,"Update Save").show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Not Update Try Agin").show();
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void setSubId() throws SQLException, ClassNotFoundException {
        var sub = new SubjectDAOImpl();

        List<SubjectDto> dtoList = subjectBO.getSubjectBO();

        for(SubjectDto dto : dtoList ){
            cmbSSubjectID.getItems().add(dto.getSub_id());

        }

    }

   /* public void setUpSubId() throws SQLException {
        var sub = new SubjectModel();

        List<SubjectDto> dtoList = sub.getSubject();

        for(SubjectDto dto : dtoList ){
            cmbUpSubjectID.getItems().add(dto.getSub_id());

        }

    }*/



    public void txtSearchTutorOnAction(ActionEvent actionEvent) {
        String tutId = txtSearchTutorID.getText();
        try{
            TutorDto td = tutorBO.getTutorBO(tutId);

            if(td != null){
                txtUpdateTutorID.setText(td.getTut_id());
                txtUpTutorName.setText(td.getTutorName());
                txtUpdateSubID.setText(td.getSub_id());

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
