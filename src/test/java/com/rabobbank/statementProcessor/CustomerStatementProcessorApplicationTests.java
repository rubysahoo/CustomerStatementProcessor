package com.rabobbank.statementProcessor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.rabobbank.statementProcessor.bean.Customer;
import com.rabobbank.statementProcessor.bean.Result;
import com.rabobbank.statementProcessor.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@EnableWebMvc
@ContextConfiguration(classes = CustomerService.class)
@SpringBootTest
class CustomerStatementProcessorApplicationTests {
	@Autowired
	CustomerService service;

	@Test
	void parseCustomrerTest() {
		ArrayList<Customer> list = new ArrayList<Customer>();
		Customer c1 = new Customer(2237, "0012A3B", "testing", 45, 56, 62);
		Customer c2 = new Customer(2237, "0012A4B", "testing", 45, 66, 62);
		list.add(c1);
		list.add(c2);

		Result result = service.parseRequest(list);
		assertEquals(result,
				"{\n" + " \"result\" : \" INCORRECT_END_BALANCE\",\n" + " \"errorRecords\" : [\n" + " {\n"
						+ " “reference\": reference_of_error_record,\n"
						+ " \"accountNumber\":\"account_number_of_error_record\",\n" + " }\n" + " ]\n" + "}");

	}

}
