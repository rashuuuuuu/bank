package com.bank.bank.entities;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

public class ModelBase implements Serializable {

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
