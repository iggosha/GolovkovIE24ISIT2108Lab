package tech.reliab.course.golovkovie.bank.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "credit_accounts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "months_of_credit_amount")
    private Integer monthsOfCreditAmount;

    @Column(name = "credit_sum")
    private Double creditSum;

    @Column(name = "monthly_payment")
    private Double monthlyPayment;

    @Column(name = "interest_rate")
    private Double interestRate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "provided_employee_id")
    private Employee providedEmployee;

    @OneToOne
    @JoinColumn(name = "payment_account_id")
    private PaymentAccount paymentAccount;

    @Override
    public String toString() {
        return """
                     id: %d,
                     startDate: %s,
                     endDate: %s,
                     monthsOfCreditAmount: %d,
                     creditSum: %.2f,
                     monthlyPayment: %.2f,
                     interestRate: %.2f,
                     user: %s,
                     bank: %s,
                     providedEmployee: %s,
                     paymentAccount: %s
                """.formatted(
                id,
                startDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                endDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                monthsOfCreditAmount,
                creditSum,
                monthlyPayment,
                interestRate,
                user.getFullName(),
                bank.getName(),
                providedEmployee.getFullName(),
                paymentAccount.getId()
        );
    }
}