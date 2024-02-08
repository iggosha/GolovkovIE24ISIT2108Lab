package tech.reliab.course.golovkovie.bank.service;

import tech.reliab.course.golovkovie.bank.entity.Bank;
import tech.reliab.course.golovkovie.bank.entity.PaymentAccount;
import tech.reliab.course.golovkovie.bank.entity.User;

/**
 * The interface Payment account service.
 */
public interface PaymentAccountService {

    /**
     * Create payment account.
     *
     * @param id      the id
     * @param user    the user
     * @param balance the balance
     * @param bank    the bank
     * @return the payment account
     */
    PaymentAccount createPaymentAccount(Long id, User user, Double balance, Bank bank);

    /**
     * Gets payment account by id.
     *
     * @param id the id
     * @return the payment account by id
     */
    PaymentAccount getPaymentAccountById(Long id);

    /**
     * Update payment account by id.
     *
     * @param id the id
     */
    void updatePaymentAccountById(Long id);

    /**
     * Delete payment account by id.
     *
     * @param id the id
     */
    void deletePaymentAccountById(Long id);
}
