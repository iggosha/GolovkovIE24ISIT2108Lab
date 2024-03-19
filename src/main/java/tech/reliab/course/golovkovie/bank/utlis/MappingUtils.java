package tech.reliab.course.golovkovie.bank.utlis;

import org.springframework.stereotype.Service;
import tech.reliab.course.golovkovie.bank.model.dto.response.BankResponseDto;
import tech.reliab.course.golovkovie.bank.model.entity.Bank;

@Service
public class MappingUtils {

    public BankResponseDto mapToBankResponseDto(Bank bank) {
        return BankMapper.mapToBankResponseDto(bank);
    }

    public Bank mapToBankEntity(BankResponseDto bankResponseDto) {
        return BankMapper.mapToBankEntity(bankResponseDto);
    }

    private static class BankMapper {

        private static BankResponseDto mapToBankResponseDto(Bank bank) {
            return BankResponseDto.builder()
                    .id(bank.getId())
                    .interestRate(bank.getInterestRate())
                    .name(bank.getName())
                    .rating(bank.getRating())
                    .totalMoney(bank.getTotalMoney())
                    .build();
        }

        private static Bank mapToBankEntity(BankResponseDto bankResponseDto) {
            return Bank.builder()
                    .id(bankResponseDto.getId())
                    .interestRate(bankResponseDto.getInterestRate())
                    .name(bankResponseDto.getName())
                    .rating(bankResponseDto.getRating())
                    .totalMoney(bankResponseDto.getTotalMoney())
                    .build();
        }
    }
}
