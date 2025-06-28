package com.bank.bank.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class BankUpdateRequest {
    @NotNull
    private String bankName;

    private String branchCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/d")
    private Date establishedDate;

    private String bankAddress;
}
