package lk.ijse.bo.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.bo.custom.StudentDetailsBO;
import lk.ijse.dao.custom.StudentDetailsDAO;
import lk.ijse.dao.custom.impl.StudentDetailsDAOImpl;
import lk.ijse.dto.ClassDto;
import lk.ijse.dto.StudentfullDetailsDto;

import java.sql.SQLException;
import java.util.List;

public class StudentDetailsBOImpl implements StudentDetailsBO {

    StudentDetailsDAO studentDetailsDAO = new StudentDetailsDAOImpl();
    public boolean saveStudent(StudentfullDetailsDto sr) throws SQLException, ClassNotFoundException {

        return studentDetailsDAO.save(sr);

    }

    public StudentfullDetailsDto searchStudent(String id) throws SQLException, ClassNotFoundException {
        return studentDetailsDAO.search(id);
    }

    public boolean updateStudent(StudentfullDetailsDto su) throws SQLException, ClassNotFoundException {
        return studentDetailsDAO.update(su);
    }


    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return studentDetailsDAO.delete(id);
    }

    public StudentfullDetailsDto getClassMailValueAll(String stuId) throws SQLException, ClassNotFoundException {
       return studentDetailsDAO.getClassMailValue(stuId);
    }

    public StudentfullDetailsDto getClassMailValueBO(String stuId) throws SQLException, ClassNotFoundException {
       return studentDetailsDAO.getClassMailValue(stuId);
    }

    public int howMachStudentBO() throws SQLException {
      return studentDetailsDAO.howMach();
    }

    public StudentfullDetailsDto searchBO(String id) throws SQLException, ClassNotFoundException {
        return studentDetailsDAO.search(id);
    }

    public List<StudentfullDetailsDto> getClassStudentBO(String iD) throws SQLException, ClassNotFoundException {
       return studentDetailsDAO.getClassStudent(iD);
    }

    public Image convertBytesToJavaFXImageBO(byte[] image) {
       return studentDetailsDAO.convertBytesToJavaFXImage(image);
    }
}
