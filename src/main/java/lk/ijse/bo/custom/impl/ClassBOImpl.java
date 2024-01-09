package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ClassBO;
import lk.ijse.dao.custom.ClassDAO;
import lk.ijse.dao.custom.impl.ClassDAOImpl;
import lk.ijse.dto.ClassDto;

import java.sql.SQLException;
import java.util.List;

public class ClassBOImpl implements ClassBO {

    ClassDAO classDAO = new ClassDAOImpl();

    public List<ClassDto> getAllClassRegister() throws SQLException, ClassNotFoundException {
        return classDAO.getAllClass();
    }

    public List<ClassDto> getAllClassUpdate() throws SQLException, ClassNotFoundException {
        return classDAO.getAllClass();
    }


    public List<ClassDto> getAllClassDetails() throws SQLException, ClassNotFoundException {
        return classDAO.getAllClass();
    }

    public List<ClassDto> getAllClassBO() throws SQLException, ClassNotFoundException {
       return classDAO.getAllClass();
    }

    public boolean classSaveBO(ClassDto cms) throws SQLException, ClassNotFoundException {
       return classDAO.classSave(cms);
    }

    public boolean saveCoursesClassBO(ClassDto cd) throws SQLException, ClassNotFoundException {
        return classDAO.saveCoursesClass(cd);
    }
}
