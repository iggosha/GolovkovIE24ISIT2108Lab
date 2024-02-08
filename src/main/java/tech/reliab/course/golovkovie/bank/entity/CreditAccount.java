package tech.reliab.course.golovkovie.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
public class CreditAccount {
    private Long id;
    private User user;
    private String bankName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer monthsOfCreditAmount;
    private Double creditSum;
    private Double monthlyPayment;
    private Double interestRate;
    private Employee providedEmployee;
    private PaymentAccount paymentAccount;
}