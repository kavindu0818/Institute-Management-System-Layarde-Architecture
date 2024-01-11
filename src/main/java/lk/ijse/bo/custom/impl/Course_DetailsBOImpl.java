package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.Course_DetailsBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CourseAttendanceDAO;
import lk.ijse.dao.custom.Course_DetailsDAO;
import lk.ijse.dao.custom.impl.Course_detailsDAOImpl;
import lk.ijse.dto.Course_detailsDto;
import lk.ijse.entity.Course_details;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Course_DetailsBOImpl implements Course_DetailsBO {

    Course_DetailsDAO courseDetailsDAO = (Course_DetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE_DETAILS);

    public boolean saveCourseDetailsStudent(String paymentID, String courseId, String stuId, String stuName, String courseName, Double amount) throws SQLException, ClassNotFoundException {

        return courseDetailsDAO.saveCourseDetails(paymentID,courseId,stuId,stuName,courseName,amount);
    }

    public Course_detailsDto getsendMailValueAll(String csId) throws SQLException, ClassNotFoundException {
        Course_details courseDetails = courseDetailsDAO.getsendMailValue(csId);
        Course_detailsDto courseDetailsDto = new Course_detailsDto(courseDetails.getCusDfull(),courseDetails.getCusId(),courseDetails.getStuId(),courseDetails.getStuName(),courseDetails.getCusName(),courseDetails.getPaidCusFee());


        return courseDetailsDto;
    }

    public List<Course_detailsDto> getAllCourseValueBO(String cd) throws SQLException, ClassNotFoundException {
        List<Course_details> courseDetails = courseDetailsDAO.getAllCourseValue(cd);
        ArrayList<Course_detailsDto> courseDetailsDtos = new ArrayList<>();

        for (Course_details course_details : courseDetails){
            courseDetailsDtos.add(new Course_detailsDto(course_details.getCusDfull(),course_details.getCusId(),course_details.getStuId(),course_details.getStuName(),course_details.getCusName(),course_details.getPaidCusFee()));

        }

       return courseDetailsDtos;
    }

    public Course_detailsDto courseNameBO(String cf) throws SQLException, ClassNotFoundException {

        Course_details courseDetails = courseDetailsDAO.courseName(cf);
        Course_detailsDto courseDetailsDto = new Course_detailsDto(courseDetails.getCusDfull(),courseDetails.getCusId(),courseDetails.getStuId(),courseDetails.getStuName(),courseDetails.getCusName(),courseDetails.getPaidCusFee());


        return courseDetailsDto;
    }

    public Course_detailsDto getAllDetailsBO(String id, String cusID) throws SQLException, ClassNotFoundException {
        Course_details courseDetails = courseDetailsDAO.getAllDetails(id,cusID);;
        Course_detailsDto courseDetailsDto = new Course_detailsDto(courseDetails.getCusDfull(),courseDetails.getCusId(),courseDetails.getStuId(),courseDetails.getStuName(),courseDetails.getCusName(),courseDetails.getPaidCusFee());
        return courseDetailsDto;
    }

    @Override
    public Course_detailsDto getAllValuesCdBO(String a) throws SQLException, ClassNotFoundException {

        Course_details courseDetails =courseDetailsDAO.getAllValuesCd(a);
        Course_detailsDto courseDetailsDto = new Course_detailsDto(courseDetails.getCusDfull(),courseDetails.getCusId(),courseDetails.getStuId(),courseDetails.getStuName(),courseDetails.getCusName(),courseDetails.getPaidCusFee());
        return courseDetailsDto;

    }

    @Override
    public List<Course_detailsDto> getCourseDetailsIDBO(String a) throws SQLException, ClassNotFoundException {
        List<Course_details> courseDetails = courseDetailsDAO.getCourseDetailsID(a);
        ArrayList<Course_detailsDto> courseDetailsDtos = new ArrayList<>();

        for (Course_details course_details : courseDetails){
            courseDetailsDtos.add(new Course_detailsDto(course_details.getCusDfull(),course_details.getCusId(),course_details.getStuId(),course_details.getStuName(),course_details.getCusName(),course_details.getPaidCusFee()));

        }

        return courseDetailsDtos;
    }
}
