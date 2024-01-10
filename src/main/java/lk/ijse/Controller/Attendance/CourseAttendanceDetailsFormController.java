package lk.ijse.Controller.Attendance;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Tm.CourseAttendnaceTm;
import lk.ijse.Tm.CourseDetailsViewTm;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.CourseBO;
import lk.ijse.bo.custom.Course_AttendanceBO;
import lk.ijse.bo.custom.impl.CourseBoImpl;
import lk.ijse.bo.custom.impl.Course_AttendanceBOImpl;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dto.CourseAttendanceJoinDto;
import lk.ijse.dto.CourseDto;
import lk.ijse.dao.custom.impl.CourseAttendanceDAOImpl;
import lk.ijse.dao.custom.impl.CourseDAOImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CourseAttendanceDetailsFormController {
    public TableView tblCourseAttendanceDetails;
    public TableColumn colStuID;
    public TableColumn colStuName;
    public TableColumn colDate;
    public TableColumn colTime;
    public TableColumn colAttendanceMarkID;
    public TableView tblCourseDetails;
    public TableColumn colCourseID;
    public TableColumn colCourseName;
    public ComboBox cmbCourseID;
    public DatePicker DatePiker;
    public AnchorPane AncCourseAttendance;




    Course_AttendanceBO courseAttendanceBO = (Course_AttendanceBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.COURSEATTENDANCE);

    CourseBO courseBo = (CourseBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.COURSE);


    public void initialize(){
        setDatacmb();
        getAllCourse();
        setViewCourseDetails();
        setViewCourseAttendance();

    }

    private void setViewCourseAttendance() {
        colStuID.setCellValueFactory(new PropertyValueFactory<>("stuID"));
        colStuName.setCellValueFactory(new PropertyValueFactory<>("stuName"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colAttendanceMarkID.setCellValueFactory(new PropertyValueFactory<>("attendnceId"));

    }

    private void setViewCourseDetails() {
        colCourseID.setCellValueFactory(new PropertyValueFactory<>("courseID"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));


    }

    private void setDatacmb() {
        var cm = new CourseDAOImpl();

        try {
            List<CourseDto> dtoList = courseBo.getAllcourseIDBO();

            for (CourseDto dto : dtoList) {
                cmbCourseID.getItems().add(dto.getCusId());

            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAllCourse(){
        var model = new CourseDAOImpl();

        ObservableList<CourseDetailsViewTm> obList = FXCollections.observableArrayList();

        try {
            List<CourseDto> dtoList = courseBo.getAllcourseIDBO();

            for (CourseDto dto : dtoList) {
                obList.add(
                        new CourseDetailsViewTm(
                                dto.getCusId(),
                                dto.getCusName()


                        )
                );
            }

            tblCourseDetails.setItems(obList);
            tblCourseDetails.refresh();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void AttendanceDetailsSearchOnAction(ActionEvent actionEvent) {
        String courseID = (String) cmbCourseID.getValue();
        String date = String.valueOf(DatePiker.getValue());

        ObservableList<CourseAttendnaceTm> obList = FXCollections.observableArrayList();

        try {
            List<CourseAttendanceJoinDto> dtoList = courseAttendanceBO.getAllCourseAttendanceBO(courseID,date);

            for (CourseAttendanceJoinDto dto : dtoList) {
                obList.add(
                        new CourseAttendnaceTm(
                                dto.getStuID(),
                                dto.getStuName(),
                                dto.getDate(),
                                dto.getTime(),
                                dto.getAttendnceID()

                        )
                );
            }

            tblCourseAttendanceDetails.setItems(obList);
            tblCourseAttendanceDetails.refresh();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        AncCourseAttendance.getChildren().clear();
        AncCourseAttendance.getChildren().add(FXMLLoader.load(getClass().getResource("/View/AttendanceForm.fxml")));

    }
}
