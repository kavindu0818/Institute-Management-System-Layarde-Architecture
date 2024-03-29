package lk.ijse.Controller.Shadule;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.ClassBO;
import lk.ijse.bo.custom.SubjectBO;
import lk.ijse.bo.custom.impl.SubjectBOImpl;
import lk.ijse.dto.SubjectDto;
import lk.ijse.dao.custom.impl.SubjectDAOImpl;

import java.sql.SQLException;

public class AddSubjectFormController {
    public JFXTextField txtSubId;
    public JFXTextField txtSubName;

    SubjectBO subjectBO = (SubjectBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.SUBJECT);

    public void btnAddSubjectOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String subID = txtSubId.getText();
        String subName = txtSubName.getText();

        var sub = new SubjectDto(subID,subName);


        boolean isSave = subjectBO.subSaveBO(sub);

        if (isSave){
            new Alert(Alert.AlertType.INFORMATION,"Subject Save").show();;

        }else{
            new Alert(Alert.AlertType.WARNING,"Try Again Not Save Subject").show();
        }

    }
}
