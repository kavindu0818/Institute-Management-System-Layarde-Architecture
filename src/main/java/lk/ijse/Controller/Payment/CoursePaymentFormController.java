package lk.ijse.Controller.Payment;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.CourseBO;
import lk.ijse.bo.custom.Course_DetailsBO;
import lk.ijse.bo.custom.impl.CourseBoImpl;
import lk.ijse.bo.custom.impl.Course_DetailsBOImpl;
import lk.ijse.dto.CourseDto;
import lk.ijse.dto.Course_detailsDto;
import lk.ijse.dao.custom.impl.CourseDAOImpl;
import lk.ijse.dao.custom.impl.Course_detailsDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class CoursePaymentFormController {
    public JFXTextField txtSearchStuID;
    public Label lblStuName;
    public Label lblCourseID;
    public Label lblCourse;
    public Label lblCourseDetailsID;
    public Label lblAmount;
    public Label lblStuID;
    public Button OkOnAction;
    public JFXComboBox cmbCourseID;
    public AnchorPane AncCourse3;
    Course_DetailsBO courseDetailsBO = (Course_DetailsBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.COURSE_DETAILS);
    CourseBO courseBo = (CourseBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.COURSE);

    public void initialize(){
        setComboBoxValue();
    }

    public void OkOnAction(ActionEvent actionEvent) {
        txtSearchStuID.clear();


    }

    public void BackOnAction(ActionEvent actionEvent) {
        AncCourse3.getChildren().clear();

    }

    public void txtOnAction(ActionEvent actionEvent) {


    }

    public void SearchOnAction(ActionEvent actionEvent) {
        String id = txtSearchStuID.getText();
        String cusID = (String) cmbCourseID.getValue();

        try {
            Course_detailsDto dto = courseDetailsBO.getAllDetailsBO(id,cusID);

            if(dto != null){
                lblStuID.setText(dto.getStuId());
                lblStuName.setText(dto.getStuName());
                lblCourseID.setText(dto.getCusId());
                lblCourse.setText(dto.getCusName());
                lblCourseDetailsID.setText(dto.getCusDfull());
                lblAmount.setText(String.valueOf(dto.getPaidCusFee()));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void setComboBoxValue(){
        var course = new CourseDAOImpl();
        try {
            List<CourseDto> dtoList = courseBo.getCourseIDBO();

            for (CourseDto dto : dtoList) {
                cmbCourseID.getItems().add(dto.getCusId());
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
