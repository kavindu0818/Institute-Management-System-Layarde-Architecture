package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.SubjectBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.SubjectDAO;
import lk.ijse.dao.custom.impl.SubjectDAOImpl;
import lk.ijse.dto.SubjectDto;
import lk.ijse.entity.Subject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectBOImpl implements SubjectBO {

    SubjectDAO subjectDAO = (SubjectDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUBJECT);

    @Override
    public List<SubjectDto> getSubjectBO() throws SQLException, ClassNotFoundException {
        List<Subject> subjects = subjectDAO.getSubject();
        ArrayList<SubjectDto> subjectDtos = new ArrayList<>();

        for (Subject subject : subjects){
            subjectDtos.add(new SubjectDto(subject.getSub_id(),subject.getSubjectName()));
        }
       return subjectDtos;
    }

    @Override
    public boolean subSaveBO(SubjectDto sub) throws SQLException, ClassNotFoundException {
       return subjectDAO.subSave(sub);
    }
}
