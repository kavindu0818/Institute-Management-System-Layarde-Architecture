package lk.ijse.Controller.Attendance;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Controller.Gmail.GmailMain;
import lk.ijse.Tm.AttendanceTm;
import lk.ijse.Tm.EmployeeAttendanceTm;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.*;
import lk.ijse.bo.custom.impl.*;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.impl.*;
import lk.ijse.dto.*;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AttendanceFormController {


    public AnchorPane mainPane;
    public AnchorPane miniPane;
    public TextField txtScannerValue;
    public Label ScannerLable;
    public TableView<AttendanceTm> AttendanceViewTable;
    public TableColumn AttendIdCol;
    public TableColumn stuIdcol;
    public TableColumn stuNamecol;
    public TableColumn Datecol;
    public TableColumn Timecol;
    public TableColumn clssIdcol;
    public AnchorPane Ancrootattrndnce;
    public TableView tblEmployeeAttendance;
    public TableColumn colEmpID;
    public TableColumn colEmployeeName;
    public Label lblNomalClassStu;
    public Label lblCourseStu;
    public Label lbllEmployeeCount;
    private Webcam webcam;
    private WebcamPanel webcamPanel;
    private boolean isReading = false;
    private String num;
    private String num1;

    public String stuId;
    public String perGmail;
    public String stuGmail;
    public String clName;



    private GmailMain gm = new GmailMain();

    Course_DetailsBO courseDetailsBO = (Course_DetailsBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.COURSE_DETAILS);
    StudentDetailsBO studentDetailsBO = (StudentDetailsBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.STUDENT_DETAILS);
    StudentAttendanceBO studentAttendanceBO = (StudentAttendanceBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.STU_ATTENDANCE);
    Course_AttendanceBO courseAttendanceBO = (Course_AttendanceBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.COURSEATTENDANCE);
    EmployeeAttendanceBO employeeAttendanceBO = (EmployeeAttendanceBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.EMPLOYEEATTENDANCE);
    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.EMPLOYEE);
    Class_DetailsBO classDetailsBO = (Class_DetailsBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CLASS_DETAILS);



    public void initialize() {
        setCellValueFactory();
        loadAllAttendnce();
        generateNextOrderId();
        generateAttendanceID();
        loadAllCourseAttendance();
        loadAllEmployeeAttendance();
        setEmployeeAttendance();
        setLableStuddentNomal();

    }

    private void setCellValueFactory() {
        AttendIdCol.setCellValueFactory(new PropertyValueFactory<>("regId"));
        stuIdcol.setCellValueFactory(new PropertyValueFactory<>("stuId"));
        stuNamecol.setCellValueFactory(new PropertyValueFactory<>("stuName"));
        Datecol.setCellValueFactory(new PropertyValueFactory<>("date"));
        Timecol.setCellValueFactory(new PropertyValueFactory<>("time"));
        clssIdcol.setCellValueFactory(new PropertyValueFactory<>("classId"));


    }

    private void setEmployeeAttendance(){
        colEmpID.setCellValueFactory(new PropertyValueFactory<>("empID"));
        colEmployeeName.setCellValueFactory(new PropertyValueFactory<>("empName"));


    }


    private void loadAllAttendnce() {
        var model = new Stu_AttendanceDAOImpl();

        ObservableList<AttendanceTm> obList = FXCollections.observableArrayList();

        try {
            List<StudentAttendance> dtoList = studentAttendanceBO.getAllStudentAttendance();

            for (StudentAttendance dto : dtoList) {
                obList.add(
                        new AttendanceTm(
                                dto.getFull_id(),
                                dto.getStu_id(),
                                dto.getName(),
                                dto.getDate(),
                                dto.getTime(),
                                dto.getClass_id()
                        )
                );
            }

            AttendanceViewTable.setItems(obList);
            AttendanceViewTable.refresh();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAllCourseAttendance() {
        var model = new CourseAttendanceDAOImpl();

        ObservableList<AttendanceTm> obList = FXCollections.observableArrayList();

        try {
            List<AttendanceJoinDto> dtoList = courseAttendanceBO.getAllAttndanceCourse();

            for (AttendanceJoinDto dto : dtoList) {
                obList.add(
                        new AttendanceTm(
                                dto.getAttendanceID(),
                                dto.getStuID(),
                                dto.getStuName(),
                                dto.getDate(),
                                dto.getTime(),
                                dto.getCusID()

                        )
                );
            }

            AttendanceViewTable.setItems(obList);
            AttendanceViewTable.refresh();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAllEmployeeAttendance() {
        var model = new EmployeeAttendanceDAOImpl();

        ObservableList<EmployeeAttendanceTm> obList = FXCollections.observableArrayList();

        try {
            List<EmployeeAttendanceJoin> dtoList = employeeAttendanceBO.getAllEmployeeAttndanceAll();

            for (EmployeeAttendanceJoin dto : dtoList) {
                obList.add(
                        new EmployeeAttendanceTm(
                                dto.getEmpID(),
                                dto.getEmpName()


                        )
                );
            }

            tblEmployeeAttendance.setItems(obList);
            tblEmployeeAttendance.refresh();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }




    private boolean startWebcam() {
        if (webcam == null) {
            Dimension size = WebcamResolution.QVGA.getSize();
            webcam = Webcam.getDefault();
            webcam.setViewSize(size);

            webcamPanel = new WebcamPanel(webcam);
            webcamPanel.setPreferredSize(size);
            webcamPanel.setFPSDisplayed(true);
            webcamPanel.setMirrored(true);

            SwingNode swingNode = new SwingNode();
            swingNode.setContent(webcamPanel);

            miniPane.getChildren().clear();
            miniPane.getChildren().add(swingNode);
        }

        Thread thread = new Thread(() -> {
            while (isReading) {
                try {
                    Thread.sleep(1000);
                    BufferedImage image = webcam.getImage();
                    if (image != null) {
                        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
                        Result result = new MultiFormatReader().decode(binaryBitmap);
                        Platform.runLater(() -> {
                            if (result != null) {
                                webcam.close();
                                txtScannerValue.setText(result.getText() + "\n");
                                new Alert(Alert.AlertType.INFORMATION, "Data Scanned Successfully!").showAndWait();
                            } else {
                                new Alert(Alert.AlertType.ERROR, "No Data Found!").showAndWait();
                            }
                        });
                    }
                } catch (NotFoundException | InterruptedException | RuntimeException ignored) {
                    // ignored
                }
            }
        });
        thread.start();
        return true;
    }

    private boolean stopWebcam() {
        if (webcamPanel != null) {
            webcamPanel.stop();
            webcamPanel = null;
        }
        if (webcam != null) {
            webcam.close();
            webcam = null;
        }
        return false;
    }

    public void AttendneStarOnAction(ActionEvent actionEvent) {
        isReading = (!isReading) ? startWebcam() : stopWebcam();
    }

    public void AttendanceOffSOnAction(ActionEvent actionEvent) {
        stopWebcam();
    }

    public void txtScannerValueOnAction(ActionEvent actionEvent) {
        String aId = txtScannerValue.getText();

        String input = aId;
        String stuRegex = "^SA[0-9]{4,10}$";
        String empRegex = "^EA[0-9]{4,10}$";
        String cRegex = "^CSA[0-9]{4,10}$";

        Pattern Spattern = Pattern.compile(stuRegex);
        Pattern Epattern = Pattern.compile(empRegex);
        Pattern Cpattern = Pattern.compile(cRegex);

        Matcher Smatcher = Spattern.matcher(input);
        Matcher Ematcher = Epattern.matcher(input);
        Matcher Cmatcher = Cpattern.matcher(input);

        if (Smatcher.matches()) {
            try {
                Class_DetailsDto dtoList = classDetailsBO.loardValuesAll(aId);
                boolean isSaved = studentAttendanceBO.saveAttendnceDetailsStudent(dtoList);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Save attendance").show();
                    classsMail();
                    loadAllAttendnce();
                    setLableStuddentNomal();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Not value saved!").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (Ematcher.matches()) {
            try {
                EmployeeDto dtoList =employeeBO.loardEmpValuesDetails(aId);

                String empAttendanceID = null;
                String empId = null;
                if (dtoList != null) {
                    empAttendanceID = dtoList.getEmpAttendanceID();
                    empId = dtoList.getEmp_id();
                }

                boolean isSaved = employeeAttendanceBO.saveEmpAttendanceBo(num, empAttendanceID, empId);

                if (isSaved) {
                    new Alert(Alert.AlertType.INFORMATION, "Employee Attendance Save").show();
                    loadAllEmployeeAttendance();
                    generateAttendanceID();
                    setLableStuddentNomal();

                } else {
                    new Alert(Alert.AlertType.WARNING, "Employee Attendance Not Saved").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (Cmatcher.matches()) {
            try {
                boolean isSaved = courseAttendanceBO.saveAttendnceDetailsBo(aId, num1);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Course Attendance Save").show();
                    courseSendGmail();
                    loadAllCourseAttendance();
                    generateNextOrderId();
                    setLableStuddentNomal();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Course Attendance Not Value Saved!").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Not Valid ID").show();
        }
    }

    public void classsMail() throws SQLException, ClassNotFoundException {
        String atId = txtScannerValue.getText();

        try {
            Class_DetailsDto dto = classDetailsBO.getsendMailValueAll(atId);

            if(dto != null){
                stuId = dto.getStu_id();
                clName = dto.getClass_id();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


           StudentfullDetailsDto sdto = studentDetailsBO.getClassMailValueAll(stuId);


        if (sdto != null){
            perGmail = sdto.getPerant_Gmail();
        }

        String from ="kavindumaduranga184@gmail.com";
        String title ="Class Attendance";
        String msg = "Your Student Attend Into Sahaja Class" + clName ;

        gm.addGmailDEtails(from,perGmail,title,msg);

    }

    public void courseSendGmail() throws SQLException, ClassNotFoundException {
        String csId = txtScannerValue.getText();

        try {
            Course_detailsDto dto = courseDetailsBO.getsendMailValueAll(csId);

            if(dto != null){
                stuId = dto.getStuId();
                clName = dto.getCusName();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        StudentfullDetailsDto sdto = studentDetailsBO.getClassMailValueBO(stuId);


        if (sdto != null){
            perGmail = sdto.getPerant_Gmail();
        }

        String from ="kavindumaduranga184@gmail.com";
        String title ="Course Attendance";
        String msg = "Your Student Attend Into Sahaja Institute" + clName ;

        gm.addGmailDEtails(from,perGmail,title,msg);


    }


    private void generateNextOrderId() {
        try {
            int orderID =courseAttendanceBO.generateNextOrderIdBO();
            num1="000"+orderID;
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void generateAttendanceID() {
        try {
            int orderID = employeeAttendanceBO.generateNextOrderIdBO();
            num="000"+orderID;
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    public void btnAttendanceDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Ancrootattrndnce.getChildren().clear();
        Ancrootattrndnce.getChildren().add(FXMLLoader.load(getClass().getResource("/View/AttendanceDetailsForm.fxml")));

    }

    public void setLableStuddentNomal() {
        var model = new Stu_AttendanceDAOImpl();

        try {
            int count = model.howMachStudent();

            lblNomalClassStu.setText(String.valueOf(count));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        var Cmodel = new CourseAttendanceDAOImpl();

        try {
            int count = courseAttendanceBO.howMachCourseStudentBo();

            lblCourseStu.setText(String.valueOf(count));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        var Emodel = new EmployeeAttendanceDAOImpl();

        try {
            int count = Emodel.howMachEmployeeAttendance();

            lbllEmployeeCount.setText(String.valueOf(count));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void btnCourseAttendanceDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Ancrootattrndnce.getChildren().clear();
        Ancrootattrndnce.getChildren().add(FXMLLoader.load(getClass().getResource("/View/CourseAttendanceDetailsForm.fxml")));

    }
}
