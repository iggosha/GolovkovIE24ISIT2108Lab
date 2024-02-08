package tech.reliab.course.golovkovie.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Bank {

    private Long id;
    private String name;
    private Integer officesAmount;
    private Integer atmsAmount;
    private Integer employeesAmount;
    private Integer customersAmount;
    private Integer rating;
    private Double totalMoney;
    private Double interestRate;
}