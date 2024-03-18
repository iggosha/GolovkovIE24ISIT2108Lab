package tech.reliab.course.golovkovie.bank.service.impl;

import tech.reliab.course.golovkovie.bank.model.entity.Bank;
import tech.reliab.course.golovkovie.bank.model.entity.PaymentAccount;
import tech.reliab.course.golovkovie.bank.model.entity.User;
import tech.reliab.course.golovkovie.bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {

    /**
     * @param id      the id
     * @param user    the user
     *                <br>Name of the bank where this account is opened
     *                <br>Balance (0.0 by default)
     * @param bank    the bank
     * @return {@link PaymentAccount}
     */
    @Override
    public PaymentAccount createPaymentAccount(Long id, User user, Bank bank) {
        PaymentAccount paymentAccount = PaymentAccount.builder()
                .id(id)
                .user(user)
                .bank(bank)
                .balance(0.0)
                .build();
        user.getPaymentAccounts().add(paymentAccount);
        bank.getPaymentAccounts().add(paymentAccount);
        return paymentAccount;
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
