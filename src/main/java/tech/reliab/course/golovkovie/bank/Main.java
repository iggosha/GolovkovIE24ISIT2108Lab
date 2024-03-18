package tech.reliab.course.golovkovie.bank;

import tech.reliab.course.golovkovie.bank.entity.*;
import tech.reliab.course.golovkovie.bank.utlis.EntitiesGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final EntitiesGenerator entitiesGenerator = new EntitiesGenerator();
    private static final List<Bank> bankList = new ArrayList<>();
    private static final List<User> userList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        generateEntities();
        System.out.println("Input 1 to show users or input 2 to show banks");
        int inputNum = getInputInt();
        switch (inputNum) {
            case 1 -> {
                for (int i = 0; i < userList.size(); i++) {
                    System.out.println(i + userList.get(i).toString());
                }
                System.out.println("Input user's number to show his info: ");
                User selectedUser = userList.get(getInputInt());
                System.out.println(selectedUser);
                System.out.println("""
                        Select detail info:
                        1 Credit accounts list
                        2 Payment accounts list
                        3 Exit <-
                        """);
                int inputInt = getInputInt();
                if (inputInt == 1) {
                    System.out.println(selectedUser.getCreditAccounts());
                } else if (inputInt == 2) {
                    System.out.println(selectedUser.getPaymentAccounts());
                }
            }
            case 2 -> {
                for (int i = 0; i < bankList.size(); i++) {
                    System.out.println(i + bankList.get(i).toString());
                }
                System.out.println("Input bank's number to show info:");
                Bank selectedBank = bankList.get(getInputInt());
                System.out.println(selectedBank);
                System.out.println("""
                        Select detail info:
                        1 Offices list
                        2 Employees list
                        3 ATMs list
                        4 Exit <-
                        """);
                int inputInt = getInputInt();
                if (inputInt == 1) {
                    selectedBank.getOffices()
                            .forEach(System.out::println);
                } else if (inputInt == 2) {
                    selectedBank.getOffices()
                            .forEach(bankOffice ->
                                    bankOffice.getEmployees()
                                            .forEach(System.out::println));
                } else if (inputInt == 3) {
                    selectedBank.getOffices()
                            .forEach(bankOffice -> bankOffice.getBankAtms()
                                    .forEach(System.out::println));
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + inputNum);
        }
    }

    private static void generateEntities() {
        // k banks
        for (int k = 0; k < 5; k++) {
            bankList.add(entitiesGenerator.generateBank());
        }
        // k offices
        for (Bank bank : bankList) {
            for (int k = 0; k < 3; k++) {
                entitiesGenerator.generateBankOffice(bank);
            }
        }
        // k employees
        for (Bank bank : bankList) {
            for (BankOffice bankOffice : bank.getOffices()) {
                for (int k = 0; k < 5; k++) {
                    entitiesGenerator.generateEmployee(bankOffice);
                }
            }
        }
        // k bankAtms
        for (Bank bank : bankList) {
            for (int k = 0; k < 3; k++) {
                entitiesGenerator.generateBankAtm(getRandomEmployeeOfBank(bank));
            }
        }
        // k users
        for (Bank bank : bankList) {
            for (int k = 0; k < 5; k++) {
                User user = entitiesGenerator.generateUser();
                userList.add(user);
                bank.getUsers().add(user);
                user.getBanks().add(bank);
                generateAccountsForUserOfBank(bank, user);
            }
        }
    }

    private static void generateAccountsForUserOfBank(Bank bank, User user) {
        for (int j = 0; j < 2; j++) { // k accounts
            PaymentAccount paymentAccount = entitiesGenerator.generatePaymentAccount(user, bank);
            entitiesGenerator.generateCreditAccount(user, getRandomEmployeeOfBank(bank), paymentAccount);
        }
    }

    private static Employee getRandomEmployeeOfBank(Bank bank) {
        Random random = new Random();
        BankOffice randomOffice = bank.getOffices().get(random.nextInt(bank.getOffices().size()));
        return randomOffice.getEmployees().get(random.nextInt(randomOffice.getEmployees().size()));
    }

    private static int getInputInt() {
        return Integer.parseInt(scanner.nextLine());
    }
}
