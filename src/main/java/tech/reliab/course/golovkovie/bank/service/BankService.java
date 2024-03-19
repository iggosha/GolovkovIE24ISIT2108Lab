package tech.reliab.course.golovkovie.bank.service;

import tech.reliab.course.golovkovie.bank.model.dto.request.BankRequestDto;
import tech.reliab.course.golovkovie.bank.model.dto.response.BankResponseDto;

import java.util.List;

/**
 * The interface Bank service.
 */
public interface BankService {

    void create(BankRequestDto bankRequestDto);

    BankResponseDto getById(Long id);

    List<BankResponseDto> getAll();

    void update(BankResponseDto bankResponseDto);

    void deleteById(Long id);
}
