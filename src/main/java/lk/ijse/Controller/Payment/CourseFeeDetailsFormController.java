package lk.ijse.Controller.Payment;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.Tm.CourseDetailsTm;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.Course_DetailsBO;
import lk.ijse.bo.custom.impl.Course_DetailsBOImpl;
import lk.ijse.dto.Course_detailsDto;
import lk.ijse.dao.custom.impl.Course_detailsDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class CourseFeeDetailsFormController {
    public static TableView<CourseDetailsTm> tblCourseDetails;
    public TableColumn colCusDetilStuId;
    public TableColumn colCusDetilStuName;
    public TableColumn colCusDetilPayMonth;
    public TableColumn colCusDetilDate;
    public TableColumn colCusDetilPayAmont;
    public JFXTextField txtCurseDetailsSearchCusId;



    Course_DetailsBO courseDetailsBO = (Course_DetailsBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.COURSE_DETAILS);;


    public void initialize() {
        setCellValueFactory();
    }

    private void setCellValueFactory() {

        colCusDetilStuId.setCellValueFactory(new PropertyValueFactory<>("Cus_Id"));
        colCusDetilStuName.setCellValueFactory(new PropertyValueFactory<>("stu_id"));
        colCusDetilPayMonth.setCellValueFactory(new PropertyValueFactory<>("stu_Name"));
        colCusDetilDate.setCellValueFactory(new PropertyValueFactory<>("cus_Name"));
        colCusDetilPayAmont.setCellValueFactory(new PropertyValueFactory<>("amount"));


    }


    public void CurseSearchOnAction(ActionEvent actionEvent) throws SQLException {
      String cd = txtCurseDetailsSearchCusId.getText();
        System.out.println(cd);

        ObservableList<CourseDetailsTm> obList  = FXCollections.observableArrayList();

        try {
            List<Course_detailsDto> dtoList = courseDetailsBO.getAllCourseValueBO(cd);

            System.out.println(dtoList.toString());
            for (Course_detailsDto dto : dtoList) {
                obList.add(
                        new CourseDetailsTm(
                                dto.getCusId(),
                                dto.getStuId(),
                                dto.getStuName(),
                                dto.getCusName(),
                                dto.getPaidCusFee()

                        )
                );
            }
            System.out.println("Athi"+ obList);
            tblCourseDetails.setItems(obList);
            tblCourseDetails.refresh();


       } catch (SQLException e) {
           throw new RuntimeException(e);
       } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

        public void btnCloseOnAction(ActionEvent actionEvent) {

    }

            // Use try-with-resources to automatically close resources






    }


