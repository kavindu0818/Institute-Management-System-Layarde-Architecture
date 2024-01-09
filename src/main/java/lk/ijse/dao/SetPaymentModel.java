package lk.ijse.dao;

import javafx.scene.control.Alert;
import lk.ijse.dao.custom.Course_DetailsDAO;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.impl.Course_detailsDAOImpl;
import lk.ijse.dao.custom.impl.Course_paymentDAOImpl;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.SetPaymentDto;

import java.sql.Connection;
import java.sql.SQLException;

public class SetPaymentModel {
    Course_PaymentDAO course_paymentModel = new Course_paymentDAOImpl();
    Course_DetailsDAO courseDetailsDAO = new Course_detailsDAOImpl();

    public boolean setPaymentDetails(SetPaymentDto dto) throws SQLException {


            Connection con = null;
            try{

                con = DbConnection.getInstance().getConnection();
                con.setAutoCommit(false);

                boolean isOrderSaved = course_paymentModel.savePayment(dto.getPayId(),dto.getAmount(), dto.getCusDfull(),dto.getStuID());
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



    private boolean updatePayment(double a,String id) throws SQLException, ClassNotFoundException {
            boolean isUpdateItem = courseDetailsDAO.upateAmount(a,id);
            if (!isUpdateItem){
                return false;
            }

        return true;
    }

}




