package tech.reliab.course.golovkovie.bank.utlis;

import tech.reliab.course.golovkovie.bank.entity.*;
import tech.reliab.course.golovkovie.bank.service.*;
import tech.reliab.course.golovkovie.bank.service.impl.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class EntitiesGenerator {

    private final BankService bankService = new BankServiceImpl();
    private final BankAtmService bankAtmService = new BankAtmServiceImpl();
    private final BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
    private final CreditAccountService creditAccountService = new CreditAccountServiceImpl();
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    private final PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final Random random = new Random();
    private final String[] firstNames = {"Igor", "Alexander", "Artem", "Mikhail"};
    private final String[] middleNames = {"Igorevich", "Alexandrovich", "Artemovich", "Mikhailovich"};
    private final String[] lastNames = {"Pervov", "Vtorov", "Tretyev", "Chetvertov"};
    private final String[] placesOfWork = {"SberBank", "Alfa-Bank", "VTB Bank", "Tinkoff Bank"};
    private final String[] positions = {"Manager", "Developer", "Boss", "Engineer"};

    public Bank generateBank() {
        return bankService.createBank(
                random.nextLong(),
                "Bank " + UUID.randomUUID().toString().substring(0, 2)
        );
    }

    public BankOffice generateBankOffice(Bank bank, int orderNumber) {
        return bankOfficeService.createBankOffice(
                random.nextLong(),
                bank.getName() + " office " + orderNumber,
                "Bankirskaya, " + orderNumber,
                true,
                true,
                0,
                true,
                true,
                true,
                (double) orderNumber * 10,
                (double) orderNumber * 5,
                bank
        );
    }

    public Employee generateEmployee(Bank bank, BankOffice bankOffice, int orderNumber) {
        return employeeService.createEmployee(
                random.nextLong(),
                getGeneratedFullName(),
                LocalDate.now(),
                positions[random.nextInt(4)],
                bank,
                true,
                bankOffice,
                true,
                (double) orderNumber * 10
        );
    }

    public BankAtm generateBankAtm(Bank bank, BankOffice bankOffice, Employee employee, int orderNumber) {
        return bankAtmService.createBankAtm(
                random.nextLong(),
                bank.getName() + " ATM #" + orderNumber,
                "Working",
                bank,
                bankOffice,
                employee,
                true,
                true,
                (double) orderNumber * 10,
                (double) orderNumber * 5
        );
    }

    public User generateUser(List<Bank> banks) {
        return userService.createUser(
                random.nextLong(),
                getGeneratedFullName(),
                LocalDate.now(),
                placesOfWork[random.nextInt(4)],
                banks
        );
    }

    public PaymentAccount generatePaymentAccount(User user, Bank bank) {
        return paymentAccountService.createPaymentAccount(
                random.nextLong(),
                user,
                bank
        );
    }

    public CreditAccount generateCreditAccount(User user, Employee employee, PaymentAccount paymentAccount, Bank bank, int orderNumber) {
        return creditAccountService.createCreditAccount(
                random.nextLong(),
                user,
                LocalDate.now(),
                LocalDate.now(),
                orderNumber * 2,
                (double) orderNumber * 10,
                (double) orderNumber * 5,
                employee,
                paymentAccount,
                bank
        );
    }

    private String getGeneratedFullName() {
        return lastNames[random.nextInt(lastNames.length)] + " " +
                firstNames[random.nextInt(firstNames.length)] + " " +
                middleNames[random.nextInt(middleNames.length)];
    }
}
