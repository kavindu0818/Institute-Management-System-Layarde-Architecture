package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.Class_DetailsBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ClassDetailsDAO;
import lk.ijse.dao.custom.Class_PaymentDAO;
import lk.ijse.dao.custom.impl.Class_DetailsDAOImpl;
import lk.ijse.dto.Class_DetailsDto;
import lk.ijse.dto.StudentfullDetailsDto;
import lk.ijse.entity.Class_Details;
import lk.ijse.entity.StudentfullDetails;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Class_DetailsBOImpl implements Class_DetailsBO {

    ClassDetailsDAO classDetailsDAO = (ClassDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CLASS_DETAILS);


    public boolean saveClassDetailsStudemt(Class_DetailsDto ad) throws SQLException, ClassNotFoundException {
     Class_Details classDetails = new Class_Details(ad.getFull_id(),ad.getStu_id(),ad.getClass_id(),ad.getStu_name());
        return classDetailsDAO.saveClassDetails(classDetails);
    }

    public Class_DetailsDto loardValuesAll(String aId) throws SQLException, ClassNotFoundException {
        Class_Details classDetails = classDetailsDAO.loardValues(aId);
        Class_DetailsDto classDetailsDto = new Class_DetailsDto(classDetails.getFull_id(),classDetails.getStu_id(),classDetails.getClass_id(),classDetails.getStu_name());

       return classDetailsDto;
    }

    public Class_DetailsDto getsendMailValueAll(String atId) throws SQLException, ClassNotFoundException {

        Class_Details classDetails = classDetailsDAO.loardValues(atId);
        Class_DetailsDto classDetailsDto = new Class_DetailsDto(classDetails.getFull_id(),classDetails.getStu_id(),classDetails.getClass_id(),classDetails.getStu_name());

        return classDetailsDto;
    }

    public List<Class_DetailsDto> getFullIdBO(String sID) throws SQLException, ClassNotFoundException {
        List<Class_Details> classDetails = classDetailsDAO.getFullId(sID);
        ArrayList<Class_DetailsDto> classDetailsDtos = new ArrayList<>();

        for (Class_Details classDetails1 : classDetails){
            classDetailsDtos.add(new Class_DetailsDto(classDetails1.getFull_id(),classDetails1.getStu_id(),classDetails1.getClass_id(),classDetails1.getStu_name()));

        }
        return classDetailsDtos;
    }
}
