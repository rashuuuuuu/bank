package com.bank.bank.repository;

import com.bank.bank.dto.BankIdRequest;
import com.bank.bank.dto.BankResponseDto;
import com.bank.bank.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    boolean existsByBankCode(String bankCode);
    Optional<Bank> findByBankCode(String bankCode);
   Optional<Bank> getBankDetailsById(Long bankIdRequest);
}
