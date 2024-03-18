package tech.reliab.course.golovkovie.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.reliab.course.golovkovie.bank.service.BankService;

@Controller
@AllArgsConstructor
@RequestMapping("banklab/")
public class BankController {

    private final BankService bankService;

    @GetMapping({"banks", "/banks"})
    public String getBanks(Model model) {
        model.addAttribute("bankDtos", bankService.getAllDto());
        return "banks_page";
    }
}
