package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.EmployeeAttendanceBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.EmlpoyeeAttendanceDAO;
import lk.ijse.dto.EmpAttendnaceDto;
import lk.ijse.dto.EmployeeAttendanceJoin;
import lk.ijse.entity.EmpAttendnace;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAttendanceBOImpl implements EmployeeAttendanceBO {

    EmlpoyeeAttendanceDAO employeeAttendanceDAO = (EmlpoyeeAttendanceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEEATTENDANCE);
    ;
    public List<EmployeeAttendanceJoin> getAllEmployeeAttndanceAll() throws SQLException, ClassNotFoundException {

        List<EmployeeAttendanceJoin> employeeAttendances =  employeeAttendanceDAO.getAllEmployeeAttndance();
        ArrayList<EmployeeAttendanceJoin> employeeAttendanceJoins = new ArrayList<>();

        for (EmployeeAttendanceJoin employeeAttendanceJoin : employeeAttendances){
            employeeAttendanceJoins.add(new EmployeeAttendanceJoin(employeeAttendanceJoin.getEmpID(),employeeAttendanceJoin.getEmpName()));
        }

        return employeeAttendanceJoins;
    }


    public boolean saveEmpAttendanceBo(String num, String empAttendanceID, String empId) throws SQLException, ClassNotFoundException {
        return employeeAttendanceDAO.saveEmpAttendance(num,empAttendanceID,empId);
    }

    public List<EmpAttendnaceDto> getAllEmployeeAttendanceBO(String id) throws SQLException, ClassNotFoundException {
        List<EmpAttendnace> empAttendnaces =  employeeAttendanceDAO.getAllEmployeeAttendance(id);
        ArrayList<EmpAttendnaceDto> empAttendnaceDtos = new ArrayList<>();

        for (EmpAttendnace empAttendnace: empAttendnaces){
            empAttendnaceDtos.add(new EmpAttendnaceDto(empAttendnace.getAttenId(),empAttendnace.getAttenMarkId(),empAttendnace.getEmpId(),empAttendnace.getDate(),empAttendnace.getTime()));
        }
        return empAttendnaceDtos;
    }

    @Override
    public int generateNextOrderIdBO() throws SQLException {
        return employeeAttendanceDAO.generateNextOrderId();
    }
}
