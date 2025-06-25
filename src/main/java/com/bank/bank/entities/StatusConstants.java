package com.bank.bank.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusConstants{
//    DELETED("deleted",4),
//    UPDATED("updated",3),
//    CREATED("created",1),
//    PENDING("pending",2),
//    BLOCKED("blocked",5);
    ACTIVE("active",1),
    INACTIVE("inactive",2);
    private final String name;
    private final int id;
}

