package com.bank.bank.dto;

import com.bank.bank.entities.ModelBase;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class BankIdRequest extends ModelBase {
    private Long bankId;
}
