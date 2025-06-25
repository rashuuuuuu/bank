package com.bank.bank.service.serviceImpl;

import com.bank.bank.BankMapper.BankMapper;
import com.bank.bank.dto.BankIdRequest;
import com.bank.bank.dto.BankRequestDto;
import com.bank.bank.dto.ServerResponse;
import com.bank.bank.service.BankService;
import com.bank.bank.util.ResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    BankMapper bankMapper;

    @Override
    public ServerResponse createBank(BankRequestDto bankRequestDto) {
        bankMapper.saveBankDetails(bankRequestDto);
        return ResponseUtility.getSuccessfulServerResponse("Bank Created Successfully");
    }

    @Override
    public ServerResponse updateBank(BankRequestDto bankRequestDto) {
        bankMapper.updateBankDetails(bankRequestDto);
        return ResponseUtility.getSuccessfulServerResponse("Bank Updated Successfully");
    }

    @Override
    public ServerResponse deleteBank(BankIdRequest bankIdRequest) {
        bankMapper.deleteBank(bankIdRequest);
        return ResponseUtility.getSuccessfulServerResponse("Bank Deleted Successfully");
    }

    @Override
    public ServerResponse getBankById(BankIdRequest bankIdRequest) {
        bankMapper.getDetailsById(bankIdRequest);
        return ResponseUtility.getSuccessfulServerResponse("Presenting Bank Details");
    }

    @Override
    public ServerResponse getAllBanks() {
        bankMapper.getAllDetails();
        return ResponseUtility.getSuccessfulServerResponse("All Bank Details");
    }
}
