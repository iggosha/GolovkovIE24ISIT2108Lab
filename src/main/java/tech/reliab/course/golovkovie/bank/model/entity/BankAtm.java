package tech.reliab.course.golovkovie.bank.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bank_atms")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAtm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String status;

    @Column(name = "total_money")
    private Double totalMoney;

    @Column(name = "maintenance_cost")
    private Double maintenanceCost;

    @Column(name = "can_dispense_money")
    private Boolean canDispenseMoney;

    @Column(name = "can_accept_money")
    private Boolean canAcceptMoney;

    @ManyToOne
    @JoinColumn(name = "bank_office_id")
    private BankOffice bankOffice;

    @ManyToOne
    @JoinColumn(name = "serving_employee_id")
    private Employee servingEmployee;

    @Override
    public String toString() {
        return """
                    id: %d,
                    name: %s,
                    address: %s,
                    status: %s,
                    totalMoney: %.2f,
                    maintenanceCost: %.2f,
                    canDispenseMoney: %b,
                    canAcceptMoney: %b,
                    bankOffice: %s,
                    servingEmployee: %s
                """.formatted(
                id,
                name,
                address,
                status,
                totalMoney,
                maintenanceCost,
                canDispenseMoney,
                canAcceptMoney,
                bankOffice.getName(),
                servingEmployee.getFullName());
    }
}