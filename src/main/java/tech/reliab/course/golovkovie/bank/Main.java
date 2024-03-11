package tech.reliab.course.golovkovie.bank;

import tech.reliab.course.golovkovie.bank.entity.Bank;
import tech.reliab.course.golovkovie.bank.entity.CreditAccount;
import tech.reliab.course.golovkovie.bank.entity.PaymentAccount;
import tech.reliab.course.golovkovie.bank.entity.User;
import tech.reliab.course.golovkovie.bank.utlis.EntitiesGenerator;
import tech.reliab.course.golovkovie.bank.utlis.EntitiesKeeper;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final EntitiesGenerator entitiesGenerator = new EntitiesGenerator();
    private static final EntitiesKeeper entitiesKeeper = new EntitiesKeeper();
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        generateEntities();

        for (int i = 0; i < entitiesKeeper.bankList.size(); i++) {
            System.out.println(i + " " + entitiesKeeper.bankList.get(i).getName());
        }

        System.out.println("Input bank number to show info:");
        int bankNum = getInputInt();
        Bank selectedBank = entitiesKeeper.bankList.get(bankNum);
        System.out.println(selectedBank);

        while (true) {
            System.out.println("""
                    Select detail info:
                    1 Offices list
                    2 Employees list
                    3 ATMs list
                    4 Users list
                    5 Exit <-
                    """);
            switch (getInputInt()) {
                case 1 -> {
                    for (int i = bankNum * 3; i < bankNum * 3 + 3; i++) {
                        System.out.println(entitiesKeeper.bankOfficeList.get(i));
                    }
                }
                case 2 -> {
                    for (int i = bankNum * 15; i < bankNum * 15 + 15; i++) {
                        System.out.println(entitiesKeeper.employeeList.get(i));
                    }
                }
                case 3 -> {
                    for (int i = bankNum * 3; i < bankNum * 3 + 3; i++) {
                        System.out.println(entitiesKeeper.bankAtmList.get(i));
                    }
                }
                case 4 -> {
                    for (User user : entitiesKeeper.userList) {
                        if (!user.getBanks().contains(selectedBank)) {
                            continue;
                        }
                        System.out.println(user);
                        printUserAccountsIfRequested(user, entitiesKeeper.creditAccountList, entitiesKeeper.paymentAccountList);
                    }
                }
                default -> {
                    return;
                }
            }
        }
    }

    private static void generateEntities() {
        // k banks
        for (int k = 0; k < 5; k++) {
            entitiesKeeper.bankList.add(entitiesGenerator.generateBank());
        }

        for (int i = 0; i < 5; i++) { // bank
            for (int k = 0; k < 3; k++) { // k offices
                entitiesKeeper.bankOfficeList.add(entitiesGenerator.generateBankOffice(
                                entitiesKeeper.bankList.get(i),
                                i * 3 + k
                        )
                );
            }
        }

        for (int i = 0; i < 5; i++) { // bank
            for (int j = 0; j < 3; j++) { // office
                for (int k = 0; k < 5; k++) { // k employees
                    entitiesKeeper.employeeList.add(
                            entitiesGenerator.generateEmployee(
                                    entitiesKeeper.bankList.get(i),
                                    entitiesKeeper.bankOfficeList.get(i * 3 + j),
                                    i * 3 + j * 5 + k
                            )
                    );
                }
            }
        }

        for (int i = 0; i < 5; i++) { // bank
            for (int j = 0; j < 3; j++) { // office
                entitiesKeeper.bankAtmList.add(entitiesGenerator.generateBankAtm(
                                entitiesKeeper.bankList.get(i),
                                entitiesKeeper.bankOfficeList.get(i * 3 + j),
                                entitiesKeeper.employeeList.get(i * 5 + j),
                                i * 3 + j
                        )
                );
            }
        }

        for (int i = 0; i < 5; i++) { // bank
            for (int k = 0; k < 5; k++) { // k users
                entitiesKeeper.userList.add(
                        entitiesGenerator.generateUser(
                                List.of(entitiesKeeper.bankList.get(i))
                        )
                );
            }
        }

        for (int i = 0; i < 5; i++) { // bank
            for (int j = 0; j < 5; j++) { // user
                for (int k = 0; k < 2; k++) { // k accounts
                    entitiesKeeper.paymentAccountList.add(
                            entitiesGenerator.generatePaymentAccount(
                                    entitiesKeeper.userList.get(i * 5 + j),
                                    entitiesKeeper.bankList.get(i)
                            )
                    );
                    entitiesKeeper.creditAccountList.add(
                            entitiesGenerator.generateCreditAccount(
                                    entitiesKeeper.userList.get(i * 5 + j),
                                    entitiesKeeper.employeeList.get(i * 5 + j),
                                    entitiesKeeper.paymentAccountList.get(i * 5 + j * 2 + k),
                                    entitiesKeeper.bankList.get(i),
                                    i * 5 + j * 2 + k
                            )
                    );
                }
            }
        }
    }

    private static void printUserAccountsIfRequested(User user, List<CreditAccount> creditAccountList, List<PaymentAccount> paymentAccountList) {
        System.out.println("Input 1 to show user's accounts or 0 to skip:");
        if (getInputInt() != 1) {
            return;
        }
        for (CreditAccount creditAccount : creditAccountList) {
            if (creditAccount.getUser().equals(user)) {
                System.out.println(creditAccount);
            }
        }
        for (PaymentAccount paymentAccount : paymentAccountList) {
            if (paymentAccount.getUser().equals(user)) {
                System.out.println(paymentAccount);
            }
        }
    }

    private static int getInputInt() {
        return Integer.parseInt(scanner.nextLine());
    }
}
