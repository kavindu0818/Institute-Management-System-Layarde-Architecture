package lk.ijse.bo.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.bo.custom.Course_PaymentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CourseAttendanceDAO;
import lk.ijse.dao.custom.Course_DetailsDAO;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.QuaryDAO;
import lk.ijse.dao.custom.impl.Course_paymentDAOImpl;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.CfdDto;
import lk.ijse.dto.CoursePaymentJoinDto;
import lk.ijse.dto.SetPaymentDto;
import lk.ijse.entity.Cfd;
import lk.ijse.entity.CoursePaymentJoin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Course_PaymentBOImpl implements Course_PaymentBO {

    Course_PaymentDAO coursePaymentDAO = (Course_PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE_PAYMENT);
    Course_DetailsDAO courseDetailsDAO = (Course_DetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE_DETAILS);

    QuaryDAO quaryDAO = (QuaryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUARY);


    @Override
    public boolean setPaymentDetails(SetPaymentDto dto) throws SQLException {


        Connection con = null;
        try{

            con = DbConnection.getInstance().getConnection();
            con.setAutoCommit(false);

            boolean isOrderSaved = coursePaymentDAO.savePayment(dto.getPayId(),dto.getAmount(), dto.getCusDfull(),dto.getStuID());
            if (isOrderSaved){
                new Alert(Alert.AlertType.INFORMATION,"Payment Save").show();
                boolean isItemUpdated = updatePayment(dto.getAmount(),dto.getCusDfull());
                if (isItemUpdated){
                    new Alert(Alert.AlertType.INFORMATION,"Update Ok").show();

                    // all 3 queries must be success
                    con.commit();
                    return true;
                }else {
                    con.rollback();
                }
            }else {
                con.rollback();
            }
        } catch (SQLException e) {
            if (con != null) con.rollback();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) con.setAutoCommit(true);
        }

        return false;
    }

    @Override
    public boolean updatePayment(double a,String id) throws SQLException, ClassNotFoundException {
        boolean isUpdateItem = courseDetailsDAO.upateAmount(a,id);
        if (!isUpdateItem){
            return false;
        }

        return true;
    }

    @Override
    public List<CoursePaymentJoinDto> getAllPaymentBO(String cusID, String date) throws SQLException, ClassNotFoundException {

        List<CoursePaymentJoin> coursePaymentJoins = quaryDAO.getAllPayment(cusID,date);
        ArrayList<CoursePaymentJoinDto> coursePaymentJoinDtos = new ArrayList<>();

        for (CoursePaymentJoin coursePaymentJoin: coursePaymentJoins){
            coursePaymentJoinDtos.add(new CoursePaymentJoinDto(coursePaymentJoin.getStuID(),coursePaymentJoin.getStuName(),coursePaymentJoin.getDate(),coursePaymentJoin.getAmount()));
        }

       return coursePaymentJoinDtos;

    }

    @Override
    public List<CfdDto> getStudentAllPaymentBO(String id2) throws SQLException, ClassNotFoundException {

        List<Cfd> cfds = quaryDAO.getStudentAllPayment(id2); //getStudentAllPayment
        ArrayList<CfdDto> cfdDtos = new ArrayList<>();

        for(Cfd cfd : cfds){
            cfdDtos.add(new CfdDto(cfd.getSub(),cfd.getAmount(),cfd.getDay()));

        }

       return cfdDtos;
    }

    @Override
    public int generateNextCourseFeeIdBO() throws SQLException {
        return coursePaymentDAO.generateNextCourseFeeId();
    }
}
