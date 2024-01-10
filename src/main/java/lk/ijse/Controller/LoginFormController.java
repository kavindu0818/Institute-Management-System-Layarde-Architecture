package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Controller.DashBoard.DashBoardController;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.ClassBO;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.bo.custom.impl.UserBOImpl;
import lk.ijse.dto.UserDto;
import lk.ijse.dao.custom.impl.UserDAOImpl;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public AnchorPane root;
    public TextField txtUserName;
    public TextField txtPassword;
    public JFXTextField txtUserNameID;

    public static String pasw;


    UserBO userBO = (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.USER);

    public void logOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

        String userName = txtUserNameID.getText();
        String passwrd = txtPassword.getText();

        pasw = passwrd;

        UserDto dto = userBO.selectUserValueBo();

        if (dto != null) {
            String pw = dto.getPassword();
            String un = dto.getUserName();

            if (pw.equals(passwrd) && un.equals(userName)) {
                loginDashboard();

            } else {
                new Alert(Alert.AlertType.WARNING, "Check Your Password And userName").show();
            }
        }

    }

    public static String getpasw(){
        return pasw;
    }

    public void loginDashboard() throws IOException {

        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/DashBoard.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("DashBoard Manage");
        stage.centerOnScreen();
        stage.show();
    }
}
