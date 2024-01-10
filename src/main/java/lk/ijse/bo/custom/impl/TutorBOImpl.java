package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.TutorBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.TutorDAO;
import lk.ijse.dao.custom.impl.TutorDAOImpl;
import lk.ijse.dto.TutorDto;

import java.sql.SQLException;

public class TutorBOImpl implements TutorBO {

    TutorDAO tutorDAO = (TutorDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TUTOR);
    ;
    public int howMachTutorBO() throws SQLException {
        return tutorDAO.howMachTutor();
    }

    public boolean saveTutorBO(TutorDto td) throws SQLException {
       return tutorDAO.saveTutor(td);
    }

    public boolean updateTutorBO(TutorDto td) throws SQLException, ClassNotFoundException {
        return tutorDAO.updateTutor(td);
    }

    public TutorDto getTutorBO(String tutId) throws SQLException {
        return tutorDAO.getTutor(tutId);
    }
}
