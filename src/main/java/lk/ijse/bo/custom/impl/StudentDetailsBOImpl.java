package lk.ijse.bo.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.bo.custom.StudentDetailsBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.StudentDetailsDAO;
import lk.ijse.dao.custom.impl.StudentDetailsDAOImpl;
import lk.ijse.dto.ClassDto;
import lk.ijse.dto.StudentfullDetailsDto;
import lk.ijse.entity.StudentfullDetails;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDetailsBOImpl implements StudentDetailsBO {

    StudentDetailsDAO studentDetailsDAO = (StudentDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT_DETAILS);

    public boolean saveStudent(StudentfullDetailsDto sr) throws SQLException, ClassNotFoundException {
        StudentfullDetails studentfullDetails = new StudentfullDetails(sr.getStu_id(),sr.getReg_id(),sr.getName(),sr.getRegDate(),sr.getStudent_gmail(),sr.getStudent_contactNo(),sr.getSub_id(),sr.getAddress(),sr.getAge(),sr.getGrade(),sr.getPerant_Name(),sr.getPerant_Gmail(),sr.getPerant_contactNo(),sr.getImage());
        return studentDetailsDAO.save(studentfullDetails);

    }

    public StudentfullDetailsDto searchStudent(String id) throws SQLException, ClassNotFoundException {
        StudentfullDetails studentfullDetails = studentDetailsDAO.search(id);
        StudentfullDetailsDto studentfullDetailsDto = new StudentfullDetailsDto(studentfullDetails.getStu_id(),studentfullDetails.getReg_id(),studentfullDetails.getName(),studentfullDetails.getRegDate(),studentfullDetails.getStudent_gmail(),studentfullDetails.getStudent_contactNo(),studentfullDetails.getSub_id(),studentfullDetails.getAddress(),studentfullDetails.getAge(),studentfullDetails.getGrade(),studentfullDetails.getPerant_Name(),studentfullDetails.getPerant_Gmail(),studentfullDetails.getPerant_contactNo(),studentfullDetails.getImage());

        return studentfullDetailsDto;
    }

    public boolean updateStudent(StudentfullDetailsDto sr) throws SQLException, ClassNotFoundException {
        StudentfullDetails studentfullDetails = new StudentfullDetails(sr.getStu_id(),sr.getReg_id(),sr.getName(),sr.getRegDate(),sr.getStudent_gmail(),sr.getStudent_contactNo(),sr.getSub_id(),sr.getAddress(),sr.getAge(),sr.getGrade(),sr.getPerant_Name(),sr.getPerant_Gmail(),sr.getPerant_contactNo(),sr.getImage());

        return studentDetailsDAO.update(studentfullDetails);
    }


    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return studentDetailsDAO.delete(id);
    }

    public StudentfullDetailsDto getClassMailValueAll(String stuId) throws SQLException, ClassNotFoundException {
        StudentfullDetails studentfullDetails = studentDetailsDAO.getClassMailValue(stuId);
        StudentfullDetailsDto studentfullDetailsDto = new StudentfullDetailsDto(studentfullDetails.getStu_id(),studentfullDetails.getReg_id(),studentfullDetails.getName(),studentfullDetails.getRegDate(),studentfullDetails.getStudent_gmail(),studentfullDetails.getStudent_contactNo(),studentfullDetails.getSub_id(),studentfullDetails.getAddress(),studentfullDetails.getAge(),studentfullDetails.getGrade(),studentfullDetails.getPerant_Name(),studentfullDetails.getPerant_Gmail(),studentfullDetails.getPerant_contactNo(),studentfullDetails.getImage());

        return studentfullDetailsDto;

    }

    public StudentfullDetailsDto getClassMailValueBO(String stuId) throws SQLException, ClassNotFoundException {
        StudentfullDetails studentfullDetails =studentDetailsDAO.getClassMailValue(stuId);
        StudentfullDetailsDto studentfullDetailsDto = new StudentfullDetailsDto(studentfullDetails.getStu_id(),studentfullDetails.getReg_id(),studentfullDetails.getName(),studentfullDetails.getRegDate(),studentfullDetails.getStudent_gmail(),studentfullDetails.getStudent_contactNo(),studentfullDetails.getSub_id(),studentfullDetails.getAddress(),studentfullDetails.getAge(),studentfullDetails.getGrade(),studentfullDetails.getPerant_Name(),studentfullDetails.getPerant_Gmail(),studentfullDetails.getPerant_contactNo(),studentfullDetails.getImage());

        return studentfullDetailsDto;

    }

    public int howMachStudentBO() throws SQLException {
      return studentDetailsDAO.howMach();
    }

    public StudentfullDetailsDto searchBO(String id) throws SQLException, ClassNotFoundException {
        StudentfullDetails studentfullDetails =studentDetailsDAO.search(id);
        StudentfullDetailsDto studentfullDetailsDto = new StudentfullDetailsDto(studentfullDetails.getStu_id(),studentfullDetails.getReg_id(),studentfullDetails.getName(),studentfullDetails.getRegDate(),studentfullDetails.getStudent_gmail(),studentfullDetails.getStudent_contactNo(),studentfullDetails.getSub_id(),studentfullDetails.getAddress(),studentfullDetails.getAge(),studentfullDetails.getGrade(),studentfullDetails.getPerant_Name(),studentfullDetails.getPerant_Gmail(),studentfullDetails.getPerant_contactNo(),studentfullDetails.getImage());

        return studentfullDetailsDto;
    }

    public List<StudentfullDetailsDto> getClassStudentBO(String iD) throws SQLException, ClassNotFoundException {
        ArrayList<StudentfullDetailsDto> studentfullDetailsDDTO = new ArrayList<>();
        List<StudentfullDetails> student = studentDetailsDAO.getClassStudent(iD);


        for (StudentfullDetails studentfullDetails :student){
            studentfullDetailsDDTO.add(new StudentfullDetailsDto(studentfullDetails.getStu_id(),studentfullDetails.getReg_id(),studentfullDetails.getName(),studentfullDetails.getRegDate(),studentfullDetails.getStudent_gmail(),studentfullDetails.getStudent_contactNo(),studentfullDetails.getSub_id(),studentfullDetails.getAddress(),studentfullDetails.getAge(),studentfullDetails.getGrade(),studentfullDetails.getPerant_Name(),studentfullDetails.getPerant_Gmail(),studentfullDetails.getPerant_contactNo(),studentfullDetails.getImage()));

        }

        return studentfullDetailsDDTO;

      // return studentDetailsDAO.getClassStudent(iD);
    }

    public Image convertBytesToJavaFXImageBO(byte[] image) {
       return studentDetailsDAO.convertBytesToJavaFXImage(image);
    }

    @Override
    public byte[] imagenToByteBO(Image image) {
        return studentDetailsDAO.imagenToByte(image);
    }
}
