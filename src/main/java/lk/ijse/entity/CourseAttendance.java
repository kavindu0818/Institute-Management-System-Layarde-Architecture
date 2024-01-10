package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CourseAttendance {
    private String attendanceID;
    private String cusfullId;
    private String date;
    private String time;
}
