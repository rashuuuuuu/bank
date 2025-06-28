package com.bank.bank.repository;

import com.bank.bank.entities.Bank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    boolean existsByBankCode(String bankCode);

    @Query("SELECT b FROM Bank b WHERE b.bankName = :bankName AND b.status = com.bank.bank.entities.StatusConstants.ACTIVE AND b.bankCode IS NOT NULL")
    Optional<Bank> getBankDetailsByBankNameIgnoreCase(@Param("bankName") String bankName);

    @Query("SELECT b FROM Bank b WHERE b.id = :bankId AND b.status = com.bank.bank.entities.StatusConstants.ACTIVE AND b.bankCode IS NOT NULL")
    Optional<Bank> getBankDetailsById(@Param("bankId") Long bankId);

    Page<Bank> findAll(Pageable pageable);

    Bank getByBankName(String bankName);

}
