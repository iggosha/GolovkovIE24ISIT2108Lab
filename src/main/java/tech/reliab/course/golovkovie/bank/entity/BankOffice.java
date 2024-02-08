package tech.reliab.course.golovkovie.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class BankOffice {

    private Long id;
    private String name;
    private String address;
    private Boolean isWorking;
    private Boolean canPlaceAtm;
    private Integer atmsAmount;
    private Boolean canIssueCredit;
    private Boolean canDispenseMoney;
    private Boolean canAcceptMoney;
    private Double totalMoney;
    private Double rentCost;
}