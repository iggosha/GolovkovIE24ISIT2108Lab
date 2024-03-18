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
@Table(name = "employees")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    private String position;

    private Double salary;

    @Column(name = "is_remote")
    private Boolean isRemote;

    @Column(name = "can_issue_credit")
    private Boolean canIssueCredit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_office_id")
    private BankOffice bankOffice;

    @OneToMany(mappedBy = "servingEmployee", cascade = CascadeType.ALL)
    private List<BankAtm> servedAtms;

    @OneToMany(mappedBy = "providedEmployee", cascade = CascadeType.ALL)
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