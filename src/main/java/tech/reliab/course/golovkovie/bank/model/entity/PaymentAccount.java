package tech.reliab.course.golovkovie.bank.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "payment_accounts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @Override
    public String toString() {
        return """
                    id: %d,
                    balance: %.2f,
                    user: %s,
                    bank: %s
                """.formatted(
                id,
                balance,
                user.getFullName(),
                bank.getName()
        );
    }
}