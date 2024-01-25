package lk.ijse.Controller.Employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.ijse.Tm.EmployeeViewTm;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dto.EmployeeDto;
import lk.ijse.dao.custom.impl.EmployeeDAOImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeFormController {
    public AnchorPane EmployeeMain;
    public Pane AncEmployeeRoot;
    public AnchorPane AncEmployeeRoot1;
    public TableView tblEmployeeview;
    public TableColumn colEmpID;
    public TableColumn colEmpName;
    public Label lblEmpCount;

    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    public void initialize() {

        colEmpID.setCellValueFactory(new PropertyValueFactory<>("EmpId"));
        colEmpName.setCellValueFactory(new PropertyValueFactory<>("EmpName"));
        AllEmployee();
        setLableEmp();

    }

    public void btnAddEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        AncEmployeeRoot1.getChildren().clear();
        AncEmployeeRoot1.getChildren().add(FXMLLoader.load(getClass().getResource("/View/EmployeeAddForm.fxml")));

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        AncEmployeeRoot1.getChildren().clear();
        AncEmployeeRoot1.getChildren().add(FXMLLoader.load(getClass().getResource("/View/EmployeeUpdateForm.fxml")));
    }

    public void btnEmployeeDetailsOnAction(ActionEvent actionEvent) throws IOException {
        AncEmployeeRoot1.getChildren().clear();
        AncEmployeeRoot1.getChildren().add(FXMLLoader.load(getClass().getResource("/View/EmployeeDetailsForm.fxml")));

    }

    public void AllEmployee() {

        var model = new EmployeeDAOImpl();


        ObservableList<EmployeeViewTm> obList = FXCollections.observableArrayList();

        try {
            List<EmployeeDto> dtoList = employeeBO.getAllEmployeeBO();

            for (EmployeeDto dto : dtoList) {
                obList.add(
                        new EmployeeViewTm(
                                dto.getEmp_id(),
                                dto.getName()

                        )
                );
            }

            tblEmployeeview.setItems(obList);
            tblEmployeeview.refresh();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void setLableEmp() {
        var model = new EmployeeDAOImpl();

        try {
            int count = employeeBO.howMachEmployeeBO();

            lblEmpCount.setText(String.valueOf(count));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnAddTutorOnAction(ActionEvent actionEvent) throws IOException {
        AncEmployeeRoot1.getChildren().clear();
        AncEmployeeRoot1.getChildren().add(FXMLLoader.load(getClass().getResource("/View/ToutorAddForm.fxml")));


    }
}

