package com.bank.bank.entities;

import com.bank.bank.entities.abstractentity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "bank")
public class Bank extends AbstractEntity {

    @Column(name = "code", nullable = false)
    private String bankCode;

    @Column(name = "name", nullable = false)
    private String bankName;

    @Column(name = "address", nullable = false)
    private String bankAddress;

    @Column(name = "branch_code", nullable = false)
    private String branchCode;

    @Column(name = "established_date", nullable = false)
    private Date establishedDate;

    @Column(name = "bank_status")
    @Enumerated(EnumType.STRING)
    private StatusConstants status;

//    @JoinColumn(name = "bank_type", referencedColumnName = "id", nullable = false)
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private BankType bankType;

}

