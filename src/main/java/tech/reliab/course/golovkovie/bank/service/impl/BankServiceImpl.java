package tech.reliab.course.golovkovie.bank.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.reliab.course.golovkovie.bank.model.dto.request.BankRequestDto;
import tech.reliab.course.golovkovie.bank.model.dto.response.BankResponseDto;
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
@Transactional(readOnly = true)
public class BankServiceImpl implements BankService {

    private static final Random random = new Random();
    private final BankRepository bankRepository;
    private final MappingUtils mappingUtils;

    @Override
    @Transactional
    public void create(BankRequestDto bankRequestDto) {
        Bank bank = Bank.builder()
                .name(bankRequestDto.getName())
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
    public BankResponseDto getById(Long id) {
        return mappingUtils.mapToBankResponseDto(
                bankRepository.findById(id)
                        .orElse(new Bank())
        );
    }

    @Override
    public List<BankResponseDto> getAll() {
        return bankRepository.findAll()
                .stream()
                .map(mappingUtils::mapToBankResponseDto)
                .toList();
    }

    @Override
    @Transactional
    public void update(BankResponseDto bankResponseDto) {
        Bank bank = mappingUtils.mapToBankEntity(bankResponseDto);
        bankRepository.save(bank);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        bankRepository.deleteById(id);
    }
}
