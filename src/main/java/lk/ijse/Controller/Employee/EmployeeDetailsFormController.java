package lk.ijse.Controller.Employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lk.ijse.Tm.EmpAttendanceDetailsTm;
import lk.ijse.bo.custom.impl.EmployeeAttendanceBOImpl;
import lk.ijse.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.dto.EmpAttendnaceDto;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.dao.custom.impl.EmployeeAttendanceDAOImpl;
import lk.ijse.dao.custom.impl.EmployeeDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDetailsFormController {
    public TextField txtSearchEmployee;
    public ImageView imageViewEmployee;
    public Label lblID;
    public Label lblName;
    public Label lblGmail;
    public Label lblAddress;
    public Label lblNic;
    public Label lblPosition;
    public Label lblRegDate;
    public Label lblConNum;
    public Label lblBankNum;
    public Label lblBankbranch;
    public Label lblAge;
    public Label lblGendar;
    public TableView tblAttendanceEmployee;
    public TableColumn colAttendanceID;
    public TableColumn colDay;
    public TableColumn colTime;

    private EmployeeDAOImpl em = new EmployeeDAOImpl();
    private EmployeeAttendanceDAOImpl ea = new EmployeeAttendanceDAOImpl();

    EmployeeBOImpl employeeBO = new EmployeeBOImpl();
    EmployeeAttendanceBOImpl employeeAttendanceBO = new EmployeeAttendanceBOImpl();

    public void initialize(){
        setViewEmployeeAttendance();

    }

    private void setViewEmployeeAttendance() {
        colAttendanceID.setCellValueFactory(new PropertyValueFactory<>("attendnceId"));
        colDay.setCellValueFactory(new PropertyValueFactory<>("day"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));

    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String empId = txtSearchEmployee.getText();

        try {
            EmployeeDto dto = employeeBO.allEmployeeDetailsBO(empId);

            if ( dto != null) {
                lblID.setText(dto.getEmp_id());
                lblName.setText(dto.getName());
                lblAddress.setText(dto.getAddress());
                lblNic.setText(dto.getNic());
                lblGmail.setText(dto.getGmail());
                lblConNum.setText(dto.getContactNo());
                lblPosition.setText(dto.getPosition());
                lblRegDate.setText(dto.getDate());
                lblBankbranch.setText(dto.getBankBranchName());
                String age = String.valueOf(dto.getAge());
                lblAge.setText(age);
                lblBankNum.setText(dto.getBankAccountNum());
                Image fxImage = em.convertBytesToJavaFXImage(dto.getImage());
                imageViewEmployee.setImage(fxImage);
                lblGendar.setText(dto.getGendar());

            } else {
                new Alert(Alert.AlertType.INFORMATION, "Employee not found").show();
            }
            setAttendanceEmployee();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setAttendanceEmployee(){
       String id = txtSearchEmployee.getText();
        ObservableList<EmpAttendanceDetailsTm> obList = FXCollections.observableArrayList();

        try {
            List<EmpAttendnaceDto> dtoList = employeeAttendanceBO.getAllEmployeeAttendanceBO(id);

            for (EmpAttendnaceDto dto : dtoList) {
                obList.add(
                        new EmpAttendanceDetailsTm(
                                dto.getAttenMarkId(),
                                dto.getDate(),
                                dto.getTime()

                        )
                );
            }

            tblAttendanceEmployee.setItems(obList);
            tblAttendanceEmployee.refresh();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnOKOnAction(ActionEvent actionEvent) {



    }

}
