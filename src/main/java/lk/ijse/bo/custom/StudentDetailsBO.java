package lk.ijse.bo.custom;

import javafx.scene.image.Image;
import lk.ijse.bo.SuperBO;
import lk.ijse.dto.StudentfullDetailsDto;

import java.sql.SQLException;
import java.util.List;

public interface StudentDetailsBO extends SuperBO {

    boolean saveStudent(StudentfullDetailsDto sr) throws SQLException, ClassNotFoundException;
    StudentfullDetailsDto searchStudent(String id) throws SQLException, ClassNotFoundException;
    boolean updateStudent(StudentfullDetailsDto su) throws SQLException, ClassNotFoundException;
    boolean deleteStudent(String id) throws SQLException, ClassNotFoundException;
    StudentfullDetailsDto getClassMailValueAll(String stuId) throws SQLException, ClassNotFoundException;
    StudentfullDetailsDto getClassMailValueBO(String stuId) throws SQLException, ClassNotFoundException;
    int howMachStudentBO() throws SQLException, ClassNotFoundException;
    StudentfullDetailsDto searchBO(String id) throws SQLException, ClassNotFoundException;
    List<StudentfullDetailsDto> getClassStudentBO(String iD) throws SQLException, ClassNotFoundException;
    Image convertBytesToJavaFXImageBO(byte[] image);

    byte[] imagenToByteBO(Image image);
}
