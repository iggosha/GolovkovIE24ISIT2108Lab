package tech.reliab.course.golovkovie.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BankOffice {

    private Long id;
    private String name;
    private String address;
    private Double totalMoney;
    private Double rentCost;
    private Boolean isWorking;
    private Boolean canPlaceAtm;
    private Boolean canIssueCredit;
    private Boolean canDispenseMoney;
    private Boolean canAcceptMoney;
    private List<BankAtm> bankAtms;
    private List<Employee> employees;
    private Bank bank;

    @Override
    public String toString() {
        return """
                    id: %d,
                    name: %s,
                    address: %s,
                    totalMoney: %.2f,
                    rentCost: %.2f,
                    isWorking: %b,
                    canPlaceAtm: %b,
                    canIssueCredit: %b,
                    canDispenseMoney: %b,
                    canAcceptMoney: %b,
                    bankAtms: %s,
                    employees: %s,
                    bank: %s
                """.formatted(
                id,
                name,
                address,
                totalMoney,
                rentCost,
                isWorking,
                canPlaceAtm,
                canIssueCredit,
                canDispenseMoney,
                canAcceptMoney,
                bankAtms.stream().map(BankAtm::getName).toList(),
                employees.stream().map(Employee::getFullName).toList(),
                bank.getName()
        );
    }
}