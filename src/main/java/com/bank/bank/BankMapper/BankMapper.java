package com.bank.bank.BankMapper;

import com.bank.bank.dto.BankIdRequest;
import com.bank.bank.dto.BankRequestDto;
import com.bank.bank.dto.BankResponseDto;
import com.bank.bank.entities.Bank;
import com.bank.bank.entities.BankStatus;
import com.bank.bank.entities.StatusConstants;
import com.bank.bank.repository.BankRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.mapstruct.ap.internal.conversion.ConversionUtils.uuid;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankMapper {
    private final BankRepository bankRepository;
    /**
     * this is bank mapper to provide only required data to user
     */
    @Autowired
    private final ModelMapper modelMapper;

    public Bank saveBankDetails(BankRequestDto bankRequestDto) {
        Bank bank = new Bank();
        bank.setBankName(bankRequestDto.getBankName());
        bank.setBankAddress(bankRequestDto.getBankAddress());
        bank.setBankCode(UUID.randomUUID().toString());
        bank.setEstablishedDate(bankRequestDto.getEstablishedDate());
        bank.setBranchCode(bankRequestDto.getBranchCode());
        bank.setStatus(StatusConstants.ACTIVE);
        return bankRepository.save(bank);
    }

    public Bank updateBankDetails(BankRequestDto bankRequestDto) {
        Bank bank = new Bank();
        if (bankRequestDto.getBankName() != null) {
            bank.setBankName(bankRequestDto.getBankName());
            bank.setBankAddress(bankRequestDto.getBankAddress());
            bank.setBankCode(bankRequestDto.getBranchCode());
            bank.setEstablishedDate(bankRequestDto.getEstablishedDate());
        }
        return bankRepository.save(bank);
        }

    public List<BankResponseDto> getDetailsById(BankIdRequest bankIdRequest) {
        Long bankId = bankIdRequest.getBankId();
        Optional<Bank> optionalBank = bankRepository.getBankDetailsById(bankId);

        return optionalBank
                .map(bank -> modelMapper.map(bank, BankResponseDto.class))
                .map(List::of)
                .orElse(Collections.emptyList());
    }



    public void deleteBank(BankIdRequest bankIdRequest) {
        Optional<Bank> bankOptional = bankRepository.findById(Long.valueOf(bankIdRequest.getBankId()));

        if (bankOptional.isPresent()) {
            Bank foundBank = bankOptional.get();
            foundBank.setStatus(StatusConstants.INACTIVE);
            bankRepository.save(foundBank);
        } else {
            System.out.println("Bank does not exist");
        }
    }
    public List<BankResponseDto> getAllDetails() {
        List<Bank> banks = bankRepository.findAll();

        return banks.stream()
                .map(bank -> modelMapper.map(bank, BankResponseDto.class))
                .collect(Collectors.toList());
    }

    }




