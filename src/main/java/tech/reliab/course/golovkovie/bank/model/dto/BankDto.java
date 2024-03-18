package tech.reliab.course.golovkovie.bank.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankDto {

    private String name;

    private Integer rating;

    private Double totalMoney;

    private Double interestRate;
}
