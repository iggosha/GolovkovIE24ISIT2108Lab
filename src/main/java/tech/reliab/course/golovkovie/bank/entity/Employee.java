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
public class Employee {

    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String position;
    private Bank bank;
    private Boolean isRemote;
    private BankOffice bankOffice;
    private Boolean canIssueCredit;
    private Double salary;

}