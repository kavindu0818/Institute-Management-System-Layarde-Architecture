package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.SubjectBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.SubjectDAO;
import lk.ijse.dao.custom.impl.SubjectDAOImpl;
import lk.ijse.dto.SubjectDto;

import java.sql.SQLException;
import java.util.List;

public class SubjectBOImpl implements SubjectBO {

    SubjectDAO subjectDAO = (SubjectDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUBJECT);

    public List<SubjectDto> getSubjectBO() throws SQLException, ClassNotFoundException {
       return subjectDAO.getSubject();
    }

    public boolean subSaveBO(SubjectDto sub) throws SQLException, ClassNotFoundException {
       return subjectDAO.subSave(sub);
    }
}
