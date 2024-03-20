package tech.reliab.course.golovkovie.bank.utlis;

import org.springframework.stereotype.Service;
import tech.reliab.course.golovkovie.bank.model.dto.response.BankOfficeResponseDto;
import tech.reliab.course.golovkovie.bank.model.dto.response.BankResponseDto;
import tech.reliab.course.golovkovie.bank.model.entity.Bank;
import tech.reliab.course.golovkovie.bank.model.entity.BankOffice;

@Service
public class MappingUtils {

    public BankResponseDto mapToBankResponseDto(Bank bank) {
        return BankMapper.mapToBankResponseDto(bank);
    }

    public Bank mapToBankEntity(BankResponseDto bankResponseDto) {
        return BankMapper.mapToBankEntity(bankResponseDto);
    }

    public BankOfficeResponseDto mapToBankOfficeResponseDto(BankOffice bankOffice) {
        return BankOfficeMapper.mapToBankOfficeResponseDto(bankOffice);
    }

    public BankOffice mapToBankOfficeEntity(BankOfficeResponseDto bankOfficeResponseDto) {
        return BankOfficeMapper.mapToBankOfficeEntity(bankOfficeResponseDto);
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


    private static class BankOfficeMapper {

        private static BankOfficeResponseDto mapToBankOfficeResponseDto(BankOffice bankOffice) {
            return BankOfficeResponseDto.builder()
                    .id(bankOffice.getId())
                    .name(bankOffice.getName())
                    .address(bankOffice.getAddress())
                    .totalMoney(bankOffice.getTotalMoney())
                    .rentCost(bankOffice.getRentCost())
                    .isWorking(bankOffice.getIsWorking())
                    .canPlaceAtm(bankOffice.getCanPlaceAtm())
                    .canIssueCredit(bankOffice.getCanIssueCredit())
                    .canDispenseMoney(bankOffice.getCanDispenseMoney())
                    .canAcceptMoney(bankOffice.getCanAcceptMoney())
                    .build();
        }

        private static BankOffice mapToBankOfficeEntity(BankOfficeResponseDto bankOfficeResponseDto) {
            return BankOffice.builder()
                    .id(bankOfficeResponseDto.getId())
                    .name(bankOfficeResponseDto.getName())
                    .address(bankOfficeResponseDto.getAddress())
                    .totalMoney(bankOfficeResponseDto.getTotalMoney())
                    .rentCost(bankOfficeResponseDto.getRentCost())
                    .isWorking(bankOfficeResponseDto.getIsWorking())
                    .canPlaceAtm(bankOfficeResponseDto.getCanPlaceAtm())
                    .canIssueCredit(bankOfficeResponseDto.getCanIssueCredit())
                    .canDispenseMoney(bankOfficeResponseDto.getCanDispenseMoney())
                    .canAcceptMoney(bankOfficeResponseDto.getCanAcceptMoney())
                    .build();
        }
    }
}
