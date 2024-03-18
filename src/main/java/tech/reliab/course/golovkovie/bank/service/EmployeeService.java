package tech.reliab.course.golovkovie.bank.service;

import tech.reliab.course.golovkovie.bank.entity.BankOffice;
import tech.reliab.course.golovkovie.bank.entity.Employee;

import java.time.LocalDate;

/**
 * The interface Employee service.
 */
public interface EmployeeService {

    /**
     * Create employee.
     *
     * @param id             the id
     * @param fullName       the full name
     * @param dateOfBirth    the date of birth
     * @param position       the position=
     * @param isRemote       the is remote
     * @param bankOffice     the bank office
     * @param canIssueCredit the can issue credit
     * @param salary         the salary
     * @return the employee
     */
    Employee createEmployee(Long id,
                            String fullName,
                            LocalDate dateOfBirth,
                            String position,
                            Boolean isRemote,
                            Boolean canIssueCredit,
                            Double salary,
                            BankOffice bankOffice);

    /**
     * Gets employee by id.
     *
     * @param id the id
     * @return the employee by id
     */
    Employee getEmployeeById(Long id);

    /**
     * Update employee by id.
     *
     * @param id the id
     */
    void updateEmployeeById(Long id);

    /**
     * Delete employee by id.
     *
     * @param id the id
     */
    void deleteEmployeeById(Long id);

}
