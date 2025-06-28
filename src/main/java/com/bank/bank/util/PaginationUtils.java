package com.bank.bank.util;

import com.bank.bank.dto.PaginationRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaginationUtils {

    public static Pageable getPageable(PaginationRequest request) {
        return (Pageable) PageRequest.of(request.getPage(), request.getSize(), request.getDirection(), request.getSortField());
    }
}