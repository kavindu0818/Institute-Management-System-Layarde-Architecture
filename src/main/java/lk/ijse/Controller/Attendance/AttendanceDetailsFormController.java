package lk.ijse.Controller.Attendance;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Tm.AttendanceDetailsViewTm;
import lk.ijse.Tm.ClassDetailsViewTm;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.ClassBO;
import lk.ijse.bo.custom.StudentAttendanceBO;
import lk.ijse.bo.custom.impl.ClassBOImpl;
import lk.ijse.bo.custom.impl.StudentAttendanceBOImpl;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dto.ClassDto;
import lk.ijse.dto.StudentAttendance;
import lk.ijse.dao.custom.impl.ClassDAOImpl;
import lk.ijse.dao.custom.impl.Stu_AttendanceDAOImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class AttendanceDetailsFormController {
    public TableView tblAttendanceView;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colAttendnceDate;
    public TableColumn colAttendanceTime;
    public TableColumn ColAttendanceMarkId;
    public TableView tblClassDetailsView;
    public TableColumn colClassId;
    public TableColumn colClassName;
    public DatePicker txtAttendanceDate;
    public TextField txtSerachAttendnceClass;
    public ComboBox cmbSubjectID;
    public AnchorPane AncClassAttendance;


    StudentAttendanceBO studentAttendanceBO = (StudentAttendanceBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.STU_ATTENDANCE);


    ClassBO classBO = (ClassBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CLASS);

    public void initialize(){
        setClassIDcmb();
        loadAllStudent();
        setTableclass();
        studentAttendanceDetails();

    }

    public void studentAttendanceDetails(){
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("StuId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("stu_name"));
        colAttendnceDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colAttendanceTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        ColAttendanceMarkId.setCellValueFactory(new PropertyValueFactory<>("amId"));
    }

    public void setTableclass(){
        colClassId.setCellValueFactory(new PropertyValueFactory<>("clssId"));
        colClassName.setCellValueFactory(new PropertyValueFactory<>("clssName"));

    }

    public void SearchClassAndDateOnAction(ActionEvent actionEvent) {
        String classID = (String) cmbSubjectID.getValue();
       // Date classDate = (Date) txtAttendanceDate.getDayCellFactory();
        LocalDate classDate = txtAttendanceDate.getValue();


        ObservableList<AttendanceDetailsViewTm> obList = FXCollections.observableArrayList();


        try {
            List<StudentAttendance> dtoList = studentAttendanceBO.getClassStudentDetails(classID, classDate);
            for (StudentAttendance dto : dtoList) {
                obList.add(
                        new AttendanceDetailsViewTm(
                                dto.getStu_id(),
                                dto.getName(),
                                dto.getDate(),
                                dto.getTime(),
                                dto.getFull_id()

                        )
                );


                tblAttendanceView.setItems(obList);
                tblAttendanceView.refresh();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAllStudent() {
        var model = new Stu_AttendanceDAOImpl();

        ObservableList<ClassDetailsViewTm> obList = FXCollections.observableArrayList();

        try {
            List<ClassDto> dtoList = classBO.getAllClassDetails();

            for (ClassDto dto : dtoList) {
                obList.add(
                        new ClassDetailsViewTm(
                                dto.getClass_id(),
                                dto.getClassName()

                        )
                );
            }

            tblClassDetailsView.setItems(obList);
            tblClassDetailsView.refresh();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void setClassIDcmb() {
        var model = new ClassDAOImpl();

        try {
            List<ClassDto> dtoList = classBO.getAllClassDetails();

            for (ClassDto classDto : dtoList) {
                cmbSubjectID.getItems().add(classDto.getClass_id());

            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        AncClassAttendance.getChildren().clear();
        AncClassAttendance.getChildren().add(FXMLLoader.load(getClass().getResource("/View/AttendanceForm.fxml")));


    }
}
