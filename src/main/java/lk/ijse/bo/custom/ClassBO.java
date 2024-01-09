package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.ClassDto;

import java.sql.SQLException;
import java.util.List;

public interface ClassBO extends SuperBO {

    public List<ClassDto> getAllClassRegister() throws SQLException, ClassNotFoundException;

    public List<ClassDto> getAllClassUpdate() throws SQLException, ClassNotFoundException ;


    public List<ClassDto> getAllClassDetails() throws SQLException, ClassNotFoundException;

    public List<ClassDto> getAllClassBO() throws SQLException, ClassNotFoundException;

    public boolean classSaveBO(ClassDto cms) throws SQLException, ClassNotFoundException;

    public boolean saveCoursesClassBO(ClassDto cd) throws SQLException, ClassNotFoundException;
}
