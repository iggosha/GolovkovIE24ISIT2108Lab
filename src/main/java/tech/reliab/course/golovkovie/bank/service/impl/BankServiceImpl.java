package tech.reliab.course.golovkovie.bank.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.golovkovie.bank.model.dto.BankDto;
import tech.reliab.course.golovkovie.bank.model.entity.Bank;
import tech.reliab.course.golovkovie.bank.repository.BankRepository;
import tech.reliab.course.golovkovie.bank.service.BankService;
import tech.reliab.course.golovkovie.bank.utlis.MappingUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The type Bank service.
 */
@Service
@AllArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;
    private final MappingUtils mappingUtils;

    /**
     *             <br>Number of offices (automatically filled and calculated when adding a new office, default 0 <br>
     *             Number of ATMs (automatically filled and calculated when adding a new ATM, default 0<br>
     *             Number of employees (automatically filled and calculated when adding a new employee, default 0<br>
     *             Number of clients (automatically filled and calculated when adding a new client, default 0<br>
     *             Bank rating (generated randomly, from 0 to 100, where 100 is the highest score, the higher the bank rating, the lower the interest rate)<br>
     *             Total money in the bank (generated randomly, but not more than 1,000,000)<br>
     *             Interest rate (generated randomly, but not more than 20%, however, the bank rating must be taken into account, the higher it is, the lower the interest rate should be generated)<br>
     */
    @Override
    public void createBank(BankDto bankDto) {
        Random random = new Random();
        Bank bank = Bank.builder()
                .name(bankDto.getName())
                .rating(random.nextInt(101))
                .totalMoney(Math.round(random.nextDouble(1_000_000) * 100.0) / 100.0)
                .offices(new ArrayList<>())
                .users(new ArrayList<>())
                .paymentAccounts(new ArrayList<>())
                .build();
        bank.setInterestRate(Math.round((20 - bank.getRating() * 0.2) * 100.0) / 100.0);
        bankRepository.save(bank);
    }

    @Override
    public BankDto getBankDtoById(Long id) {
        return mappingUtils.mapToBankDto(
                bankRepository.findById(id)
                        .orElse(new Bank())
        );
    }

    @Override
    public List<BankDto> getAllDto() {
        return bankRepository.findAll()
                .stream()
                .map(mappingUtils::mapToBankDto)
                .toList();
    }

    @Override
    public void updateBankById(Long id, Bank bank) {
    }

    @Override
    public void deleteBankById(Long id, Bank bank) {

    }
}
