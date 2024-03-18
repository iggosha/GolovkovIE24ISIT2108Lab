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
public class User {

    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String placeOfWork;
    private Double monthlyIncome;
    private Integer creditRating;
    private List<Bank> banks;
    private List<CreditAccount> creditAccounts;
    private List<PaymentAccount> paymentAccounts;

    @Override
    public String toString() {
        return """
                    id: %d,
                    fullName: %s,
                    dateOfBirth: %s,
                    placeOfWork: %s,
                    monthlyIncome: %.2f,
                    creditRating: %d,
                    banks: %s,
                    creditAccounts: %s,
                    paymentAccounts: %s
                """.formatted(
                id,
                fullName,
                dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                placeOfWork,
                monthlyIncome,
                creditRating,
                banks.stream().map(Bank::getName).toList(),
                creditAccounts.stream().map(CreditAccount::getId).toList(),
                paymentAccounts.stream().map(PaymentAccount::getId).toList()
        );
    }
}