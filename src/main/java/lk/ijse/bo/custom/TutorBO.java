package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.TutorDto;

import java.sql.SQLException;

public interface TutorBO extends SuperBO {

    int howMachTutorBO() throws SQLException;
    boolean saveTutorBO(TutorDto td) throws SQLException, ClassNotFoundException;
    boolean updateTutorBO(TutorDto td) throws SQLException, ClassNotFoundException;
    TutorDto getTutorBO(String tutId) throws SQLException, ClassNotFoundException;


}
