package com.bank.bank.entities;

import com.bank.bank.entities.abstractentity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bank_status")
public class BankStatus extends AbstractEntity {
        @Column(name = "name", nullable = false, unique = true)
        private String name;

        @Column(name = "description", nullable = false)
        private String description;

        @Column(name = "icon")
        private String icon;



    }


