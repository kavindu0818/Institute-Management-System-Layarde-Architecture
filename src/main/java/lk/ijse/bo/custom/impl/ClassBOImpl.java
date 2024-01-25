package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ClassBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ClassDAO;
import lk.ijse.dao.custom.impl.ClassDAOImpl;
import lk.ijse.dto.ClassDto;
import lk.ijse.dto.Class_paymentDto;
import lk.ijse.entity.Class;
import lk.ijse.entity.Class_payment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassBOImpl implements ClassBO {

    ClassDAO classDAO = (ClassDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CLASS);

  @Override
    public List<ClassDto> getAllClassRegister() throws SQLException, ClassNotFoundException {

        List<Class> clz = classDAO.getAllClass();
        ArrayList<ClassDto> classDtos = new ArrayList<>();

        for (Class classes : clz){
            classDtos.add(new ClassDto(classes.getClass_id(),classes.getClassName(),classes.getTut_id()));

        }

        return classDtos;
    }

    @Override
    public List<ClassDto> getAllClassUpdate() throws SQLException, ClassNotFoundException {
        List<Class> clz = classDAO.getAllClass();
        ArrayList<ClassDto> classDtos = new ArrayList<>();

        for (Class classes : clz){
            classDtos.add(new ClassDto(classes.getClass_id(),classes.getClassName(),classes.getTut_id()));

        }

        return classDtos;
    }

    @Override

    public List<ClassDto> getAllClassDetails() throws SQLException, ClassNotFoundException {
        List<Class> clz = classDAO.getAllClass();
        ArrayList<ClassDto> classDtos = new ArrayList<>();

        for (Class classes : clz){
            classDtos.add(new ClassDto(classes.getClass_id(),classes.getClassName(),classes.getTut_id()));

        }

        return classDtos;
    }

    @Override
    public List<ClassDto> getAllClassBO() throws SQLException, ClassNotFoundException {
        List<Class> clz = classDAO.getAllClass();
        ArrayList<ClassDto> classDtos = new ArrayList<>();

        for (Class classes : clz){
            classDtos.add(new ClassDto(classes.getClass_id(),classes.getClassName(),classes.getTut_id()));

        }

        return classDtos;
    }

    @Override

    public boolean classSaveBO(ClassDto cms) throws SQLException, ClassNotFoundException {
        Class classEnt = new Class(cms.getClass_id(),cms.getTut_id(),cms.getClassName());
       return classDAO.classSave(classEnt);
    }

    @Override
    public boolean saveCoursesClassBO(ClassDto cms) throws SQLException, ClassNotFoundException {
        Class classEnt = new Class(cms.getClass_id(),cms.getTut_id(),cms.getClassName());
        return classDAO.saveCoursesClass(classEnt);
    }
}
