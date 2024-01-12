package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.TutorBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.TutorDAO;
import lk.ijse.dao.custom.impl.TutorDAOImpl;
import lk.ijse.dto.TutorDto;
import lk.ijse.entity.Tutor;

import java.sql.SQLException;

public class TutorBOImpl implements TutorBO {

    TutorDAO tutorDAO = (TutorDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TUTOR);

    public int howMachTutorBO() throws SQLException {
        return tutorDAO.howMachTutor();
    }

    public boolean saveTutorBO(TutorDto td) throws SQLException, ClassNotFoundException {
        Tutor tutor = new Tutor(td.getTut_id(),td.getTutorName(),td.getSub_id());
       return tutorDAO.saveTutor(tutor);
    }

    public boolean updateTutorBO(TutorDto td) throws SQLException, ClassNotFoundException {
        Tutor tutor = new Tutor(td.getTut_id(),td.getTutorName(),td.getSub_id());
        return tutorDAO.updateTutor(tutor);
    }

    public TutorDto getTutorBO(String tutId) throws SQLException, ClassNotFoundException {
        Tutor tutor = tutorDAO.getTutor(tutId);
        TutorDto tutorDto = new TutorDto(tutor.getTut_id(),tutor.getTutorName(),tutor.getSub_id());
        return tutorDto;
    }
}
