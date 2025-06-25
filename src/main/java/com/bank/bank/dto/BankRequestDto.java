package com.bank.bank.dto;
import com.bank.bank.Aspect.UniqueBankCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankRequestDto {
    @NotNull(message="bank name cannot be null")
    private String bankName;

    @NotNull(message="branch code is mandatary")
    @Size(min=5,max=10)
    @UniqueBankCode(message="bank code must be unique")
    @Pattern(regexp = "^[A-Z]{2}[0-9]{4}$", message = "Must be 2 uppercase letters followed by 4 digits")
    private String branchCode;

    @NotNull(message="Established Date can't be null")
    @PastOrPresent(message="Established Date can't be in future")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/d")
    private Date establishedDate;

    @NotNull(message="bank address can't be null")
    private String bankAddress;
}
