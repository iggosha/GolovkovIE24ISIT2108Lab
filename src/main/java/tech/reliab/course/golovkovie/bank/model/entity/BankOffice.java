package tech.reliab.course.golovkovie.bank.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "bank_offices")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @Column(name = "total_money")
    private Double totalMoney;

    @Column(name = "rent_cost")
    private Double rentCost;

    @Column(name = "is_working")
    private Boolean isWorking;

    @Column(name = "can_place_atm")
    private Boolean canPlaceAtm;

    @Column(name = "can_issue_credit")
    private Boolean canIssueCredit;

    @Column(name = "can_dispense_money")
    private Boolean canDispenseMoney;

    @Column(name = "can_accept_money")
    private Boolean canAcceptMoney;

    @OneToMany(mappedBy = "bankOffice", cascade = CascadeType.ALL)
    private List<BankAtm> bankAtms;

    @OneToMany(mappedBy = "bankOffice", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @ManyToOne
    @JoinColumn(name = "bank_id")
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