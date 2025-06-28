package com.bank.bank.controller;

import com.bank.bank.constants.ApiConstants;
import com.bank.bank.dto.*;
import com.bank.bank.exception.NotFoundException;
import com.bank.bank.service.BankService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import static com.bank.bank.constants.ApiConstants.*;

@RestController
@RequestMapping(ApiConstants.BANK)
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;
    @PostMapping(CREATE)
    public ServerResponse<?> createBank(@Valid @RequestBody BankRequestDto bankRequestDto) {
        return bankService.createBank(bankRequestDto);
    }

    @PostMapping(UPDATE)
    public ServerResponse<?> updateBank(@Valid @RequestBody BankUpdateRequest bankUpdateRequest) {
        return bankService.updateBank(bankUpdateRequest);
    }

    @PostMapping(DELETE)
    public ServerResponse<?> deleteBank(@Valid @RequestBody  Long bankIdRequest) {
        return bankService.deleteBank(bankIdRequest);
    }

    @GetMapping(GET+BY+ID)
    public ServerResponse<?> getBankById(@Valid @RequestBody Long bankIdRequest) throws NotFoundException {
        return bankService.getBankById(bankIdRequest);
    }

    @GetMapping(GET+BY+NAME)
    public ServerResponse<?> getByBankName(@Valid @RequestBody String bankNameRequest) throws NotFoundException {
        return bankService.getByBankName(bankNameRequest);
    }

    @GetMapping(GET+ALL)
    public ServerResponse<?> getAllBanks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return bankService.getAllBanks(pageable);
    }
    @GetMapping(SORTING+DECENDING+DATE)
    public ServerResponse<?> getAllBanks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "establishedDate") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return bankService.getAllBanks(pageable);
    }
}
