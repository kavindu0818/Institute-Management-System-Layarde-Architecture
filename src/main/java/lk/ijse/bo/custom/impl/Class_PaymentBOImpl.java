package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.Class_PaymentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Class_PaymentDAO;
import lk.ijse.dao.custom.QuaryDAO;
import lk.ijse.dao.custom.impl.Class_PaymentDAOImpl;
import lk.ijse.dto.ClassPaymentDto;
import lk.ijse.dto.Class_DetailsDto;
import lk.ijse.dto.Class_paymentDto;
import lk.ijse.entity.ClassPayment;
import lk.ijse.entity.Class_Details;
import lk.ijse.entity.Class_payment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Class_PaymentBOImpl implements Class_PaymentBO {

   QuaryDAO quaryDAO = (QuaryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUARY);
    Class_PaymentDAO classPaymentDAO = (Class_PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CLASS_PAYMENT);

@Override
    public boolean stuPaymentSaveBO(String num, String classId, String stuId, String name, String month, String stuFullId, double amount) throws SQLException, ClassNotFoundException {
       return classPaymentDAO.stuPaymentSave(num,classId,stuId,name,month,stuFullId,amount);
    }

    @Override
    public int generateNextOrderIdBO() throws SQLException {
        return classPaymentDAO.generateNextOrderId();
    }

    @Override
    public List<ClassPaymentDto> getAllClassPaymentBO(String clssID, String month) throws SQLException, ClassNotFoundException {
        List<ClassPayment> classPayments = quaryDAO.getAllClassPayment(clssID,month);
        ArrayList<ClassPaymentDto> classPaymentDtos = new ArrayList<>();

        for (ClassPayment classPayment : classPayments){
            classPaymentDtos.add(new ClassPaymentDto(classPayment.getStId(),classPayment.getName(),classPayment.getDate(),classPayment.getAmount()));

        }

       return classPaymentDtos;
    }

    @Override
    public List<Class_paymentDto> getStudentAllPaymentBO(String id2) throws SQLException, ClassNotFoundException {

        List<Class_payment> classPayments = classPaymentDAO.getStudentAllPayment(id2);
        ArrayList<Class_paymentDto> classPaymentDtos = new ArrayList<>();

        for (Class_payment classPayment : classPayments){
            classPaymentDtos.add(new Class_paymentDto(classPayment.getPay_id(),classPayment.getClass_Id(),classPayment.getStu_Id(),classPayment.getName(),classPayment.getPaymentMonth(),classPayment.getDate(),classPayment.getFull_Id(),classPayment.getAmount()));

        }
        return classPaymentDtos;
    }
}
