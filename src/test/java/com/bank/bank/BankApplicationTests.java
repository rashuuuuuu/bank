package com.bank.bank;
import com.bank.bank.dto.ServerResponse;
import com.bank.bank.exception.NotFoundException;
import com.bank.bank.service.BankService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BankServiceTests {

	@Autowired
	private BankService bankService;

	@Test
	void getById() throws NotFoundException {
		ServerResponse response = bankService.getBankById(1L);
		assertNotNull(response);
	}
}