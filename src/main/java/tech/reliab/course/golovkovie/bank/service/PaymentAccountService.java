package tech.reliab.course.golovkovie.bank.service;

import tech.reliab.course.golovkovie.bank.model.entity.Bank;
import tech.reliab.course.golovkovie.bank.model.entity.PaymentAccount;
import tech.reliab.course.golovkovie.bank.model.entity.User;

/**
 * The interface Payment account service.
 */
public interface PaymentAccountService {

    /**
     * Create payment account.
     *
     * @param id      the id
     * @param user    the user
     * @param bank    the bank
     * @return the payment account
     */
    PaymentAccount createPaymentAccount(Long id, User user, Bank bank);

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
