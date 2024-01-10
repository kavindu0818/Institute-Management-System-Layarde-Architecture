package lk.ijse.dao.custom.impl;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.StudentDetailsDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.StudentfullDetailsDto;
import lk.ijse.entity.StudentfullDetails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDetailsDAOImpl implements StudentDetailsDAO {

    public boolean save(StudentfullDetailsDto sr) throws SQLException, ClassNotFoundException {
        byte[] imageSr = sr.getImage();

        return SQLUtil.execute("INSERT INTO studentfull_details VALUES(?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?)",sr.getStu_id(),sr.getReg_id(),sr.getName(),
                sr.getRegDate(),sr.getStudent_gmail(),sr.getStudent_contactNo(),sr.getSub_id(),sr.getAddress(),
                sr.getAge(), sr.getGrade(),sr.getPerant_Name(), sr.getPerant_Gmail(),sr.getPerant_contactNo(),imageSr);

//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "INSERT INTO studentfull_details VALUES(?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1, sr.getStu_id());
//        pstm.setString(2, sr.getReg_id());
//        pstm.setString(3, sr.getName());
//        pstm.setString(4, sr.getRegDate());
//        pstm.setString(5, sr.getStudent_gmail());
//        pstm.setString(6, sr.getStudent_contactNo());
//        pstm.setString(7, sr.getSub_id());
//        pstm.setString(8, sr.getAddress());
//        pstm.setString(9, sr.getAge());
//        pstm.setString(10, sr.getGrade());
//        pstm.setString(11, sr.getPerant_Name());
//        pstm.setString(12, sr.getPerant_Gmail());
//        pstm.setString(13, sr.getPerant_contactNo());
//
    // byte[] imageSr = sr.getImage();
     //pstm.setBytes(14, imageSr);
//
//
//        boolean isSaved = pstm.executeUpdate() > 0;
//
//        return isSaved;
    }

@Override
    public StudentfullDetailsDto search(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM  studentfull_details WHERE stu_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, id);

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM  studentfull_details WHERE stu_id = ?",id);

        StudentfullDetailsDto dto = null;

        if (resultSet.next()) {
            String stu_id = resultSet.getString(1);
            String reg_id = resultSet.getString(2);
            String Stuname = resultSet.getString(3);
            String regDate = resultSet.getString(4);
            String stuGmail = resultSet.getString(5);
            String StuContact = resultSet.getString(6);
            String sub_id = resultSet.getString(7);
            String adddress = resultSet.getString(8);
            String age = resultSet.getString(9);
            String grade = resultSet.getString(10);
           // String perant_id = resultSet.getString(11);
            String perant_name = resultSet.getString(11);
            String perant_Gmail = resultSet.getString(12);
            String perant_ContactNo = resultSet.getString(13);

            byte[] imageBytes = resultSet.getBytes(14);

           // Image fxImage = convertBytesToJavaFXImage(imageBytes);



            dto = new StudentfullDetailsDto(stu_id, reg_id, Stuname, regDate, stuGmail, StuContact, sub_id, adddress, age, grade,perant_name, perant_Gmail, perant_ContactNo, imageBytes);
        }
        return dto;
    }

    public byte[] imagenToByte(Image imgId) {
        BufferedImage bufferimage = SwingFXUtils.fromFXImage(imgId, null);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferimage, "jpg", output);
            ImageIO.write(bufferimage, "png", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] data = output.toByteArray();
        return data;
    }



  public Image convertBytesToJavaFXImage(byte[] imageData) {
      try {
          ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
          BufferedImage bufferedImage = ImageIO.read(bis);
          return SwingFXUtils.toFXImage(bufferedImage, null);
      } catch (IOException e) {
          e.printStackTrace();
          return null;
      }
  }



    public boolean update(StudentfullDetailsDto su) throws SQLException, ClassNotFoundException {

        byte[] imageSr = su.getImage();


        return SQLUtil.execute("UPDATE studentfull_details SET reg_id = ?,name = ?,regDate = ?,Student_gmail = ?,Student_contactNo =?,sub_id = ?, address = ?,age =?,grade = ?,Perant_Name = ?,Perant_Gmail = ?, Perant_contactNo =?, image =? WHERE stu_id = ?",
                su.getReg_id(),su.getName(),su.getRegDate(),su.getStudent_gmail(),su.getStudent_contactNo(),su.getSub_id(),su.getAddress(),
                su.getAge(),su.getGrade(),su.getPerant_Name(),su.getPerant_Gmail(),su.getPerant_contactNo(),imageSr,su.getStu_id());

//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "UPDATE studentfull_details SET reg_id = ?,name = ?,regDate = ?,Student_gmail = ?,Student_contactNo =?,sub_id = ?, address = ?,age =?,grade = ?,Perant_Name = ?,Perant_Gmail = ?, Perant_contactNo =?, image =? WHERE stu_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1, su.getReg_id());
//        pstm.setString(2, su.getName());
//        pstm.setString(3, su.getRegDate());
//        pstm.setString(4, su.getStudent_gmail());
//        pstm.setString(5, su.getStudent_contactNo());
//        pstm.setString(6, su.getSub_id());
//        pstm.setString(7, su.getAddress());
//        pstm.setString(8, su.getAge());
//        pstm.setString(9, su.getGrade());
//      //  pstm.setString(10, su.getPerant_id());
//        pstm.setString(10, su.getPerant_Name());
//        pstm.setString(11, su.getPerant_Gmail());
//        pstm.setString(12, su.getPerant_contactNo());
//        byte[] imageSr = su.getImage();
//        pstm.setBytes(13, imageSr);
//        pstm.setString(14, su.getStu_id());
//
//
//
//        return pstm.executeUpdate() > 0;
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("DELETE FROM studentfull_details WHERE stu_id = ?", id);
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "DELETE FROM studentfull_details WHERE stu_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1,id);
//        return pstm.executeUpdate()>0;
    }

    public List<StudentfullDetails> getClassStudent(String iD) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM  studentfull_details WHERE stu_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, iD);

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM  studentfull_details WHERE stu_id = ?",iD);

        ArrayList<StudentfullDetails> dtoList = new ArrayList<>();
        while(resultSet.next()) {
            dtoList.add(
                    new StudentfullDetails(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9),
                            resultSet.getString(10),
                            resultSet.getString(11),
                            resultSet.getString(12),
                            resultSet.getString(13),
                            resultSet.getBytes(14)
                    )
            );
        }
        return dtoList;
    }

    @Override
    public int howMach() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql ="select count(stu_id) from studentfull_details";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        int a = 0;

        if (resultSet.next()){
            return resultSet.getInt(1);

        }
        return 0;


    }

//    public int howMachStudent() throws SQLException {
//
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql ="select count(stu_id) from studentfull_details";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        ResultSet resultSet = pstm.executeQuery();
//
//        int a = 0;
//
//        if (resultSet.next()){
//            return resultSet.getInt(1);
//
//        }
//        return 0;
//
//  }

    public StudentfullDetailsDto getClassMailValue(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM  studentfull_details WHERE stu_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, id);

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM  studentfull_details WHERE stu_id = ?",id);//pstm.executeQuery();

        StudentfullDetailsDto dto = null;

        if (resultSet.next()) {
            String stu_id = resultSet.getString(1);
            String reg_id = resultSet.getString(2);
            String Stuname = resultSet.getString(3);
            String regDate = resultSet.getString(4);
            String stuGmail = resultSet.getString(5);
            String StuContact = resultSet.getString(6);
            String sub_id = resultSet.getString(7);
            String adddress = resultSet.getString(8);
            String age = resultSet.getString(9);
            String grade = resultSet.getString(10);
            // String perant_id = resultSet.getString(11);
            String perant_name = resultSet.getString(11);
            String perant_Gmail = resultSet.getString(12);
            String perant_ContactNo = resultSet.getString(13);

            byte[] imageBytes = resultSet.getBytes(14);

            // Image fxImage = convertBytesToJavaFXImage(imageBytes);



            dto = new StudentfullDetailsDto(stu_id, reg_id, Stuname, regDate, stuGmail, StuContact, sub_id, adddress, age, grade,perant_name, perant_Gmail, perant_ContactNo, imageBytes);
        }
        return dto;

    }
}


