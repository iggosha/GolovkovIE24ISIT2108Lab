package tech.reliab.course.golovkovie.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class PaymentAccount {

    private Long id;
    private User user;
    private String bankName;
    private Double balance;

}