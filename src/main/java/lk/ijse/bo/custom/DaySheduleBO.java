package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.DaySheduleDto;

import java.sql.SQLException;
import java.util.List;

public interface DaySheduleBO extends SuperBO {

    List<DaySheduleDto> getAllShedulBO() throws SQLException, ClassNotFoundException;

    boolean saveValuesBO(DaySheduleDto day) throws SQLException, ClassNotFoundException;
}
