package com.bank.bank.service.serviceImpl;

import com.bank.bank.BankMapper.BankMapper;
import com.bank.bank.dto.*;
import com.bank.bank.entities.Bank;
import com.bank.bank.exception.NotFoundException;
import com.bank.bank.repository.BankRepository;
import com.bank.bank.service.BankService;
import com.bank.bank.util.ResponseUtility;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private final BankMapper bankMapper;

    @Autowired
   private final ModelMapper modelMapper;
    @Autowired
    private final BankRepository bankRepository;

    public BankServiceImpl(BankMapper bankMapper, ModelMapper modelMapper, BankRepository bankRepository) {
        this.bankMapper = bankMapper;
        this.modelMapper = modelMapper;
        this.bankRepository = bankRepository;
    }

    @Override
    public ServerResponse createBank(BankRequestDto bankRequestDto) {
        bankMapper.saveBankDetails(bankRequestDto);
        return ResponseUtility.getSuccessfulServerResponse("Bank Created Successfully");
    }

    @Override
    public ServerResponse updateBank(BankUpdateRequest bankUpdateRequest) {
        bankMapper.updateBankDetails(bankUpdateRequest);
        return ResponseUtility.getSuccessfulServerResponse("Bank Updated Successfully");
    }

    @Override
    public ServerResponse deleteBank(Long bankIdRequest) {
        bankMapper.deleteBank(bankIdRequest);
        return ResponseUtility.getSuccessfulServerResponse("Bank Deleted Successfully");
    }

    @Override
    public ServerResponse getBankById(Long bankIdRequest) throws NotFoundException {
        return ResponseUtility.getSuccessfulServerResponse(
                bankMapper.getDetailsById(bankIdRequest),
                "Presenting Bank Details"
        );
    }



    @Override
    public ServerResponse getAllBanks(Pageable pageable) {
        Page<Bank> bankPage = bankRepository.findAll( pageable);
        List<BankResponseDto> bankResponseDtos = bankPage.stream()
                .map(bank -> modelMapper.map(bank, BankResponseDto.class))
                .collect(Collectors.toList());

        return ResponseUtility.getSuccessfulServerResponse(
                new PagingResponse<>(
                        bankResponseDtos,
                        bankPage.getTotalPages(),
                        bankPage.getTotalElements(),
                        bankPage.getSize(),
                        bankPage.getNumber(),
                        bankPage.isEmpty()
                ), "All Banks Found");
    }

    @Override
    public ServerResponse getByBankName(String bankNameRequest) throws NotFoundException {
        return ResponseUtility.getSuccessfulServerResponse(
                bankMapper.getByBankName(bankNameRequest),
                "Presenting Bank Details"
        );
    }


}
