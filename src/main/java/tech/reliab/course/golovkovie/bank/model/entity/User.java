package tech.reliab.course.golovkovie.bank.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "place_of_work")
    private String placeOfWork;

    @Column(name = "monthly_income")
    private Double monthlyIncome;

    @Column(name = "credit_rating")
    private Integer creditRating;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_bank",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "bank_id")
    )
    private List<Bank> banks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CreditAccount> creditAccounts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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