package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.EmployeeAttendanceBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.Course_PaymentDAO;
import lk.ijse.dao.custom.EmlpoyeeAttendanceDAO;
import lk.ijse.dao.custom.impl.EmployeeAttendanceDAOImpl;
import lk.ijse.dto.EmpAttendnaceDto;
import lk.ijse.dto.EmployeeAttendanceJoin;
import lk.ijse.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public class EmployeeAttendanceBOImpl implements EmployeeAttendanceBO {

    EmlpoyeeAttendanceDAO employeeAttendanceDAO = (EmlpoyeeAttendanceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEEATTENDANCE);
    ;
    public List<EmployeeAttendanceJoin> getAllEmployeeAttndanceAll() throws SQLException, ClassNotFoundException {

        return employeeAttendanceDAO.getAllEmployeeAttndance();
    }


    public boolean saveEmpAttendanceBo(String num, String empAttendanceID, String empId) throws SQLException, ClassNotFoundException {
        return employeeAttendanceDAO.saveEmpAttendance(num,empAttendanceID,empId);
    }

    public List<EmpAttendnaceDto> getAllEmployeeAttendanceBO(String id) throws SQLException, ClassNotFoundException {
        return employeeAttendanceDAO.getAllEmployeeAttendance(id);
    }

    @Override
    public int generateNextOrderIdBO() throws SQLException {
        return employeeAttendanceDAO.generateNextOrderId();
    }
}
