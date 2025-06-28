package com.bank.bank.service;

import com.bank.bank.dto.BankRequestDto;
import com.bank.bank.dto.BankUpdateRequest;
import com.bank.bank.dto.ServerResponse;

import com.bank.bank.exception.NotFoundException;
import org.springframework.data.domain.Pageable;

public interface BankService {
    ServerResponse createBank(BankRequestDto bankRequestDto);
    ServerResponse updateBank(BankUpdateRequest bankUpdateRequest);
    ServerResponse deleteBank(Long bankIdRequest);
    ServerResponse getBankById(Long bankIdRequest) throws NotFoundException;
    ServerResponse getAllBanks(Pageable pageable);
    ServerResponse getByBankName(String bankName) throws NotFoundException;


}