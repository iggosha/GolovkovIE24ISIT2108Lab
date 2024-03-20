package tech.reliab.course.golovkovie.bank.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankOfficeResponseDto {

    Long id;
    String name;
    String address;
    Double totalMoney;
    Double rentCost;
    Boolean isWorking;
    Boolean canPlaceAtm;
    Boolean canIssueCredit;
    Boolean canDispenseMoney;
    Boolean canAcceptMoney;
}
