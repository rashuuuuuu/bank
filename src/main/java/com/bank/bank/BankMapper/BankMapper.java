package com.bank.bank.BankMapper;
import com.bank.bank.dto.BankRequestDto;
import com.bank.bank.dto.BankResponseDto;
import com.bank.bank.dto.BankUpdateRequest;
import com.bank.bank.entities.Bank;
import com.bank.bank.entities.StatusConstants;
import com.bank.bank.exception.NotFoundException;
import com.bank.bank.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;


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

    public Bank updateBankDetails(BankUpdateRequest bankUpdateRequest) {

        String bankName = bankUpdateRequest.getBankName();
        Bank bank = bankRepository.getByBankName(bankName);
        if (bankUpdateRequest.getBankName() != null) {
            bank.setBankName(bankUpdateRequest.getBankName());
            bank.setBankAddress(bankUpdateRequest.getBankAddress());
            bank.setBankCode(bankUpdateRequest.getBranchCode());
            bank.setEstablishedDate(bankUpdateRequest.getEstablishedDate());
        }
        return bankRepository.save(bank);
    }

    public BankResponseDto getDetailsById(Long bankIdRequest) throws NotFoundException {

        Bank bank = bankRepository.getBankDetailsById(bankIdRequest)
                .orElseThrow(() -> new NotFoundException("Bank not found"));

        if (bank.getStatus() != StatusConstants.ACTIVE || bank.getBankCode() == null) {
            throw new NotFoundException("Bank is inactive or missing bank code");
        }

        return modelMapper.map(bank, BankResponseDto.class);
    }

    public BankResponseDto getByBankName(String bankNameRequest)throws NotFoundException {
        Bank bank = bankRepository.getBankDetailsByBankNameIgnoreCase(bankNameRequest)
                .orElseThrow(() -> new NotFoundException("Bank not found"));

        if (bank.getStatus() != StatusConstants.ACTIVE || bank.getBankCode() == null) {
            throw new NotFoundException("Bank is inactive or missing bank code");
        }
        return modelMapper.map(bank, BankResponseDto.class);
    }

    public void deleteBank(Long bankIdRequest) {
        Optional<Bank> bankOptional = bankRepository.findById(bankIdRequest);

        if (bankOptional.isPresent()) {
            Bank foundBank = bankOptional.get();
            foundBank.setStatus(StatusConstants.INACTIVE);
            bankRepository.save(foundBank);
        } else {
            System.out.println("Bank does not exist");
        }
    }

}




