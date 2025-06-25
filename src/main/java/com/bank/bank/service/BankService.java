package com.bank.bank.service;

import com.bank.bank.dto.BankIdRequest;
import com.bank.bank.dto.BankRequestDto;
import com.bank.bank.dto.ServerResponse;

public interface BankService {
    ServerResponse createBank(BankRequestDto bankRequestDto);
    ServerResponse updateBank(BankRequestDto bankRequestDto);
    ServerResponse deleteBank(BankIdRequest bankIdRequest);
    ServerResponse getBankById(BankIdRequest bankIdRequest);
    ServerResponse getAllBanks();


}
