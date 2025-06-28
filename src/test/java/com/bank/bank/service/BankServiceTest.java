//package com.bank.bank.service;
//
//import com.bank.bank.BankMapper.BankMapper;
//import com.bank.bank.dto.BankResponseDto;
//import com.bank.bank.dto.ServerResponse;
//import com.bank.bank.entities.Bank;
//import com.bank.bank.exception.NotFoundException;
//import com.bank.bank.service.serviceImpl.BankServiceImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//public class BankServiceTest {
//    @InjectMocks
//    BankServiceImpl bankService;
//    @Mock
//    BankMapper bankMapper;
//    @Test
//    public void getById() throws NotFoundException {
//        System.out.println("my first test");
//        BankResponseDto bankResponseDto = bankMapper.getDetailsById(2L);
//        ServerResponse response = bankService.getBankById(2L);
//        System.out.println(bankResponseDto);
//        System.out.println(response);
//        Assertions.assertNotNull(response);
//    }
//}