package tech.reliab.course.golovkovie.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class User {

    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String placeOfWork;
    private Double monthlyIncome;
    private List<Bank> banks;
    private List<CreditAccount> creditAccounts;
    private List<PaymentAccount> paymentAccounts;
    private Integer creditRating;
}