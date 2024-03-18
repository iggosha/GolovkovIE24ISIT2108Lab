package tech.reliab.course.golovkovie.bank.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "banks")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer rating;

    @Column(name = "total_money")
    private Double totalMoney;

    @Column(name = "interest_rate")
    private Double interestRate;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private List<BankOffice> offices;

    @ManyToMany(mappedBy = "banks")
    private List<User> users;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
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