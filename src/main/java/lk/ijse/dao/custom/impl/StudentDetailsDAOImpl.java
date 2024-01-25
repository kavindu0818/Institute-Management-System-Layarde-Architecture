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

     @Override
    public boolean save(StudentfullDetails sr) throws SQLException, ClassNotFoundException {
        byte[] imageSr = sr.getImage();

        return SQLUtil.execute("INSERT INTO studentfull_details VALUES(?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?)",sr.getStu_id(),sr.getReg_id(),sr.getName(),
                sr.getRegDate(),sr.getStudent_gmail(),sr.getStudent_contactNo(),sr.getSub_id(),sr.getAddress(),
                sr.getAge(), sr.getGrade(),sr.getPerant_Name(), sr.getPerant_Gmail(),sr.getPerant_contactNo(),imageSr);

    }

   @Override
    public StudentfullDetails search(String id) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM  studentfull_details WHERE stu_id = ?",id);

        StudentfullDetails dto = null;

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



            dto = new StudentfullDetails(stu_id, reg_id, Stuname, regDate, stuGmail, StuContact, sub_id, adddress, age, grade,perant_name, perant_Gmail, perant_ContactNo, imageBytes);
        }
        return dto;
    }

    @Override
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


@Override
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


@Override
    public boolean update(StudentfullDetails su) throws SQLException, ClassNotFoundException {

        byte[] imageSr = su.getImage();


        return SQLUtil.execute("UPDATE studentfull_details SET reg_id = ?,name = ?,regDate = ?,Student_gmail = ?,Student_contactNo =?,sub_id = ?, address = ?,age =?,grade = ?,Perant_Name = ?,Perant_Gmail = ?, Perant_contactNo =?, image =? WHERE stu_id = ?", su.getReg_id(),su.getName(),su.getRegDate(),su.getStudent_gmail(),su.getStudent_contactNo(),su.getSub_id(),su.getAddress(),
                su.getAge(),su.getGrade(),su.getPerant_Name(),su.getPerant_Gmail(),su.getPerant_contactNo(),imageSr,su.getStu_id());

    }


    @Override

    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("DELETE FROM studentfull_details WHERE stu_id = ?", id);

    }

    @Override

    public List<StudentfullDetails> getClassStudent(String iD) throws SQLException, ClassNotFoundException {

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
    public int howMach() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT count(stu_id) FROM studentfull_details"); //pstm.executeQuery();

        int a = 0;

        if (resultSet.next()){
            return resultSet.getInt(1);

        }
        return 0;


    }

@Override
    public StudentfullDetails getClassMailValue(String id) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM  studentfull_details WHERE stu_id = ?",id);//pstm.executeQuery();

        StudentfullDetails dto = null;

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



            dto = new StudentfullDetails(stu_id, reg_id, Stuname, regDate, stuGmail, StuContact, sub_id, adddress, age, grade,perant_name, perant_Gmail, perant_ContactNo, imageBytes);
        }
        return dto;

    }
}


