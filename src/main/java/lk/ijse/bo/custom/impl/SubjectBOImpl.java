package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.SubjectBO;
import lk.ijse.dao.custom.impl.SubjectDAOImpl;
import lk.ijse.dto.SubjectDto;

import java.sql.SQLException;
import java.util.List;

public class SubjectBOImpl implements SubjectBO {

    SubjectDAOImpl subjectDAO = new SubjectDAOImpl();
    public List<SubjectDto> getSubjectBO() throws SQLException, ClassNotFoundException {
       return subjectDAO.getSubject();
    }

    public boolean subSaveBO(SubjectDto sub) throws SQLException, ClassNotFoundException {
       return subjectDAO.subSave(sub);
    }
}
