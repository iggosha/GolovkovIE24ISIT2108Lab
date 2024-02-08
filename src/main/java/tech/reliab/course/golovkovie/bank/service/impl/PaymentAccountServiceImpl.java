package tech.reliab.course.golovkovie.bank.service.impl;

import tech.reliab.course.golovkovie.bank.entity.Bank;
import tech.reliab.course.golovkovie.bank.entity.PaymentAccount;
import tech.reliab.course.golovkovie.bank.entity.User;
import tech.reliab.course.golovkovie.bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {

    /**
     * @param id      the id
     * @param user    the user
     *                <br>Name of the bank where this account is opened
     * @param balance the balance
     * @param bank    the bank
     * @return {@link PaymentAccount}
     */
    @Override
    public PaymentAccount createPaymentAccount(Long id, User user, Double balance, Bank bank) {
        return PaymentAccount.builder()
                .id(id)
                .user(user)
                .bankName(bank.getName())
                .balance(balance)
                .build();
    }

    @Override
    public PaymentAccount getPaymentAccountById(Long id) {
        return null;
    }

    @Override
    public void updatePaymentAccountById(Long id) {

    }

    @Override
    public void deletePaymentAccountById(Long id) {

    }
}
