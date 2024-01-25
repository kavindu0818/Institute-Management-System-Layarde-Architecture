package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.NoticeDto;
import lk.ijse.entity.Notice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface NoticeDAO extends CrudDAO<Notice> {

    boolean setNotice(NoticeDto nd) throws SQLException, ClassNotFoundException;
    List<Notice> getAllNotice() throws SQLException, ClassNotFoundException;
}
