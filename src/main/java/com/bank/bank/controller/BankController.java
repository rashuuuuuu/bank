package com.bank.bank.controller;

import com.bank.bank.dto.BankIdRequest;
import com.bank.bank.dto.BankRequestDto;
import com.bank.bank.dto.ServerResponse;
import com.bank.bank.service.BankService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;
    @PostMapping("/createBank")
    public ServerResponse<?> createBank(@Valid @RequestBody BankRequestDto bankRequestDto) {
        return bankService.createBank(bankRequestDto);
    }

    @PostMapping("/updateBank")
    public ServerResponse<?> updateBank(@Valid @RequestBody BankRequestDto bankRequestDto) {
        return bankService.updateBank(bankRequestDto);
    }

    @PostMapping("/deleteBank")
    public ServerResponse<?> deleteBank(@Valid @RequestBody BankIdRequest bankIdRequest) {
        return bankService.deleteBank(bankIdRequest);
    }

    @GetMapping("/getBankById")
    public ServerResponse<?> getBankById(@Valid @RequestBody BankIdRequest bankIdRequest) {
        return bankService.getBankById(bankIdRequest);
    }

    @GetMapping("/getAllBanks")
    public ServerResponse<?> getAllBanks() {
        return bankService.getAllBanks();
    }
}
