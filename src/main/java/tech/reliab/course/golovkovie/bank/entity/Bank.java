package tech.reliab.course.golovkovie.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Bank {

    private Long id;
    private String name;
    private Integer rating;
    private Double totalMoney;
    private Double interestRate;
    private List<BankOffice> offices;
    private List<User> users;
    private List<PaymentAccount> paymentAccounts;


    @Override
    public String toString() {
        return """
                    id: %d,
                    name: %s,
                    rating: %d,
                    totalMoney: %.2f,
                    interestRate: %.2f,
                    offices: %s,
                    users: %s,
                    paymentAccounts: %s
                """.formatted(
                id,
                name,
                rating,
                totalMoney,
                interestRate,
                offices.stream().map(BankOffice::getName).toList(),
                users.stream().map(User::getFullName).toList(),
                paymentAccounts.stream().map(PaymentAccount::getId).toList()
        );
    }
}