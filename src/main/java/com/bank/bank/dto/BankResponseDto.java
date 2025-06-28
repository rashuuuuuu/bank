package com.bank.bank.dto;
import com.bank.bank.entities.StatusConstants;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class BankResponseDto {
    private StatusConstants status;
    private String bankName;
    private String address;
    private String branchCode;
    private String establishedDate;
}
