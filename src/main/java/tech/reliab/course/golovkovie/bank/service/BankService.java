package tech.reliab.course.golovkovie.bank.service;

import tech.reliab.course.golovkovie.bank.model.dto.BankDto;
import tech.reliab.course.golovkovie.bank.model.entity.Bank;

import java.util.List;

/**
 * The interface Bank service.
 */
public interface BankService {

    /**
     * Create bank.
     *
     * @param bankDto bankDto
     */
    void createBank(BankDto bankDto);

    /**
     * Get bank by id.
     *
     * @param id the id
     * @return the bank by id
     */
    BankDto getBankDtoById(Long id);

    /**
     * Get all banks
     *
     * @return all banks
     */
    List<BankDto> getAllDto();

    /**
     * Update bank by id.
     *
     * @param id   the id
     * @param bank the bank
     */
    void updateBankById(Long id, Bank bank);

    /**
     * Delete bank by id.
     *
     * @param id   the id
     * @param bank the bank
     */
    void deleteBankById(Long id, Bank bank);
}
