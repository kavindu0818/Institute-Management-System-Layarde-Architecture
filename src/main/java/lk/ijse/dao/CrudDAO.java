package lk.ijse.dao;

import javafx.scene.image.Image;
import lk.ijse.entity.StudentfullDetails;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO{

    boolean save(T dto) throws SQLException, ClassNotFoundException;

    T search(String id) throws SQLException, ClassNotFoundException;

    byte[] imagenToByte(Image imgId);

    Image convertBytesToJavaFXImage(byte[] imageData);

    boolean update(T dto) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;

    List<StudentfullDetails> getClassStudent(String iD) throws SQLException, ClassNotFoundException;
    int howMach() throws SQLException;
    T getClassMailValue(String id) throws SQLException, ClassNotFoundException;
}
