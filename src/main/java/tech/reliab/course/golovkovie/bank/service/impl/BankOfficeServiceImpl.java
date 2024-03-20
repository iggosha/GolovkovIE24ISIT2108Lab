package tech.reliab.course.golovkovie.bank.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.reliab.course.golovkovie.bank.model.dto.request.BankOfficeRequestDto;
import tech.reliab.course.golovkovie.bank.model.dto.response.BankOfficeResponseDto;
import tech.reliab.course.golovkovie.bank.model.entity.BankOffice;
import tech.reliab.course.golovkovie.bank.repository.BankOfficeRepository;
import tech.reliab.course.golovkovie.bank.repository.BankRepository;
import tech.reliab.course.golovkovie.bank.service.BankOfficeService;
import tech.reliab.course.golovkovie.bank.utlis.MappingUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class BankOfficeServiceImpl implements BankOfficeService {

    private final BankRepository bankRepository;
    private final BankOfficeRepository bankOfficeRepository;
    private final MappingUtils mappingUtils;

    @Override
    @Transactional
    public void create(BankOfficeRequestDto bankOfficeRequestDto,
                       Long bankId) {
        BankOffice bankOffice = BankOffice
                .builder()
                .name(bankOfficeRequestDto.getName())
                .address(bankOfficeRequestDto.getAddress())
                .totalMoney(bankOfficeRequestDto.getTotalMoney())
                .rentCost(bankOfficeRequestDto.getRentCost())
                .isWorking(bankOfficeRequestDto.getIsWorking())
                .canPlaceAtm(bankOfficeRequestDto.getCanPlaceAtm())
                .canIssueCredit(bankOfficeRequestDto.getCanIssueCredit())
                .canDispenseMoney(bankOfficeRequestDto.getCanDispenseMoney())
                .canAcceptMoney(bankOfficeRequestDto.getCanAcceptMoney())
                .bankAtms(new ArrayList<>())
                .employees(new ArrayList<>())
                .bank(bankRepository.findById(bankId).orElse(null))
                .build();
        bankOfficeRepository.save(bankOffice);
    }

    @Override
    public BankOfficeResponseDto getById(Long id) {
        return mappingUtils.
                mapToBankOfficeResponseDto(bankOfficeRepository.findById(id)
                        .orElse(null));
    }

    @Override
    public List<BankOfficeResponseDto> getAllByBankId(Long bankId) {
        return bankOfficeRepository.findAllByBank_Id(bankId)
                .stream()
                .map(mappingUtils::mapToBankOfficeResponseDto)
                .toList();
    }

    @Override
    @Transactional
    public void update(BankOfficeResponseDto bankOfficeResponseDto, Long bankId) {
        BankOffice bankOffice = mappingUtils.mapToBankOfficeEntity(bankOfficeResponseDto);
        bankOffice.setBank(bankRepository.findById(bankId).orElse(null));
        bankOfficeRepository.save(bankOffice);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        bankOfficeRepository.deleteById(id);
    }
}
