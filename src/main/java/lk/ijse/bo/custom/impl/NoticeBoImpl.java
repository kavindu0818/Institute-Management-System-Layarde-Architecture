package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.NoticeBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.NoticeDAO;
import lk.ijse.dao.custom.impl.NoticeDAOImpl;
import lk.ijse.dto.NoticeDto;
import lk.ijse.entity.Notice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticeBoImpl implements NoticeBO {

    NoticeDAO noticeDAO = (NoticeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.NOTICE);
    ;
    public List<NoticeDto> getAllNoticeBO() throws SQLException, ClassNotFoundException {
        List<Notice> notices = noticeDAO.getAllNotice();
        ArrayList<NoticeDto> noticeDtos = new ArrayList<>();

        for (Notice notice : notices){
            noticeDtos.add(new NoticeDto(notice.getNote(),notice.getDate()));
        }
       return noticeDtos;
    }
}
