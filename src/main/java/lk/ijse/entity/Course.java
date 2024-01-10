package lk.ijse.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Course {
    private String cusId;
    private String cusName;
    private String CusFee;
    private String courseStartDay;
    private String courseDuration;

}
