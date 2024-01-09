package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.NoticeDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface NoticeDAO extends SuperDAO {

    boolean setNotice(NoticeDto nd) throws SQLException, ClassNotFoundException;
    List<NoticeDto> getAllNotice() throws SQLException, ClassNotFoundException;
}
