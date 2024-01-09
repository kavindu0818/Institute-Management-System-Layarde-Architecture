package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.SubjectDto;

import java.sql.SQLException;
import java.util.List;

public interface SubjectBO extends SuperBO {

    public List<SubjectDto> getSubjectBO() throws SQLException, ClassNotFoundException;

    public boolean subSaveBO(SubjectDto sub) throws SQLException, ClassNotFoundException;
}
