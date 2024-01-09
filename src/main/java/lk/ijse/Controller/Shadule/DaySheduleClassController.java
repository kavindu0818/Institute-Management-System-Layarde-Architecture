package lk.ijse.Controller.Shadule;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import lk.ijse.bo.custom.impl.ClassBOImpl;
import lk.ijse.bo.custom.impl.DaySheduleBoImpl;
import lk.ijse.dto.ClassDto;
import lk.ijse.dto.DaySheduleDto;
import lk.ijse.dao.custom.impl.ClassDAOImpl;
import lk.ijse.dao.custom.impl.DaySheduleDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class DaySheduleClassController {
    public TextField txtStartTime;
    public ComboBox cmbClassName;
    public DatePicker dateDatePic;
    public TextField txtEndTime;

    private DaySheduleDAOImpl ds = new DaySheduleDAOImpl();
    DaySheduleBoImpl daySheduleBo = new DaySheduleBoImpl();

    ClassBOImpl classBO = new ClassBOImpl();

    public void initialize() {
        setClassIDcmb();
    }

    public void btnAddSheduleOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String className = (String) cmbClassName.getValue();
        String sTime = txtStartTime.getText();
        String eTime = txtEndTime.getText();
        String date = String.valueOf(dateDatePic.getValue());

        var day = new DaySheduleDto(className,date,sTime,eTime);
        boolean isSave = daySheduleBo.saveValuesBO(day);
        if (isSave){
            new Alert(Alert.AlertType.INFORMATION,"Save shedule").show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Not Save shedule").show();
        }

    }

    public void setClassIDcmb() {
        var model = new ClassDAOImpl();

        try {
            List<ClassDto> dtoList = classBO.getAllClassBO();

            for (ClassDto classDto : dtoList) {
                cmbClassName.getItems().add(classDto.getClass_id());
                // cmbClassName.getItems().add(classDto.getClassName());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
