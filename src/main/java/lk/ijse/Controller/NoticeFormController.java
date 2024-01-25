package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.dto.NoticeDto;
import lk.ijse.dao.custom.impl.NoticeDAOImpl;

import java.sql.SQLException;

public class NoticeFormController {
    public javafx.scene.control.DatePicker DatePicker;
    public JFXTextArea txtNotice;

    private NoticeDAOImpl nm = new NoticeDAOImpl();

    public void btnNoticeOnAction(ActionEvent actionEvent) {
        String nt = txtNotice.getText();
        String day = String.valueOf(DatePicker.getValue());

        var nd = new NoticeDto(nt,day);

        try {
            boolean isSave = nm.setNotice(nd);

            if (isSave){
                new Alert(Alert.AlertType.INFORMATION,"Save Notice").show();

            }else{
                new Alert(Alert.AlertType.WARNING,"Not Save Notice").show();
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        txtNotice.clear();
    }
}
