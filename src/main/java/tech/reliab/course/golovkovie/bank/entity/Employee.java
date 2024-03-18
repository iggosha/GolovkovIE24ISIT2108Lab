package tech.reliab.course.golovkovie.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@Builder
public class Employee {

    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String position;
    private Double salary;
    private Boolean isRemote;
    private Boolean canIssueCredit;
    private BankOffice bankOffice;
    private List<BankAtm> servedAtms;
    private List<CreditAccount> providedCreditAccounts;

    @Override
    public String toString() {
        return """
                    id: %d,
                    fullName: %s,
                    dateOfBirth: %s,
                    position: %s,
                    salary: %.2f,
                    isRemote: %b,
                    canIssueCredit: %b,
                    bankOffice: %s,
                    servedAtms: %s,
                    providedCreditAccounts: %s
                """.formatted(
                id,
                fullName,
                dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                position,
                salary,
                isRemote,
                canIssueCredit,
                bankOffice.getName(),
                servedAtms.stream().map(BankAtm::getName).toList(),
                providedCreditAccounts.stream().map(CreditAccount::getId).toList()
        );
    }


}