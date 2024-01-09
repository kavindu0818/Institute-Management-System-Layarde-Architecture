package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.Class_DetailsDto;

import java.sql.SQLException;
import java.util.List;

public interface Class_DetailsBO extends SuperBO {

     boolean saveClassDetailsStudemt(Class_DetailsDto ad) throws SQLException, ClassNotFoundException;

     Class_DetailsDto loardValuesAll(String aId) throws SQLException, ClassNotFoundException;


     Class_DetailsDto getsendMailValueAll(String atId) throws SQLException, ClassNotFoundException;

     List<Class_DetailsDto> getFullIdBO(String sID) throws SQLException, ClassNotFoundException;

}
