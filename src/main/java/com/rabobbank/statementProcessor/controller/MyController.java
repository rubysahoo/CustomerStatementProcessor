package com.rabobbank.statementProcessor.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rabobbank.statementProcessor.bean.Customer;
import com.rabobbank.statementProcessor.bean.Result;
import com.rabobbank.statementProcessor.service.CustomerService;

@RestController
public class MyController {
	@Autowired
	Result res;

	@Autowired
	CustomerService service;

	@PostMapping("/process")
	@ResponseBody
	public Result parseRequest(@RequestBody ArrayList<Customer> cust) {
		res = service.parseRequest(cust);
		return res;

	}

}
