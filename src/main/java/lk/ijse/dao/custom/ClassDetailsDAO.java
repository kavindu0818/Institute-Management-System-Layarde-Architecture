package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.dto.Class_DetailsDto;
import lk.ijse.entity.Class_Details;

import java.sql.SQLException;
import java.util.List;

public interface ClassDetailsDAO extends CrudDAO<Class_Details> {

    Class_Details loardValues(String aId) throws SQLException, ClassNotFoundException;

    List<Class_Details> getFullId(String sID) throws SQLException, ClassNotFoundException;

    boolean saveClassDetails(Class_Details ad) throws SQLException, ClassNotFoundException;

    boolean saveValue(String attendance, String stuId, String classID, String stuName) throws SQLException;

    Class_DetailsDto getsendMailValue(String atId) throws SQLException, ClassNotFoundException;



}
