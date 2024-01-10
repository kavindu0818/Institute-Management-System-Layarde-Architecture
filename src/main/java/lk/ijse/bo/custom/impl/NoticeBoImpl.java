package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.NoticeBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.NoticeDAO;
import lk.ijse.dao.custom.impl.NoticeDAOImpl;
import lk.ijse.dto.NoticeDto;

import java.sql.SQLException;
import java.util.List;

public class NoticeBoImpl implements NoticeBO {

    NoticeDAO noticeDAO = (NoticeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.NOTICE);
    ;
    public List<NoticeDto> getAllNoticeBO() throws SQLException, ClassNotFoundException {
       return noticeDAO.getAllNotice();
    }
}
