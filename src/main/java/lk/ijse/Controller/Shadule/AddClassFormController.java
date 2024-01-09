package lk.ijse.Controller.Shadule;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.bo.custom.impl.ClassBOImpl;
import lk.ijse.dto.ClassDto;
import lk.ijse.dao.custom.impl.ClassDAOImpl;

import java.sql.SQLException;

public class AddClassFormController {
    public JFXTextField txtClassId;
    public JFXTextField txtClassName;
    public JFXTextField txtTutorId;

    private ClassDAOImpl cm = new ClassDAOImpl();

    ClassBOImpl classBO = new ClassBOImpl();
    public void btnSaveClassOnAction(ActionEvent actionEvent) {
        String classId = txtClassId.getText();
        String className = txtClassName.getText();
        String tutorId = txtTutorId.getText();

        var cms = new ClassDto(classId,tutorId,className);

        try {
            boolean isSaved = classBO.classSaveBO(cms);

            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Add class").show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Not Add Class pleace Try Again").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
