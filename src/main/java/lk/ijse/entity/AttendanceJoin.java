package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AttendanceJoin {
    private String attendanceID;
    private Date date;
    private String time;
    private String cusID;
    private String stuName;
    private String stuID;




}
