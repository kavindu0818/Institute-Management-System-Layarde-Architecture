package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.NoticeDto;

import java.sql.SQLException;
import java.util.List;

public interface NoticeBO extends SuperBO {

     List<NoticeDto> getAllNoticeBO() throws SQLException, ClassNotFoundException;
}
