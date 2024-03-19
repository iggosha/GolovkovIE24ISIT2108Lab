package tech.reliab.course.golovkovie.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.reliab.course.golovkovie.bank.model.dto.request.BankRequestDto;
import tech.reliab.course.golovkovie.bank.model.dto.response.BankResponseDto;
import tech.reliab.course.golovkovie.bank.service.BankService;

@Controller
@AllArgsConstructor
@RequestMapping("banklab/")
public class BankController {

    private static final String REDIRECT_BANKS = "redirect:/banklab/banks";
    private static final String REDIRECT_BANK = "redirect:/banklab/banks/{id}";
    private final BankService bankService;

    @PostMapping({"banks", "/banks"})
    public String postBank(@ModelAttribute("bankRequest") BankRequestDto bankRequestDto) {
        bankService.create(bankRequestDto);
        return REDIRECT_BANKS;
    }

    @GetMapping({"banks", "/banks"})
    public String getBanks(Model model, @ModelAttribute("bankRequestDto") BankRequestDto bankRequestDto) {
        model.addAttribute("bankResponseDtos", bankService.getAll());
        return "bank/banks_page";
    }

    @GetMapping({"banks/{id}", "/banks/{id}/"})
    public String getBank(Model model, @PathVariable("id") Long id) {
        model.addAttribute("bankResponseDto", bankService.getById(id));
        return "bank/item_bank_page";
    }

    @PutMapping({"banks/{id}", "/banks/{id}/"})
    public String putBank(@PathVariable("id") Long id, @ModelAttribute("bankResponse") BankResponseDto bankResponseDto) {
        bankService.update(bankResponseDto);
        return REDIRECT_BANK;
    }

    @DeleteMapping({"banks/{id}", "/banks/{id}/"})
    public String deleteBank(@PathVariable("id") Long id) {
        bankService.deleteById(id);
        return REDIRECT_BANKS;
    }
}
