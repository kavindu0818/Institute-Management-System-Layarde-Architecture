package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class SetPayment {
    private String payId;
    private Double amount;
    private String cusDfull;
    private String stuID;


}
