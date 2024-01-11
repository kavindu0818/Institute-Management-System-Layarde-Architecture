package lk.ijse.bo.custom;

import javafx.scene.control.Alert;
import lk.ijse.bo.SuperBO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.SetPaymentDto;

import java.sql.Connection;
import java.sql.SQLException;

public interface SetPaymentBO extends SuperBO {

     boolean setPaymentDetails(SetPaymentDto dto) throws SQLException;

     boolean updatePayment(double a,String id) throws SQLException, ClassNotFoundException;
}
