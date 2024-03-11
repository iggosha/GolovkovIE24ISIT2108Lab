package tech.reliab.course.golovkovie.bank.utlis;

import tech.reliab.course.golovkovie.bank.entity.*;

import java.util.ArrayList;
import java.util.List;

public class EntitiesKeeper {

    public final List<Bank> bankList = new ArrayList<>();
    public final List<BankOffice> bankOfficeList = new ArrayList<>();
    public final List<Employee> employeeList = new ArrayList<>();
    public final List<BankAtm> bankAtmList = new ArrayList<>();
    public final List<User> userList = new ArrayList<>();
    public final List<PaymentAccount> paymentAccountList = new ArrayList<>();
    public final List<CreditAccount> creditAccountList = new ArrayList<>();
}
