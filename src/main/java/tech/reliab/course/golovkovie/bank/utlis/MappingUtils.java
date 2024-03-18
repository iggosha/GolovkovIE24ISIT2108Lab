package tech.reliab.course.golovkovie.bank.utlis;

import org.springframework.stereotype.Service;
import tech.reliab.course.golovkovie.bank.model.dto.BankDto;
import tech.reliab.course.golovkovie.bank.model.entity.Bank;

@Service
public class MappingUtils {

    public BankDto mapToBankDto(Bank bank) {
        BankDto bankDto = BankDto.builder()
                .interestRate(bank.getInterestRate())
                .name(bank.getName())
                .rating(bank.getRating())
                .totalMoney(bank.getTotalMoney())
                .build();
        return bankDto;
    }

    public Bank mapToBankEntity(BankDto bankDto) {
        Bank bank = Bank.builder()
                .interestRate(bankDto.getInterestRate())
                .name(bankDto.getName())
                .rating(bankDto.getRating())
                .totalMoney(bankDto.getTotalMoney())
                .build();
        return bank;
    }
}
